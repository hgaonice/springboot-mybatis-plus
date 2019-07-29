package com.gaoh.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gaoh.mybatisplus.entity.PapersEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gaoh
 * @since 2019-07-29
 */
@Repository
public interface PapersMapper extends BaseMapper<PapersEntity> {
    /**
     * 通用分页查询
     * @param sql
     * @return
     */
    List<Map<String, Object>> selectListBySQL(String sql);
}
