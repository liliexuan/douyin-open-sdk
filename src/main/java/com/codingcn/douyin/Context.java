package com.codingcn.douyin;

/**
 * 抖音配置上下文
 *
 * @author liexuan
 * @date 2023-05-18 16:41
 **/
public class Context {

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
