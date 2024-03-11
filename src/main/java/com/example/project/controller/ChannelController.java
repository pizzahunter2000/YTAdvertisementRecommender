package com.example.project.controller;

import com.example.project.entity.YTChannel;
import com.example.project.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/channels")
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    @GetMapping
    public List<YTChannel> getAllChannels(){
        return channelService.getAllChannels();
    }

    @GetMapping("/{id}")
    public YTChannel getChannelById(@PathVariable UUID id){
        return channelService.getChannelById(id);
    }

    @PostMapping
    public YTChannel saveChannel(@RequestBody YTChannel channel){
        return channelService.saveChannel(channel);
    }

    @DeleteMapping("/{id}")
    public void deleteChannelById(@PathVariable UUID id){
        channelService.deleteChannelById(id);
    }
}
