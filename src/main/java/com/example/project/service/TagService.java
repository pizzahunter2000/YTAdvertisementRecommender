package com.example.project.service;

import com.example.project.entity.Tag;
import com.example.project.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TagService {
    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getAllTags(){
        return tagRepository.findAll();
    }

    public Tag getTagById(UUID id){
        return tagRepository.findById(id).orElse(null);
    }

    public Tag saveTag(Tag tag){
        return tagRepository.save(tag);
    }

    public void deleteTagById(UUID id){
        tagRepository.deleteById(id);
    }
}
