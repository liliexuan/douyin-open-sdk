package com.codingcn.douyin;

import com.codingcn.douyin.model.response.DouyinResponse;

/**
 * 抖音api调用接口
 *
 * @author liexuan
 * @date 2023-05-18 11:13
 **/
public interface Client {


    /**
     * 调用执行抖音接口请求
     *
     * @return
     */
    DouyinResponse execute();
}
