package com.gaoh.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gaoh.mybatisplus.entity.PapersEntity;
import com.gaoh.mybatisplus.mapper.PapersMapper;
import com.gaoh.mybatisplus.service.IPapersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author gaoh
 * @since 2019-07-29
 */
@Service
public class PapersServiceImpl extends ServiceImpl<PapersMapper, PapersEntity> implements IPapersService {
    @Resource
    private IPapersService iPapersService;

    @Resource
    private PapersMapper papersMapper;


    public PapersEntity getById(PapersEntity papersEntity) {
        BaseMapper<PapersEntity> baseMapper = iPapersService.getBaseMapper();
        return baseMapper.selectById(papersEntity);
    }

    public void insertPaper(PapersEntity papers) {
        iPapersService.save(papers);

        Wrapper<PapersEntity> queryWrapper = new QueryWrapper<>();
        ((QueryWrapper<PapersEntity>) queryWrapper).eq("12", 123);
        Wrapper<PapersEntity> updateWrapper = new UpdateWrapper<>();
        papersMapper.selectCount(queryWrapper);
    }

}
