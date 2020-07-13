package com.wxh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxh.mapper.UserInfoMapper;
import com.wxh.model.UserInfo;
import com.wxh.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserInfoServiceImpl
 * @Description: 用户信息接口实现类
 * @Author wxh
 * @Date: 2020/7/13 16:15
 * @Version V1.0.0
 * @Since 1.8
 */
@Service(value = "userInfoService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
