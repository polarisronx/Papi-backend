package com.polaris.project.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.polaris.common.entity.UserInterfaceInfo;

import java.util.List;

/**
* @author Administrator
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Mapper
* @createDate 2024-03-21 21:31:26
* @Entity com.polaris.project.model.entity.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {
    /*
     * 返回调用次数前 {limit} 的接口信息
     * @param null
     * @return
     * @author polaris
     * @create 2024/3/28
     **/
    List<UserInterfaceInfo> listTopInterface(int limit);

}




