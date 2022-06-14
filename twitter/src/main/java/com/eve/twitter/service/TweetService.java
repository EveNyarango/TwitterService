package com.eve.twitter.service;

import com.eve.twitter.client.TwitterClient;
import com.eve.twitter.client.dto.DataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TweetService {
    private final TwitterClient twitterClient;

    public List<DataDto> getAllTweets(String tweet){
        return twitterClient.getTweets(tweet).getData();
    }
}
