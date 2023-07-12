package com.codingcn.douyin;

import com.codingcn.douyin.api.DouyinOrderApi;

/**
 * 抖音sdk调用实例
 *
 * @author liexuan
 * @date 2023-05-18 10:54
 **/
public class DouyinInstance {

    /**
     * 抖音配置上下文
     */
    private Context context;


    /**
     * 获取抖音openAPI 调用实例
     *
     * @return
     */
    public DouyinClient api() {
        return new DouyinClient(this.getContext());
    }


    public DouyinOrderApi orderApi() {
        return new DouyinOrderApi(this.getContext());
    }

    public Context getContext() {
        return context;
    }

    public DouyinInstance(String domain, String appId, String secret, String platformPublicKey, String appPrivateKey) {
        this.context = new Context();
        this.context.setDomain(domain);
        this.context.setAppId(appId);
        this.context.setSecret(secret);
        this.context.setPlatformPublicKey(platformPublicKey);
        this.context.setAppPrivateKey(appPrivateKey);
    }

}
