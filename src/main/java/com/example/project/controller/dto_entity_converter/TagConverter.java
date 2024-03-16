package com.example.project.controller.dto_entity_converter;

import com.example.project.dto.TagDTO;
import com.example.project.entity.Tag;
import org.springframework.stereotype.Component;

@Component
public class TagConverter implements Converter<TagDTO, Tag>{
    @Override
    public Tag convertToEntity(TagDTO dto) {
        Tag tag = new Tag(dto.getId(), dto.getName());
        return tag;
    }
}
