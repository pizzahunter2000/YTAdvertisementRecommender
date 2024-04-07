package com.example.project.controller;

import com.example.project.converter.ChannelConverter;
import com.example.project.dto.ChannelDTO;
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

    @Autowired
    private ChannelConverter converter;

    @GetMapping
    public List<YTChannel> getAllChannels(){
        return channelService.getAllChannels();
    }

    @GetMapping("/{id}")
    public YTChannel getChannelById(@PathVariable UUID id){
        return channelService.getChannelById(id);
    }

    @PostMapping
    public YTChannel saveChannel(@RequestBody ChannelDTO channelDTO){
        YTChannel channel = converter.convertToEntity(channelDTO);
        return channelService.saveChannel(channel);
    }


    @PutMapping("/{id}")
    public YTChannel updateChannel(@PathVariable UUID id, @RequestBody ChannelDTO channelDTO) {
        YTChannel existingChannel = channelService.getChannelById(id);
        YTChannel updatedChannel = converter.convertToEntity(channelDTO);
        if (existingChannel != null) {
            existingChannel.setVideos(updatedChannel.getVideos());
            existingChannel.setName(updatedChannel.getName());
            existingChannel.setTags(updatedChannel.getTags());
            existingChannel.setNrOfSubscribers(updatedChannel.getNrOfSubscribers());
            existingChannel.setAvgNumberOfViews(updatedChannel.getAvgNumberOfViews());
            return channelService.saveChannel(existingChannel);
        } else {
            return channelService.saveChannel(updatedChannel);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteChannelById(@PathVariable UUID id){
        channelService.deleteChannelById(id);
    }
}
