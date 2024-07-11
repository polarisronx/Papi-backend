package com.polaris.project.controller;


import com.polaris.common.exception.BusinessException;
import com.polaris.common.exception.ErrorCode;
import com.polaris.common.util.BaseResponse;
import com.polaris.common.util.ResultUtils;
import com.polaris.project.manager.impl.RedisLockManager;
import com.polaris.project.model.vo.UserVO;
import com.polaris.project.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.redis.connection.BitFieldSubCommands;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.polaris.project.constant.CommonConstant.SIGN_IN_REWARD;
import static com.polaris.project.constant.RedisConstant.DAILY_SIGN_IN_KEY_PREFIX;
import static com.polaris.project.constant.RedisConstant.DAILY_SIGN_IN_LOCK_PREFIX;

/**
 * @author polaris
 * @version 1.0
 * ClassName DailySignIn
 * Package com.polaris.project.controller
 * Description 每日签到
 * @date 2024-05-19 22:38
 */
@RestController
@RequestMapping("/dailySignIn")
@Slf4j
@Tag(name = "每日签到")
public class DailySignInController {

    @Resource
    private UserService userService;
    @Resource
    private RedisLockManager redisLockManager;
    @Resource
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/")
    @Transactional(rollbackFor = Exception.class)
    @Operation(summary = "每日签到")
    public BaseResponse<Boolean> doDailySignIn() {
        UserVO loginUser = userService.getLoginUser();
        String redissonLock = (DAILY_SIGN_IN_LOCK_PREFIX + loginUser.getId()).intern();
        return redisLockManager.redissonDistributedLocks(redissonLock, () -> {
            // 1 获取key
            String key = getKey(loginUser).intern();
            // 2.获取今天是本月的第几天
            int dayOfMonth = getDayOfMonth();
            // 3 查询是否已经签到
            Boolean bit = stringRedisTemplate.opsForValue().getBit(key, dayOfMonth - 1);
            if(ObjectUtils.isNotEmpty(bit) && bit){
                throw new BusinessException(ErrorCode.OPERATION_ERROR, "今日已签到，请明日再来~");
            }
            // 4.签到，将对应的天数位置设置为 true
            stringRedisTemplate.opsForValue().setBit(key, dayOfMonth - 1, true);
            // 5.增加积分
            boolean res = userService.updatePoint(SIGN_IN_REWARD);
            if (!res) {
                throw new BusinessException(ErrorCode.OPERATION_ERROR);
            }
            return ResultUtils.success(true);
        }, "签到失败");
    }
    /**
     * @Description 检查是否签到，若已签到返回本月签到的天数
     * @author polaris
     * @date 2024/5/20
     * @return {@link BaseResponse< Integer>}
     */

    @GetMapping("/check")
    @Operation(summary = "检查是否签到")
    public BaseResponse<Integer> checkSignIn() {
        UserVO loginUser = userService.getLoginUser();
        // 1 获取key
        String key = getKey(loginUser).intern();
        // 2.获取今天是本月的第几天
        int dayOfMonth = getDayOfMonth();
        // 3 查询是否已经签到
        Boolean bit = stringRedisTemplate.opsForValue().getBit(key, dayOfMonth - 1);
        if(bit==null||!bit){
            return  ResultUtils.success(-1);// 今天还没签到
        }
        // 4 今天已经签到，统计本月签到次数
        List<Long> result = stringRedisTemplate.opsForValue().bitField(
                key,
                BitFieldSubCommands.create()
                .get(BitFieldSubCommands.BitFieldType.unsigned(dayOfMonth)).valueAt(0)
        );
        if (result == null || result.isEmpty()) {
            // 没有任何签到结果
            return ResultUtils.success(0);
        }
        Long num = result.get(0);
        if (num == null || num == 0) {
            return ResultUtils.success(0);
        }
        // 循环遍历
        int count = 0;
        // 如果为0，说明未签到，结束
        // 如果不为0，说明已签到，计数器+1
        while ((num & 1) != 0){
            // 6.1.让这个数字与1做与运算，得到数字的最后一个bit位  // 判断这个bit位是否为0
            count++;
            // 把数字右移一位，抛弃最后一个bit位，继续下一个bit位
            num >>>= 1;
        }
        return ResultUtils.success(count);
    }
    private String getKey(UserVO user) {
        // 1.获取日期
        LocalDateTime now = LocalDateTime.now();
        // 2.拼接key
        String keySuffix = now.format(DateTimeFormatter.ofPattern(":yyyyMM"));
        return DAILY_SIGN_IN_KEY_PREFIX + user.getId() + keySuffix;
    }
    private int getDayOfMonth(){
        LocalDateTime now = LocalDateTime.now();
        return now.getDayOfMonth();
    }

}
