package com.record.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.record.entity.Article;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zyysyx
 * @since 2025-04-09
 */
@Service
public class WechatClient {
    /*private static final String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";
    private static final String MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material";

    @Value("${wechat.appid}")
    private String appId;

    @Value("${wechat.secret}")
    private String appSecret;

    private final OkHttpClient client = new OkHttpClient();

    // 获取 AccessToken
    public String getAccessToken() throws IOException {
        String url = String.format("%s?grant_type=client_credential&appid=%s&secret=%s",
                TOKEN_URL, appId, appSecret);
        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
//            JsonNode root = JsonUtils.parse(response.body().string());
            return root.get("access_token").asText();
        }
    }

    // 获取文章列表
    public List<Article> getArticles(int count) throws IOException {
        String accessToken = getAccessToken();
        String jsonBody = String.format("{'type':'news', 'offset':0, 'count':%d}", count);

        RequestBody body = RequestBody.create(jsonBody, MediaType.get("application/json"));
        Request request = new Request.Builder()
                .url(MATERIAL_URL + "?access_token=" + accessToken)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
//            JsonNode root = JsonUtils.parse(response.body().string());
            return parseArticles(root.get("item"));
        }
    }

    private List<Article> parseArticles(JsonNode items) {
        List<Article> articles = new ArrayList<>();
        for (JsonNode item : items) {
            JsonNode content = item.get("content");
            JsonNode newsItem = content.get("news_item").get(0);
            articles.add(new Article(
                    newsItem.get("title").asText(),
                    newsItem.get("url").asText(),
                    newsItem.get("digest").asText(),
                    newsItem.get("thumb_media_id").asText()
            ));
        }
        return articles;
    }*/
}

