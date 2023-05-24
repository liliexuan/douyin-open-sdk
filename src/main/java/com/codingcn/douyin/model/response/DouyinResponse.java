package com.codingcn.douyin.model.response;

import java.io.Serializable;
import java.util.Map;

/**
 * 抖音接口请求响应
 *
 * @author liexuan
 * @date 2023-05-18 13:44
 **/
public class DouyinResponse implements Serializable {

    /**
     * 响应编码
     */
    private Integer errNo;

    /**
     * 响应编码描述
     */
    private String errTips;


    private Map<String, Object> data;

    public Integer getErrNo() {
        return errNo;
    }

    public void setErrNo(Integer errNo) {
        this.errNo = errNo;
    }

    public String getErrTips() {
        return errTips;
    }

    public void setErrTips(String errTips) {
        this.errTips = errTips;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
