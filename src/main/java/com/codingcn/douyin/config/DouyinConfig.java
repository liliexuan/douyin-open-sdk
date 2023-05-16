package com.codingcn.douyin.config;

/**
 * @author liliexuan
 */
public class DouyinConfig {

    /**
     * 抖音正式环境
     */
    private static final String PRODUCT_DOMAIN = "https://developer.toutiao.com";
    /**
     * 抖音沙箱环境
     */
    private static final String SANDBOX_DOMAIN = "https://open-sandbox.douyin.com";

    private String domain;

    private String appId;

    private String secret;
    /**
     * 平台公钥
     */
    private String platformPublicKey;
    /**
     * 应用私钥
     */
    private String appPrivateKey;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
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
