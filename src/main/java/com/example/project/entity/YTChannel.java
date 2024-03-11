package com.example.project.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "channel")
public class YTChannel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final UUID id;
    private String name;

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Video> videos;

    @ManyToMany
    @JoinTable(
            name = "channel_tag",
            joinColumns = @JoinColumn(name = "channel"),
            inverseJoinColumns = @JoinColumn(name = "tag")
    )
    private List<Tag> tags;
    private int avgNumberOfViews;
    private int nrOfSubscribers;

    public YTChannel(UUID id, String name, int avgNumberOfViews, int nrOfSubscribers) {
        this.id = id;
        this.name = name;
        this.avgNumberOfViews = avgNumberOfViews;
        this.nrOfSubscribers = nrOfSubscribers;
        videos = new ArrayList<>();
        tags = new ArrayList<>();
    }

    public YTChannel() {
        videos = new ArrayList<>();
        tags = new ArrayList<>();
        id = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public int getAvgNumberOfViews() {
        return avgNumberOfViews;
    }

    public void setAvgNumberOfViews(int avgNumberOfViews) {
        this.avgNumberOfViews = avgNumberOfViews;
    }

    public int getNrOfSubscribers() {
        return nrOfSubscribers;
    }

    public void setNrOfSubscribers(int nrOfSubscribers) {
        this.nrOfSubscribers = nrOfSubscribers;
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public void addVideo(Video video) {
        videos.add(video);
    }
}
