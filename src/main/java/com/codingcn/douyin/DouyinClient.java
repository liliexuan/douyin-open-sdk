package com.codingcn.douyin;

import cn.hutool.core.map.MapUtil;
import cn.hutool.http.Method;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.codingcn.douyin.model.RequestWrapper;
import com.codingcn.douyin.model.response.DouyinResponse;

import java.util.Map;

/**
 * 抖音接口请求封装
 *
 * @author liexuan
 * @date 2023-05-18 16:32
 **/
public class DouyinClient extends AbstractClient {
    private static final Log LOGGER = LogFactory.get();

    public DouyinClient(Context context) {
        this.context = context;
    }

    /**
     * 获取抖音接口调用凭证
     *
     * @return
     */
    public Client getAccessToken() {
        requestWrapper = new RequestWrapper();
        Map<String, String> params = MapUtil.ofEntries(
                MapUtil.entry("appid", context.getAppId()),
                MapUtil.entry("secret", context.getSecret()),
                MapUtil.entry("grant_type", "client_credential")
        );
        requestWrapper.setParams(params).setMethod(Method.POST).setUri(DouyinUriConstant.GET_ACCESS_TOKEN_URI);
        return this;
    }


    public Client code2Session(String code, String anonymousCode) {
        requestWrapper = new RequestWrapper();
        Map<String, String> params = MapUtil.ofEntries(
                MapUtil.entry("appid", context.getAppId()),
                MapUtil.entry("secret", context.getSecret()),
                MapUtil.entry("code", code),
                MapUtil.entry("anonymous_code", anonymousCode)
        );
        requestWrapper.setParams(params).setMethod(Method.POST).setUri(DouyinUriConstant.GET_CODE2SESSION_URI);
        return this;
    }


    @Override
    public DouyinResponse execute() {
        LOGGER.debug("即将调用抖音接口, requestWrapper = {}", requestWrapper);
        return super.execute(requestWrapper);
    }


}
