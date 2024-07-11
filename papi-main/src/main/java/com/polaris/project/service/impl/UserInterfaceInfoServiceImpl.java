package com.polaris.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.polaris.common.entity.InterfaceInfo;
import com.polaris.common.entity.User;
import com.polaris.common.entity.UserInterfaceInfo;
import com.polaris.common.exception.BusinessException;
import com.polaris.common.exception.ErrorCode;
import com.polaris.project.mapper.UserInterfaceInfoMapper;
import com.polaris.project.model.vo.UserVO;
import com.polaris.project.service.InterfaceInfoService;
import com.polaris.project.service.UserInterfaceInfoService;
import com.polaris.project.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.polaris.common.exception.ThrowUtils.throwIf;

/**
* @author Administrator
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Service实现
* @date 2024-03-21 21:31:26
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService{

    @Resource
    private UserService userService;
    @Resource
    private InterfaceInfoService interfaceInfoService;
    @Override
    public void validUserInterfaceInfo (UserInterfaceInfo userInterfaceInfo, boolean add){
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 如果是添加操作
        if (add){
            if (userInterfaceInfo.getInterfaceInfoId()<=0||userInterfaceInfo.getUserId()<=0){
                throw new BusinessException(ErrorCode.PARAMS_ERROR,"接口信息或用户不存在");
            }
        }
        if (userInterfaceInfo.getLeftNum()<0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"剩余调用次数不能小于0");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean invokeCount (long interfaceInfoId, long userId){
        if (interfaceInfoId<=0||userId<=0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"接口信息或用户不存在");
        }
        boolean save = true;
        boolean updateTotal=true;
        InterfaceInfo interfaceInfo = interfaceInfoService.getById(interfaceInfoId);
        Integer costs = interfaceInfo.getCosts();
        UserInterfaceInfo userInterfaceInfo = this.getOne(new QueryWrapper<UserInterfaceInfo>().eq("interfaceInfoId", interfaceInfoId).eq("userId", userId));
        if(userInterfaceInfo==null){
            save = this.save(new UserInterfaceInfo().builder().userId(userId).interfaceInfoId(interfaceInfoId).totalNum(1).build());
        }else {
            // 使用 UpdateWrapper 对象来构建更新条件
            UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("interfaceInfoId",interfaceInfoId);
            updateWrapper.eq("userId",userId);
            // setSql方法用于设置要更新的SQL语句
            updateWrapper.setSql("totalNum = totalNum + 1");
            updateTotal = this.update(updateWrapper);
        }
        // 扣除积分
        Long ownerId = interfaceInfo.getUserId();
        boolean updatePoint=true;
        if(ownerId!=userId){
            updatePoint = userService.update().setSql(String.format("points = points - %d",costs)).eq("id", userId).gt("points",0).update();
        }
        throwIf(!(save&&updatePoint&&updateTotal),ErrorCode.SYSTEM_ERROR,"用户积分异常");
        return true;
    }
}




