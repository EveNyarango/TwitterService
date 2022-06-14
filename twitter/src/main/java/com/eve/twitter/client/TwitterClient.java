package com.eve.twitter.client;

import com.eve.twitter.client.dto.TweetDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class TwitterClient {
    private final RestTemplate restTemplate;
    private final String twitterBaseUrl;
    private final String tweetApiPath = "tweets/search/recent?query={query}";

    public TwitterClient(RestTemplateBuilder restTemplateBuilder, @Value("${twitter_base_url}") String twitterBaseUrl) {
        this.restTemplate = restTemplateBuilder.build();
        this.twitterBaseUrl = twitterBaseUrl;
    }

    public TweetDto getTweets(String tweet){
        HttpEntity entity = getBearerToken();
        TweetDto result = null;
        try{
            result = restTemplate.exchange(twitterBaseUrl+tweetApiPath, HttpMethod.GET, entity, TweetDto.class, tweet).getBody();
        }catch(RestClientException e){
            log.error("Exception of getting tweet from Twitter API", e);
        }
        return result;
    }

    private HttpEntity getBearerToken(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer AAAAAAAAAAAAAAAAAAAAAOiIcwEAAAAASLo5GW4Jle%2BpqZd3CULJl0n300g%3DTxgMDTaUYaT9TRRI1OJLZfhK16oHhETiaidWqHeSdpvVpjgjaD");
        HttpEntity entity = new HttpEntity(headers);
        return entity;
    }


}
