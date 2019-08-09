package com.gaoh.mybatisplus.annotation;

/**
 * @author gaoh
 * @version 1.0
 * @date 2019/8/9 11:50
 *
 * 操作类型
 */
public enum OperationType {
    SPACE(""),
    INSERT("增加"),
    DELETE("删除"),
    UPDATE("修改"),
    QUERY("查询");

    private String description;


    OperationType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
