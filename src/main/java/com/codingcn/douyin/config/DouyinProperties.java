package com.codingcn.douyin.config;

/**
 * 抖音接入配置
 *
 * @author liexuan
 * @date 2023-05-18 10:00
 **/


public class DouyinProperties {
    /**
     * 抖音正式环境
     */
    public static final String PRODUCT_DOMAIN = "https://developer.toutiao.com";
    /**
     * 抖音沙箱环境
     */
    private static final String SANDBOX_DOMAIN = "https://open-sandbox.douyin.com";

    /**
     * 是否开启沙箱环境，默认不开启
     */
    private boolean openSandbox = false;

    private String domain;

    private String appId;

    /**
     * 抖音商户号
     */
    private String mrchCode;

    private String secret;
    /**
     * 平台公钥
     */
    private String platformPublicKey;
    /**
     * 应用私钥
     */
    private String appPrivateKey;

    public boolean getOpenSandbox() {
        return openSandbox;
    }

    public void setOpenSandbox(boolean openSandbox) {
        this.openSandbox = openSandbox;
    }

    public String getDomain() {
        if (this.openSandbox) {
            this.domain = SANDBOX_DOMAIN;
        } else {
            this.domain = PRODUCT_DOMAIN;
        }
        return domain;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMrchCode() {
        return mrchCode;
    }

    public void setMrchCode(String mrchCode) {
        this.mrchCode = mrchCode;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getPlatformPublicKey() {
        return platformPublicKey;
    }

    public void setPlatformPublicKey(String platformPublicKey) {
        this.platformPublicKey = platformPublicKey;
    }

    public String getAppPrivateKey() {
        return appPrivateKey;
    }

    public void setAppPrivateKey(String appPrivateKey) {
        this.appPrivateKey = appPrivateKey;
    }
}

