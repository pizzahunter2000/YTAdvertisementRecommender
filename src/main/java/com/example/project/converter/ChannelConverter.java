package com.example.project.converter;

import com.example.project.dto.ChannelDTO;
import com.example.project.entity.Tag;
import com.example.project.entity.Video;
import com.example.project.entity.YTChannel;
import com.example.project.service.TagService;
import com.example.project.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ChannelConverter implements Converter<ChannelDTO, YTChannel>{
    @Autowired
    private TagService tagService;

    @Autowired
    private VideoService videoService;

    @Override
    public YTChannel convertToEntity(ChannelDTO dto) {
        List<Video> videos = new ArrayList<>();
        for(UUID id : dto.getVideoIds()){
            videos.add(videoService.getVideoById(id));
        }
        List<Tag> tags = new ArrayList<>();
        for(UUID id : dto.getTagIds()){
            tags.add(tagService.getTagById(id));
        }
        YTChannel channel = new YTChannel(dto.getId(), dto.getName(), dto.getAvgNrOfViews(),
                dto.getNrOfSubscribers(), videos, tags);
        return channel;
    }
}
