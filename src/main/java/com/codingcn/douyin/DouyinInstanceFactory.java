package com.codingcn.douyin;

import com.codingcn.douyin.config.DouyinProperties;

/**
 * 抖音appId实例工厂
 * 后续如果有多个appId可以改这里
 *
 * @author liexuan
 * @date 2023-05-18 10:43
 **/
public class DouyinInstanceFactory {

    /**
     * 抖音appId对应实例
     */
    private DouyinInstance douyinInstance;

    /**
     * 返回抖音接口处理客户端
     *
     * @return
     */
    public DouyinInstance getInstance() {
        return douyinInstance;
    }

    public DouyinInstanceFactory(DouyinProperties properties) {
        this.douyinInstance = new DouyinInstance(
                properties.getDomain(),
                properties.getAppId(),
                properties.getSecret(),
                properties.getPlatformPublicKey(),
                properties.getAppPrivateKey()
        );
    }

}
