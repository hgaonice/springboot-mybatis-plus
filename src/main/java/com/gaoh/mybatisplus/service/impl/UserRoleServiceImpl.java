package com.gaoh.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gaoh.mybatisplus.entity.UserRoleEntity;
import com.gaoh.mybatisplus.mapper.UserRoleMapper;
import com.gaoh.mybatisplus.service.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author gaoh
 * @since 2019-08-06
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRoleEntity> implements IUserRoleService {

}
