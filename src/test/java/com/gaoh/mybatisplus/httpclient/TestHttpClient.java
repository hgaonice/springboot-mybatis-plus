package com.gaoh.mybatisplus.httpclient;

import com.gaoh.mybatisplus.entity.PapersEntity;
import com.gaoh.mybatisplus.utils.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: GH
 * @Date: 2019/9/3 22:52
 * @Version 1.0
 */
@Slf4j
public class TestHttpClient {

    /**
     * HTTP/1.1 405   状态码 标识请求类型错误
     *
     *
     * 23:13:38.189 [main] INFO com.gaoh.mybatisplus.utils.HttpClientUtils - 响应状态为:HTTP/1.1 200
     * 23:13:38.189 [main] INFO com.gaoh.mybatisplus.utils.HttpClientUtils - 响应内容长度为:-1
     *
     * 23:14:55.044 [main] INFO com.gaoh.mybatisplus.utils.HttpClientUtils - 响应状态为:HTTP/1.1 405
     * 23:14:55.045 [main] INFO com.gaoh.mybatisplus.utils.HttpClientUtils - 响应内容长度为:-1
     */
    @Test
    public void test() {
//        HttpClientUtils.httpClient("http://localhost/selectAll", null);
        Map<String, String> map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "wangh");
        String fromStatus = HttpClientUtils.httpClient("http://localhost/selectById", map, "GET");
        System.out.println("fromStatus:" + fromStatus);
        String fromStatus1 = HttpClientUtils.httpClient("http://localhost/selectByIdPost", map, "POST");
        System.out.println("fromStatus:" + fromStatus1);
    }
    @Test
    public void test2() {
        PapersEntity papersEntity = new PapersEntity();
        papersEntity.setIds(1);
        papersEntity.setFilename("2312");
        HttpClientUtils.postHttpClient("http://localhost/selectByIdModel", papersEntity);
    }

    @Test
    public void test3() {
        PapersEntity papersEntity = new PapersEntity();
        papersEntity.setIds(1);
        papersEntity.setFilename("2312");
        Map<String, String> map = new HashMap<>();
        map.put("test", "1");
//        map.put("name", "wangh");
//        String fromStatus = HttpClientUtils.postHttpClient("http://localhost/selectByIdModelParam", papersEntity);
        String fromStatus1 = HttpClientUtils.postClientParam("http", "127.0.0.1", 80,
                "/selectByIdModelParam", papersEntity, map);
        System.out.println("fromStatus1:" + fromStatus1);
    }
}
