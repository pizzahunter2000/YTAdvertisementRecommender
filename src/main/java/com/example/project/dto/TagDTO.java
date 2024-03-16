package com.example.project.dto;

import java.util.Map;
import java.util.UUID;

public class TagDTO {
    private final UUID id;
    private String name;
    private Map<UUID, Double> relatedTags;

    public TagDTO(UUID id, String name, Map<UUID, Double> relatedTags) {
        this.id = id;
        this.name = name;
        this.relatedTags = relatedTags;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<UUID, Double> getRelatedTags() {
        return relatedTags;
    }

    public void setRelatedTags(Map<UUID, Double> relatedTags) {
        this.relatedTags = relatedTags;
    }
}
