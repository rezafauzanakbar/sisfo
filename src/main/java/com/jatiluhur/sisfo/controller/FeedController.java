package com.jatiluhur.sisfo.controller;

import com.jatiluhur.sisfo.service.FeedService;
import com.jatiluhur.sisfo.service.KipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/feed")
public class FeedController {
    private FeedService feedService;

    @Autowired
    public FeedController(FeedService feedService){
        this.feedService = feedService;
    }
    @GetMapping("/findall")
    public ResponseEntity<Object> findAll(HttpServletRequest request)
    {
        return feedService.findAll(request);
    }

}