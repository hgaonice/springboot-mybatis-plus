package com.gaoh.mybatisplus.controller;


import com.gaoh.mybatisplus.entity.SysUserEntity;
import com.gaoh.mybatisplus.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author gaoh
 * @since 2019-08-06
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping(value = "/selectList")
    public List<SysUserEntity> selectList() {
        return sysUserService.selectList();
    }

}
