package com.codingcn.douyin.api;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Pair;
import cn.hutool.core.map.MapUtil;
import cn.hutool.http.Method;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.codingcn.douyin.AbstractClient;
import com.codingcn.douyin.Client;
import com.codingcn.douyin.Context;
import com.codingcn.douyin.DouyinUriConstant;
import com.codingcn.douyin.model.RequestWrapper;
import com.codingcn.douyin.model.request.OrderSyncRequest;
import com.codingcn.douyin.model.response.DouyinOrderSyncResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 抖音订单同步api
 *
 * @author liexuan
 * @date 2023-07-12 16:46
 **/
public class DouyinOrderApi extends AbstractClient {
    private static final Log LOGGER = LogFactory.get();

    public DouyinOrderApi(Context context) {
        this.context = context;
    }


    public Client orderSync(OrderSyncRequest request) {
        requestWrapper = new RequestWrapper();
        List<Map<String, Object>> itemList = new ArrayList<>();
        request.getOrderDetail().getItemList().forEach(item -> {
            itemList.add(BeanUtil.beanToMap(item, true, false));
        });
        Map<String, Object> orderDetailMap = BeanUtil.beanToMap(request.getOrderDetail(), true, false);
        orderDetailMap.put("item_list", itemList);
        Map<String, Object> params = MapUtil.of(
                Pair.of("client_key", request.getClientKey()),
                Pair.of("access_token", request.getAccessToken()),
                Pair.of("ext_shop_id", request.getExtShopId()),
                Pair.of("app_name", request.getAppName()),
                Pair.of("open_id", request.getOpenId()),
                Pair.of("order_detail", JSONUtil.toJsonStr(orderDetailMap)),
                Pair.of("order_status", request.getOrderStatus()),
                Pair.of("order_type", request.getOrderType()),
                Pair.of("update_time", request.getUpdateTime()),
                Pair.of("extra", request.getExtra())
        );
        requestWrapper.setParams(params).setMethod(Method.POST).setUri(DouyinUriConstant.POST_ORDER_SYNC);
        return this;
    }


    @Override
    public DouyinOrderSyncResponse execute() {
        LOGGER.debug("即将调用抖音接口, requestWrapper = {}", requestWrapper);
        return super.execute(requestWrapper, DouyinOrderSyncResponse.class);
    }
}
