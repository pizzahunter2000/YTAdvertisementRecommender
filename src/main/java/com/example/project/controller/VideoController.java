package com.example.project.controller;

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

    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    @GetMapping("/{id}")
    public Video getVideoById(@PathVariable UUID id) {
        return videoService.getVideoById(id);
    }

    @PostMapping
    public Video saveVideo(@RequestBody Video video) {
        return videoService.saveVideo(video);
    }

    @DeleteMapping("/{id}")
    public void deleteVideoById(@PathVariable UUID id) {
        videoService.deleteVideoById(id);
    }
}
