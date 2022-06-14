package com.eve.twitter.controller;

import com.eve.twitter.client.dto.DataDto;
import com.eve.twitter.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tweets")
public class TwitterController {

    private final TweetService tweetService;

    @GetMapping
    public ResponseEntity<List<DataDto>> getTweets(@RequestParam String tweet){
        return ResponseEntity.ok(tweetService.getAllTweets(tweet));
    }
}
