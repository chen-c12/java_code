package com.chenddd.Http;

import java.util.HashMap;

/**
 * @author chenddd
 * @title: HttpClientData
 * @projectName jedis_redis
 * @description: 数据采集
 * @date 2022/3/3114:43
 */
public class HttpClientData {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Cookies", "JSESSIONID=ABAAABAABEIABCIB3DF7EC1B8C870028E7BC12B9F146C52; WEBTJ-ID=20220331150821-17fdecdc33d101f-0cf9427c" +
                "33cd3b-56171958-921600-17fdecdc33eedf; RECOMMEND_TIP=true; PRE_UTM=; PRE_LAND=https%3A%2F%2Fwww.lagou.com%2F; " +
                "user_trace_token=20220331150821-c1e516bd-f241-4b73-886b-c6ee232a1a94; " +
                "LGUID=20220331150821-4650e308-d317-420e-98b8-2abf9f471cfc; privacyPolicyPopup=false; _ga=GA1.2.813301539.1648710502; " +
                "_gat=1; Hm_lvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1648710502; sajssdk_2015_cross_new_user=1; " +
                "sensorsdata2015session=%7B%7D; LGSID=20220331150821-95c06e9f-38e3-4348-be97-aa48bbf2c37d; " +
                "PRE_HOST=www.baidu.com; PRE_SITE=https%3A%2F%2Fwww.baidu.com%2Flink%3Furl%3DL3Kmo" +
                "OROm3AC%5FRkM5vI8yNOW4xPNEoKI0vcZ0gwUMdy%26wd%3D%26eqid%3Dfd8383c1000c8ff4000000066245535a; " +
                "_gid=GA1.2.503089049.1648710502; index_location_city=%E5%85%A8%E5%9B%BD; X_HTTP_TOKEN=e7b17a915" +
                "e860f674250178461ae3306414d0d2271; Hm_lpvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1648710525; " +
                "TG-TRACK-CODE=index_search; LGRID=20220331151356-2b69234a-85d9-4305-8670-b0d90b1be2e2; __lg_stoken__" +
                "=11ee8b3bf5ca2d5de4662aad2a011e221a66d483b5890061eaefe89df9910bae98e19efe21b5567a2f78fa25cc45cc8ccee597" +
                "c99be3305d4abb20823d67850cf6cc19a00c68; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2217fdecdc612" +
                "584-0226c5c4a010e8-56171958-921600-17fdecdc614735%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24" +
                "latest_traffic_source_type%22%3A%22%E8%87%AA%E7%84%B6%E6%90%9C%E7%B4%A2%E6%B5%81%E9%87%8F%22%2C%22%24latest_" +
                "search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2F" +
                "www.baidu.com%2Flink%22%2C%22%24os%22%3A%22Windows%22%2C%22%24browser%22%3A%22Chrome%22%2C%22%24browser_version" +
                "%22%3A%2299.0.4844.74%22%7D%2C%22%24device_id%22%3A%2217fdecdc612584-0226c5c4a010e8-56171958-921600-17fdecdc614735%22%7D");
        headers.put("Accept", "*/*");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6,zh-TW;q=0.5");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/99.0.4844.74 Safari/537.36 Edg/99.0.1150.55");
        headers.put("Content-Type", "application/json;charset=utf-8");
        headers.put("Referer", "https://www.lagou.com/wn/jobs?labelWords=&fromSearch=true&suginput=&kd=%25E5%25A4%25A7%25E6%2595%25B0%25E6%258D%25AE");
        headers.put("Origin", "https://www.lagou.com");
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("X-Anit-Forge-Token", "None");
        headers.put("Cache-Control", "no-cache");
        headers.put("X-Anit-Forge-Code", "0");
        headers.put("Host", "www.lagou.com");

        HashMap<String, String> params = new HashMap<>();
        params.put("kd", "大数据");
        params.put("city", "全国");
        for (int i = 1; i < 31; i++) {
            params.put("pn",String.valueOf(i));
            HttpClientResp result = HttpClientUtils.doPost("https://www.lagou.com/wn/jobs?labelWords=&fromSearch=" +
                    "true&suginput=&kd=%25E5%25A4%25A7%25E6%2595%25B0%25E6%258D%25AE", headers, params);
            HttpClientHdfsUtils.createFileBySysTime("hdfs://hadoop001:9000", "page"+i,result.toString());
            Thread.sleep(1*500);
        }
    }
}
