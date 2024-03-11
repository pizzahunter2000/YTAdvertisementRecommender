package com.example.project.controller;

import com.example.project.entity.Tag;
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

    @GetMapping
    public List<Tag> getAllTags(){
        return tagService.getAllTags();
    }

    @GetMapping("/{id}")
    public Tag getTagById(@PathVariable UUID id){
        return tagService.getTagById(id);
    }

    @PostMapping
    public Tag saveTag(@RequestBody Tag tag){
        return tagService.saveTag(tag);
    }

    @DeleteMapping("/{id}")
    public void deleteTagById(@PathVariable UUID id){
        tagService.deleteTagById(id);
    }
}
