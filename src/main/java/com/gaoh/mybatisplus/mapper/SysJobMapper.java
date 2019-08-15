package com.gaoh.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gaoh.mybatisplus.entity.SysJobModel;

import java.util.List;
import java.util.Map;

/**
 * @author gaoh
 * @version 1.0
 * @date 2019/8/15 9:26
 */
public interface SysJobMapper extends BaseMapper<SysJobModel> {

    List<Map<String, Object>> selectListBySQL(String sql);
}
