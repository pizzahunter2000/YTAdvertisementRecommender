package com.example.project.controller;

import com.example.project.converter.VideoConverter;
import com.example.project.dto.VideoDTO;
import com.example.project.entity.Video;
import com.example.project.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/videos")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @Autowired
    private VideoConverter converter;


    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    @GetMapping("/{id}")
    public Video getVideoById(@PathVariable UUID id) {
        return videoService.getVideoById(id);
    }

    @PostMapping
    public Video saveVideo(@RequestBody VideoDTO videoDTO) {
        Video video = converter.convertToEntity(videoDTO);
        return videoService.saveVideo(video);
    }

    @PutMapping("/{id}")
    public Video updateVideo(@PathVariable UUID id, @RequestBody VideoDTO videoDTO) {
        Video existingVideo = videoService.getVideoById(id);
        Video updatedVideo = converter.convertToEntity(videoDTO);
        if (existingVideo != null) {
            existingVideo.setChannel(updatedVideo.getChannel());
            existingVideo.setTags(updatedVideo.getTags());
            existingVideo.setTitle(updatedVideo.getTitle());
            existingVideo.setNrOfViews(updatedVideo.getNrOfViews());
            return videoService.saveVideo(existingVideo);
        } else {
            return videoService.saveVideo(updatedVideo);
        }
    }


    @DeleteMapping("/{id}")
    public void deleteVideoById(@PathVariable UUID id) {
        videoService.deleteVideoById(id);
    }
}
