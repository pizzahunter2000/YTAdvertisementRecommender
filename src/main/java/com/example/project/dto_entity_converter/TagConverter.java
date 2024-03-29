package com.example.project.dto_entity_converter;

import com.example.project.dto.TagDTO;
import com.example.project.entity.Tag;
import com.example.project.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class TagConverter implements Converter<TagDTO, Tag>{
    @Autowired
    private TagService tagService;
    @Override
    public Tag convertToEntity(TagDTO dto) {
        HashMap<Tag, Double> relatedTags = new HashMap<>();
        for(Map.Entry<UUID, Double> entry : dto.getRelatedTags().entrySet()){
            Tag tag = tagService.getTagById(entry.getKey());
            relatedTags.put(tag, entry.getValue());
        }
        Tag tag = new Tag(dto.getId(), dto.getName(), relatedTags);
        return tag;
    }
}
