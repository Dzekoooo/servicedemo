package com.wechat.servicedemo.entity;

import java.io.Serializable;
import java.util.Map;

/**
*@Author: ZhangZhe
*@Description       模板基类
*@Date: 2018/1/19
*/
public class WxTemplate implements Serializable{

    /**
     * 模板ID
     */
    private String template_id;

    /**
     * 目标
     */
    private String touser;

    /**
     * 目标点击模板信息后跳转的URL
     */
    private String url;

    /**
     * 字体颜色
     */
    private String topcolor;

    /**
     * 模板数据
     */
    private Map<String, TemplateData> data;

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }


    public String getTopcolor() {
        return topcolor;
    }

    public void setTopcolor(String topcolor) {
        this.topcolor = topcolor;
    }

    public Map<String, TemplateData> getData() {
        return data;
    }

    public void setData(Map<String, TemplateData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WxTemplate{" +
                "template_id='" + template_id + '\'' +
                ", touser='" + touser + '\'' +
                ", topcolor='" + topcolor + '\'' +
                ", data=" + data +
                '}';
    }
}
