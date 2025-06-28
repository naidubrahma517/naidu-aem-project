package com.myproject.aem.core.models;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.poi.util.SystemOutLogger;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class APICall {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObjectData = new JSONObject();
        String apiEndPont = "";
        String bearierToken = "";
        try{
            jsonObject.put("", "");
            jsonObjectData.put("leaddata", jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(apiEndPont);
        httpPost.setHeader("apiKey", bearierToken);
        String jsonPayLoad = jsonObjectData.toString();
        StringEntity stringEntity = new StringEntity(jsonPayLoad, "UTF-8");
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);
        try{
            HttpResponse httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            HttpEntity responseEntity = httpResponse.getEntity();
            String responseBody = EntityUtils.toString(responseEntity);

            if(statusCode ==200 || statusCode ==201){
                System.out.println("Successfully Registered"+ statusCode);
                }
            else{
                System.out.println("failure"+statusCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
