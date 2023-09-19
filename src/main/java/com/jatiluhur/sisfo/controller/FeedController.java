package com.jatiluhur.sisfo.controller;

import com.jatiluhur.sisfo.model.Feed;
import com.jatiluhur.sisfo.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/feed")
public class FeedController {
    private FeedService feedService;

    @Autowired
    public FeedController(FeedService feedService){
        this.feedService = feedService;
    }
    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Feed feed, HttpServletRequest request)
    {
        return feedService.save(feed,request);
    }
    @DeleteMapping("/del/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id, HttpServletRequest request)
    {
        return feedService.delete(id,request);
    }
    @GetMapping("/findall")
    public ResponseEntity<Object> findAll(HttpServletRequest request)
    {
        return feedService.findAll(request);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id, HttpServletRequest request)
    {
        return feedService.findById(id,request);
    }

}