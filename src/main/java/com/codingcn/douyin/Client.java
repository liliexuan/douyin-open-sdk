package com.codingcn.douyin;

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
    <T> T execute();
}
