package com.gaoh.mybatisplus;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gaoh.mybatisplus.entity.PapersEntity;
import com.gaoh.mybatisplus.mapper.PapersMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MybatisPlusApplicationTests {

    @Resource
    private PapersMapper papersMapper;

    @Test
    public void contextLoads() {
        PapersEntity papersEntity = new PapersEntity();
        Wrapper<PapersEntity> queryWrapper = new QueryWrapper<>();
        ((QueryWrapper<PapersEntity>) queryWrapper).eq("ids", 38);
        papersEntity = papersMapper.selectOne(queryWrapper);
        log.info(JSONObject.toJSONString(papersEntity));
    }

}
