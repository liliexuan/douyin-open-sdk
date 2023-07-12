package com.codingcn.douyin.model.request;

import java.io.Serializable;
import java.util.List;

/**
 * 订单同步请求
 *
 * @author liexuan
 * @date 2023-07-12 17:07
 **/
public class OrderSyncRequest implements Serializable {

    /**
     * 第三方在抖音开放平台申请的 ClientKey
     * 注意：POI 订单必传
     */
    private String clientKey;
    /**
     * 服务端 API 调用标识，通过 getAccessToken 获取
     */
    private String accessToken;
    /**
     * POI 店铺同步时使用的开发者侧店铺 ID，购买店铺 ID，长度 < 256 byte
     * 注意：POI 订单必传
     */
    private String extShopId;
    /**
     * 做订单展示的字节系 app 名称，目前为固定值“douyin”
     */
    private String appName;
    /**
     * 小程序用户的 open_id，通过 code2Session 获取
     */
    private String openId;
    /**
     * json string，根据不同订单类型有不同的结构体，请参见 order_detail 字段说明（json string）
     */
    private OrderDetail orderDetail;
    /**
     * 普通小程序订单订单状态，POI 订单可以忽略
     * 0：待支付
     * 1：已支付
     * 2：已取消（用户主动取消或者超时未支付导致的关单）
     * 4：已核销（核销状态是整单核销,即一笔订单买了 3 个券，核销是指 3 个券核销的整单）
     * 5：退款中
     * 6：已退款
     * 8：退款失败
     * 注意：普通小程序订单必传，担保支付分账依赖该状态
     */
    private int orderStatus;
    /**
     * 订单类型，枚举值:
     * 0：普通小程序订单（非POI订单）
     * 9101：团购券订单（POI 订单）
     * 9001：景区门票订单（POI订单）
     */
    private int orderType;
    /**
     * 订单信息变更时间，13 位毫秒级时间戳
     */
    private long updateTime;
    /**
     * 自定义字段，用于关联具体业务场景下的特殊参数，长度 < 2048byte
     */
    private String extra;


    public static class OrderDetail {
        /**
         * 开发者侧业务单号。用作幂等控制。该订单号是和担保支付的支付单号绑定的，也就是预下单时传入的 out_order_no 字段，长度 <= 64byte
         */
        private String orderId;
        /**
         * 订单创建的时间，13 位毫秒时间戳
         */
        private long createTime;
        /**
         * 订单状态，建议采用以下枚举值：
         * 待支付
         * 已支付
         * 已取消
         * 已超时
         * 已核销
         * 退款中
         * 已退款
         * 退款失败
         */
        private String status;
        /**
         * 订单商品总数
         */
        private long amount;
        /**
         * 订单总价，单位为分
         */
        private long totalPrice;
        /**
         * 小程序订单详情页 path，长度<=1024 byte (备注：该路径需要保证在小程序内配置过，相对路径即可）
         */
        private String detailUrl;
        /**
         * 子订单商品列表，不可为空
         */
        private List<Item> itemList;


        public OrderDetail() {
        }

        public OrderDetail(String orderId, long createTime, String status, long amount, long totalPrice, String detailUrl, List<Item> itemList) {
            this.orderId = orderId;
            this.createTime = createTime;
            this.status = status;
            this.amount = amount;
            this.totalPrice = totalPrice;
            this.detailUrl = detailUrl;
            this.itemList = itemList;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public long getAmount() {
            return amount;
        }

        public void setAmount(long amount) {
            this.amount = amount;
        }

        public long getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(long totalPrice) {
            this.totalPrice = totalPrice;
        }

        public String getDetailUrl() {
            return detailUrl;
        }

        public void setDetailUrl(String detailUrl) {
            this.detailUrl = detailUrl;
        }

        public List<Item> getItemList() {
            return itemList;
        }

        public void setItemList(List<Item> itemList) {
            this.itemList = itemList;
        }
    }


    public static class Item {
        /**
         * 开发者侧商品 ID，长度 <= 64 byte
         */
        private String itemCode;

        /**
         * 子订单商品图片 URL，长度 <= 512 byte
         */
        private String img;

        /**
         * 子订单商品介绍标题，长度 <= 256 byte
         */
        private String title;

        /**
         * 子订单商品介绍副标题，长度 <= 256 byte
         */
        private String subTitle;

        /**
         * 单类商品的数目
         */
        private long amount;

        /**
         * 单类商品的总价，单位为分
         */
        private long price;

        public String getItemCode() {
            return itemCode;
        }

        public void setItemCode(String itemCode) {
            this.itemCode = itemCode;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }

        public long getAmount() {
            return amount;
        }

        public void setAmount(long amount) {
            this.amount = amount;
        }

        public long getPrice() {
            return price;
        }

        public void setPrice(long price) {
            this.price = price;
        }

        public Item() {
        }

        public Item(String itemCode, String img, String title, String subTitle, long amount, long price) {
            this.itemCode = itemCode;
            this.img = img;
            this.title = title;
            this.subTitle = subTitle;
            this.amount = amount;
            this.price = price;
        }
    }


    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExtShopId() {
        return extShopId;
    }

    public void setExtShopId(String extShopId) {
        this.extShopId = extShopId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
