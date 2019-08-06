package com.gaoh.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gaoh.mybatisplus.entity.SysUserEntity;
import com.gaoh.mybatisplus.mapper.SysUserMapper;
import com.gaoh.mybatisplus.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author gaoh
 * @since 2019-08-06
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements ISysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUserEntity> selectList() {
        Wrapper<SysUserEntity> list = new QueryWrapper<>();
        List<SysUserEntity> sysUserEntities = sysUserMapper.selectList(list);
        log.info("listLen" + sysUserEntities.size());
        return sysUserEntities;
    }
}
