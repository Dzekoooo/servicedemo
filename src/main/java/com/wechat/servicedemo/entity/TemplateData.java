package com.wechat.servicedemo.entity;

import java.io.Serializable;

/**
*@Author: ZhangZhe
*@Description       模板数据
*@Date: 2018/1/19
*/
public class TemplateData implements Serializable {

    /**
     * 模板值
     */
    private String value;

    /**
     * 模板显示颜色
     */
    private String color;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "TemplateData{" +
                "value='" + value + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
