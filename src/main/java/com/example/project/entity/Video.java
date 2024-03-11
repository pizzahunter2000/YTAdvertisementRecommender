package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



@Entity
@Table(name = "video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "channel")
    @JsonBackReference
    private YTChannel channel;
    /*
    JsonBackReference has to be added because the Video entity
    has a field for Channel that has a List of Videos. Thus,
    without this annotation an infinite loop would be created
    when querying.
     */

    @ManyToMany
    @JoinTable(
            name = "video_tag",
            joinColumns = @JoinColumn(name = "video"),
            inverseJoinColumns = @JoinColumn(name = "tag")
    )
    private List<Tag> tags;
    private int nrOfViews;

    public Video(UUID id, String title, YTChannel channel, int nrOfViews) {
        this.id = id;
        this.title = title;
        this.channel = channel;
        this.nrOfViews = nrOfViews;
        tags = new ArrayList<>();
    }

    public Video() {
        tags = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public YTChannel getChannel() {
        return channel;
    }

    public void setChannel(YTChannel channel) {
        this.channel = channel;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public int getNrOfViews() {
        return nrOfViews;
    }

    public void setNrOfViews(int nrOfViews) {
        this.nrOfViews = nrOfViews;
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }
}
