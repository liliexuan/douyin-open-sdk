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
    private String errNo;

    /**
     * 响应编码描述
     */
    private String errTips;


    private Map<String, Serializable> data;

    public String getErrNo() {
        return errNo;
    }

    public void setErrNo(String errNo) {
        this.errNo = errNo;
    }

    public String getErrTips() {
        return errTips;
    }

    public void setErrTips(String errTips) {
        this.errTips = errTips;
    }

    public Map<String, Serializable> getData() {
        return data;
    }

    public void setData(Map<String, Serializable> data) {
        this.data = data;
    }
}
