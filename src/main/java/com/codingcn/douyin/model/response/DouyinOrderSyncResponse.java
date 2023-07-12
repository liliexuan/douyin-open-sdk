package com.codingcn.douyin.model.response;

import java.io.Serializable;
import java.util.Map;

/**
 * 抖音订单同步响应
 *
 * @author liexuan
 * @date 2023-07-12 16:48
 **/
public class DouyinOrderSyncResponse implements Serializable {

    /**
     * 错误码
     */
    private String errCode;
    /**
     * 错误提示
     */
    private String errMsg;

    /**
     * 小程序普通订单，body为空
     */
    private Map<String, Serializable> body;


    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Map<String, Serializable> getBody() {
        return body;
    }

    public void setBody(Map<String, Serializable> body) {
        this.body = body;
    }
}
