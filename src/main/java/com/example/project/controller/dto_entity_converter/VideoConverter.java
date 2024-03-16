package com.example.project.controller.dto_entity_converter;

import com.example.project.controller.ChannelController;
import com.example.project.controller.TagController;
import com.example.project.controller.VideoController;
import com.example.project.dto.VideoDTO;
import com.example.project.entity.Video;
import com.example.project.entity.YTChannel;
import com.example.project.repository.ChannelRepository;
import com.example.project.service.ChannelService;
import com.example.project.service.TagService;
import com.example.project.service.VideoService;
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
