package com.gaoh.mybatisplus.controller;


import com.gaoh.mybatisplus.entity.PapersEntity;
import com.gaoh.mybatisplus.service.impl.PapersServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author gaoh
 * @since 2019-07-29
 */
@RestController
@RequestMapping("/papers")
public class PapersController {
    @Resource
    private PapersServiceImpl papersService;

    @RequestMapping("/getById")
    public PapersEntity getById(@RequestBody PapersEntity papers) {
        return papersService.getById(papers);
    }


}
