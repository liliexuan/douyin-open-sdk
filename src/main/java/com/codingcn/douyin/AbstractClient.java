package com.codingcn.douyin;

import cn.hutool.core.text.StrPool;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.Method;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.codingcn.douyin.model.RequestWrapper;
import com.codingcn.douyin.util.SignUtil;

/**
 * 抖音抽象接口封装
 *
 * @author liexuan
 * @date 2023-05-18 16:48
 **/
public abstract class AbstractClient implements Client {
    private static final Log LOGGER = LogFactory.get();

    protected Context context;
    protected RequestWrapper requestWrapper;

    /**
     * 抖音sdk接口调用
     *
     * @return
     */
    @Override
    public abstract <T> T execute();


    protected <T> T execute(RequestWrapper requestWrapper, Class<T> clazz) {
        Method method = requestWrapper.getMethod();
        HttpRequest httpRequest;
        switch (method) {
            case GET:
                httpRequest = HttpRequest.get(requestWrapper.getUri());
                break;
            case POST:
                httpRequest = HttpRequest.post(context.getDomain() + requestWrapper.getUri())
                        .body(RequestWrapper.paramToSortStr(requestWrapper.getParams()))
                        .header("content-type", "application/json");
                break;
            default:
                throw new RuntimeException("请求方式必传");
        }
        if (requestWrapper.getNeedSign()) {
            try {
                String signature = SignUtil.getSignature(context.getAppPrivateKey(),
                        method.name(),
                        requestWrapper.getUri(),
                        requestWrapper.getTimestamp(),
                        requestWrapper.getNonce(),
                        RequestWrapper.paramToSortStr(requestWrapper.getParams())
                );
                StringBuilder headerSign = new StringBuilder(RequestWrapper.SHA256_RSA);
                headerSign.append("appid=" + context.getAppId()).append(StrPool.COMMA);
                headerSign.append("nonce_str=" + requestWrapper.getNonce()).append(StrPool.COMMA);
                headerSign.append("timestamp=" + requestWrapper.getTimestamp()).append(StrPool.COMMA);
                headerSign.append("key_version=1").append(StrPool.COMMA);
                headerSign.append("signature=" + signature);
                httpRequest.header(RequestWrapper.BYTE_AUTHORIZATION, headerSign.toString());
            } catch (Exception e) {
                LOGGER.error(e, "加签异常 requestWrapper = {}", requestWrapper);
                throw new RuntimeException(e);
            }
        }
        HttpResponse response = httpRequest.execute();
        LOGGER.debug("请求抖音返回 body = {}", response.body());
        return JSONUtil.toBean(response.body(), clazz);
    }
}
