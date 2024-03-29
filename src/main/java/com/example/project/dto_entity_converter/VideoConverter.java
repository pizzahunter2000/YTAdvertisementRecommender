package com.example.project.dto_entity_converter;

import com.example.project.dto.VideoDTO;
import com.example.project.entity.Video;
import com.example.project.entity.YTChannel;
import com.example.project.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VideoConverter implements Converter<VideoDTO, Video>{
    @Autowired
    private ChannelService channelService;

    @Override
    public Video convertToEntity(VideoDTO dto) {
        YTChannel channel = channelService.getChannelById(dto.getChannelId());
        Video video = new Video(dto.getId(), dto.getTitle(), channel, dto.getNrOfViews());
        return video;
    }
}
