package com.gaoh.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gaoh.mybatisplus.entity.SysUserEntity;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author gaoh
 * @since 2019-08-06
 */
public interface ISysUserService extends IService<SysUserEntity> {

    List<SysUserEntity> selectList();

}
