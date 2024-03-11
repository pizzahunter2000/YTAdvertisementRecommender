package com.example.project.service;

import com.example.project.entity.Video;
import com.example.project.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VideoService {
    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Video getVideoById(UUID id) {
        return videoRepository.findById(id).orElse(null);
    }

    public Video saveVideo(Video video){
        return videoRepository.save(video);
    }

    public void deleteVideoById(UUID id){
        videoRepository.deleteById(id);
    }
}
