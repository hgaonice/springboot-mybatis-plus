package com.gaoh.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gaoh.mybatisplus.entity.SysLogEntity;
import com.gaoh.mybatisplus.mapper.SysLogMapper;
import com.gaoh.mybatisplus.service.ISysLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志表 服务实现类
 * </p>
 *
 * @author gaoh
 * @since 2019-08-06
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLogEntity> implements ISysLogService {

}