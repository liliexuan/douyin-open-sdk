package com.codingcn.douyin.model.enumeration;

import java.util.Objects;

/**
 * 抖音响应状态枚举
 *
 * @author liexuan
 * @date 2023-05-24 15:28
 **/
public enum ResponseCode {
    SUCCESS(ResponseCode.SUCCESS_CODE, "请求成功"),

    FAIL(ResponseCode.FAIL_CODE, "系统错误"),

    PARAM_REQUIRED(ResponseCode.PARAM_REQUIRED_CODE, "未传必要参数，请检查"),

    APPID_ERROR(ResponseCode.APPID_ERROR_CODE, "appid 错误"),

    SECRET_ERROR(ResponseCode.SECRET_ERROR_CODE, "secret 错误"),

    CODE_ERROR(ResponseCode.CODE_ERROR_CODE, "code 错误"),

    ACODE_ERROR(ResponseCode.ACODE_ERROR_CODE, "acode 错误"),

    OTHER_ERROR(ResponseCode.OTHER_ERROR_CODE, "参数为空"),

    UNKNOWN("", "未知错误码");

    ResponseCode(String errorNo, String errorTips) {
        this.errorNo = errorNo;
        this.errorTips = errorTips;
    }

    public static final String SUCCESS_CODE = "0";
    public static final String FAIL_CODE = "-1";
    public static final String PARAM_REQUIRED_CODE = "40014";
    public static final String APPID_ERROR_CODE = "40015";
    public static final String SECRET_ERROR_CODE = "40017";
    public static final String CODE_ERROR_CODE = "40018";
    public static final String ACODE_ERROR_CODE = "40019";
    public static final String OTHER_ERROR_CODE = "其它";

    /**
     * 错误码
     */
    private final String errorNo;
    /**
     * 错误描述
     */
    private final String errorTips;

    public String getErrorNo() {
        return errorNo;
    }

    public String getErrorTips() {
        return errorTips;
    }

    /**
     * 根据错误码返回枚举，如果不存在则返回 @see {@link ResponseCode.UNKNOWN}
     *
     * @param errorNo
     * @return
     */
    public static ResponseCode getResponseCode(String errorNo) {
        for (ResponseCode value : ResponseCode.values()) {
            if (Objects.equals(value.getErrorNo(), errorNo)) {
                return value;
            }
        }
        return UNKNOWN;
    }
}
