package com.example.project.controller;

import com.example.project.controller.dto_entity_converter.TagConverter;
import com.example.project.dto.ChannelDTO;
import com.example.project.dto.TagDTO;
import com.example.project.entity.Tag;
import com.example.project.entity.YTChannel;
import com.example.project.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @Autowired
    private TagConverter converter;

    @GetMapping
    public List<Tag> getAllTags(){
        return tagService.getAllTags();
    }

    @GetMapping("/{id}")
    public Tag getTagById(@PathVariable UUID id){
        return tagService.getTagById(id);
    }

    @PostMapping
    public Tag saveTag(@RequestBody TagDTO tagDTO){
        Tag tag = converter.convertToEntity(tagDTO);
        return tagService.saveTag(tag);
    }

    @PutMapping("/{id}")
    public Tag updateTag(@PathVariable UUID id, @RequestBody TagDTO tagDTO) {
        Tag existingTag = tagService.getTagById(id);
        if (existingTag != null) {
            Tag updatedTag = converter.convertToEntity(tagDTO);
            existingTag.setName(updatedTag.getName());
            existingTag.setRelatedTags(updatedTag.getRelatedTags());
            return tagService.saveTag(existingTag);
        } else {
            return saveTag(tagDTO);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTagById(@PathVariable UUID id){
        tagService.deleteTagById(id);
    }
}
