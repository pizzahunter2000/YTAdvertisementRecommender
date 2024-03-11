package com.example.project.service;

import com.example.project.entity.YTChannel;
import com.example.project.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChannelService {
    private final ChannelRepository channelRepository;

    @Autowired
    public ChannelService(ChannelRepository channelRepository){
        this.channelRepository = channelRepository;
    }

    public List<YTChannel> getAllChannels() {
        return channelRepository.findAll();
    }

    public YTChannel getChannelById(UUID id) {
        return channelRepository.findById(id).orElse(null);
    }

    public YTChannel saveChannel(YTChannel channel) {
        return channelRepository.save(channel);
    }

    public void deleteChannelById(UUID id) {
        channelRepository.deleteById(id);
    }
}
