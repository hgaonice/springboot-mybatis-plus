package com.gaoh.mybatisplus.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author: GH
 * @Date: 2019/9/3 22:37
 * @Version 1.0
 */
@Slf4j
public class HttpClientUtils {

    /**
     * <p>
     *     post/get请求
     * </p>
     * @param url      请求的URL
     * @param paramMap 请求的参数
     * @param requestType 请求类型
     * @return 返回的字符串
     */
    public static String httpClient(String url, Map<String, String> paramMap, String requestType) {
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 参数
        StringBuilder params = new StringBuilder();
        if (paramMap != null) {
            log.info("请求参数:" + JSONObject.toJSONString(paramMap));
            Iterator<Map.Entry<String, String>> iterator = paramMap.entrySet().iterator();
            for (int i = 0; iterator.hasNext(); ++i) {
                Map.Entry<String, String> next = iterator.next();
                if (i == 0) {
                    params.append("?").append(next.getKey()).append("=").append(next.getValue());
                } else {
                    params.append("&").append(next.getKey()).append("=").append(next.getValue());
                }
            }
        }
        log.info(params.toString());
        // 响应模型
        CloseableHttpResponse response = null;
        url += params;
        try {
            if ("GET".equalsIgnoreCase(requestType)) {
                HttpGet httpGet = new HttpGet(url);
                response = httpClient.execute(httpGet);
            } else if ("POST".equalsIgnoreCase(requestType)) {
                // 创建Post请求
                HttpPost httpPost = new HttpPost(url);
                // 设置ContentType(注:如果只是传普通参数的话,ContentType不一定非要用application/json)
                httpPost.setHeader("Content-Type", "application/json;charset=utf8");
                // 由客户端执行(发送)Post请求
                response = httpClient.execute(httpPost);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("请求类型:{},请求路径:{}" , requestType, url);
        if(response==null) return "response空!";
        try {
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();

            StatusLine statusLine = response.getStatusLine();

            log.info("响应状态为:" + response.getStatusLine());
            log.info("响应内容长度为:" + responseEntity.getContentLength());
            if (statusLine.toString().contains(HttpStatus.SC_OK + "")) {
                log.info("请求成功!");
                String fromStatus = EntityUtils.toString(responseEntity);
                log.info("响应内容为:" + fromStatus);
                return fromStatus;
            }else {
                return response.getStatusLine().toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(httpClient, response);
        }
        return "";
    }

    /**
     * <p>
     *     post请求
     * </p>
     * @param url 路径
     * @param object  实体对象
     * @return 请求的数据
     */
    public static String postHttpClient(String url,Object object) {
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 创建Post请求
        HttpPost httpPost = new HttpPost(url);
        // 我这里利用阿里的fastjson，将Object转换为json字符串;
        // (需要导入com.alibaba.fastjson.JSON包)
        String jsonString = JSON.toJSONString(object);

        StringEntity entity = new StringEntity(jsonString, "UTF-8");
        // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();

            StatusLine statusLine = response.getStatusLine();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (statusLine.toString().contains(HttpStatus.SC_OK + "")) {
                log.info("请求成功!");
                String fromStatus = EntityUtils.toString(responseEntity);
                log.info("响应内容为:" + fromStatus);
                return fromStatus;
            }else {
                return statusLine.toString();
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }   finally {
            close(httpClient, response);
        }
        return "";
    }

    /**
     * <p>
     *     post请求  可以传入实体参数 或者自定义参数
     * </p>
     * @param httpType  http类型  http/https
     * @param host      主机Ip
     * @param port      端口
     * @param path      路径
     * @param object    请求对象
     * @param paramMap  请求的参数
     * @return  返回请求的对象
     */
    public static String postClientParam(String httpType, String host, Integer port, String path,
                                Object object,
                                Map<String, String> paramMap
    ) {
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 创建Post请求
        // 参数
        URI uri = null;
        try {
            // 将参数放入键值对类NameValuePair中,再放入集合中
            List<NameValuePair> params = new ArrayList<>();
            if (paramMap != null) {
                Iterator<Map.Entry<String, String>> iterator = paramMap.entrySet().iterator();
                for (; iterator.hasNext(); ) {
                    Map.Entry<String, String> next = iterator.next();
                    params.add(new BasicNameValuePair(next.getKey(), next.getValue()));
                }
            }
            // 设置uri信息,并将参数集合放入uri;
            // 注:这里也支持一个键值对一个键值对地往里面放setParameter(String key, String value)
            uri = new URIBuilder().setScheme(httpType).setHost(host).setPort(port)
                    .setPath(path).setParameters(params).build();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }

        HttpPost httpPost = new HttpPost(uri);
        // HttpPost httpPost = new
        // HttpPost("http://127.0.0.1:12345/doPostControllerThree1");

        // 将user对象转换为json字符串，并放入entity中
        StringEntity entity = new StringEntity(JSON.toJSONString(object), "UTF-8");
        // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
        httpPost.setEntity(entity);

        httpPost.setHeader("Content-Type", "application/json;charset=utf8");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();

            StatusLine statusLine = response.getStatusLine();

            log.info("响应状态为:" + response.getStatusLine());
            log.info("响应内容长度为:" + responseEntity.getContentLength());
            if (statusLine.toString().contains(HttpStatus.SC_OK + "")) {
                log.info("请求成功!");
                String fromStatus = EntityUtils.toString(responseEntity);
                log.info("响应内容为:" + fromStatus);
                return fromStatus;
            }else {
                return response.getStatusLine().toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(httpClient, response);
        }
        return "";
    }

    /**
     * 关闭资源
     * @param httpClient CloseableHttpClient
     * @param response CloseableHttpResponse
     */
    private static void close(CloseableHttpClient httpClient, CloseableHttpResponse response) {
        try {
            // 释放资源
            if (httpClient != null) {
                httpClient.close();
            }
            if (response != null) {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
