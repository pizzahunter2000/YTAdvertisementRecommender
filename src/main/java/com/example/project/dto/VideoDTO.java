package com.example.project.dto;

import com.example.project.entity.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VideoDTO {
    private UUID id;
    private String title;
    private UUID channelId;
    private List<UUID> tagIds;
    private int nrOfViews;

    public VideoDTO(UUID id, String title, UUID channelId, List<UUID> tagIds, int nrOfViews) {
        this.id = id;
        this.title = title;
        this.channelId = channelId;
        this.tagIds = tagIds;
        this.nrOfViews = nrOfViews;
    }

    public VideoDTO() {
        tagIds = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getChannelId() {
        return channelId;
    }

    public void setChannelId(UUID channelId) {
        this.channelId = channelId;
    }

    public List<UUID> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<UUID> tagIds) {
        this.tagIds = tagIds;
    }

    public int getNrOfViews() {
        return nrOfViews;
    }

    public void setNrOfViews(int nrOfViews) {
        this.nrOfViews = nrOfViews;
    }
}
