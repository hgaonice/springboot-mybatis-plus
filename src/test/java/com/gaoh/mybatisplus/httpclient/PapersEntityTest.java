package com.gaoh.mybatisplus.httpclient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author gaoh
 * @since 2019-07-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PapersEntityTest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    private Integer ids;

    /**
     * 文件对象的Id 合同对象的Id或者UUid
     */
    private String objCode;

    /**
     * 文件对象的类型  经营  外包
     */
    private String objType;

    /**
     * 文件名称
     */
    private String filename;

    /**
     * 文件类型(01 图片 02 PDF)
     */
    private String filetype;

    /**
     * 文件大小  KB
     */
    private Integer filesize;

    /**
     * 文件路径  相对路径
     */
    private String fileurl;

    /**
     * 所在文件夹
     */
    private String filepath;

    /**
     * 后缀名 pdf jpg
     */
    private String suffixname;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 扩展字段1
     */
    private String reserve1;

    /**
     * 扩展字段2
     */
    private String reserve2;

    /**
     * 扩展字段3
     */
    private String reserve3;


}
