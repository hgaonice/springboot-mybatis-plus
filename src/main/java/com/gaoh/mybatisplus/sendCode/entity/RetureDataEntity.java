package com.zccs.assets_management.sendCode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * <P>
 *     返回的数据实体
 * </P>
 * @author gaoh
 * @version 1.0
 * @date 2019/9/3 20:29
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RetureDataEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String resCode;//返回的状态码
    private String resMag;//返回的提示消息
    private List<T> data;//返回的数据

}
