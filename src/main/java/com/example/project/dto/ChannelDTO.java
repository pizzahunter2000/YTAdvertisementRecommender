package com.example.project.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChannelDTO {
    private final UUID id;
    private String name;
    private List<UUID> videoIds;
    private List<UUID> tagIds;
    private int avgNrOfViews;
    private int nrOfSubscribers;

    public ChannelDTO(UUID id, String name, List<UUID> videoIds, List<UUID> tagIds, int avgNrOfViews, int nrOfSubscribers) {
        this.id = id;
        this.name = name;
        this.videoIds = videoIds;
        this.tagIds = tagIds;
        this.avgNrOfViews = avgNrOfViews;
        this.nrOfSubscribers = nrOfSubscribers;
    }

    public ChannelDTO() {
        videoIds = new ArrayList<>();
        tagIds = new ArrayList<>();
        id = null;
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

    public List<UUID> getVideoIds() {
        return videoIds;
    }

    public void setVideoIds(List<UUID> videoIds) {
        this.videoIds = videoIds;
    }

    public List<UUID> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<UUID> tagIds) {
        this.tagIds = tagIds;
    }

    public int getAvgNrOfViews() {
        return avgNrOfViews;
    }

    public void setAvgNrOfViews(int avgNrOfViews) {
        this.avgNrOfViews = avgNrOfViews;
    }

    public int getNrOfSubscribers() {
        return nrOfSubscribers;
    }

    public void setNrOfSubscribers(int nrOfSubscribers) {
        this.nrOfSubscribers = nrOfSubscribers;
    }
}
