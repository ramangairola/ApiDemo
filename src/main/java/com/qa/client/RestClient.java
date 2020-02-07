package com.qa.client;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class RestClient {

    //Get Method
    public void get(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpHost proxy = new HttpHost("wpadnoi302.one.steria.dom", 8080);

        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();

        HttpGet httpGet = new HttpGet(url);                                        //http get request
        httpGet.setConfig(config);                                                 //confiq the proxy
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet); //hit the url

        //a. Status Code:
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status Code ----->" + statusCode);

        //b. JSON String
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");

        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response JSON from API----->" + responseJson);

        //c. All headers
        Header[] headerArr = closeableHttpResponse.getAllHeaders();
        HashMap headerMap = new HashMap<String,String>();
        for(Header header:headerArr){
            headerMap.put(header.getName(),header.getValue());
        }
        System.out.println("Header Array ------->"+headerMap);
    }
}
