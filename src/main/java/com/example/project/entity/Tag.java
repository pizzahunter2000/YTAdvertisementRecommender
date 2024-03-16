package com.example.project.entity;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;

    @ElementCollection
    @JoinTable(
            name = "tags_rel",
            joinColumns = @JoinColumn(name = "tag_from")
            //inverseJoinColumns = @JoinColumn(name = "tag_to")
    )
    @MapKeyJoinColumn(name = "tag_to")
    @Column(name = "relation")
    private Map<Tag, Double> relatedTags;

    public Tag(UUID id, String name, HashMap<Tag, Double> relatedTags) {
        this.id = id;
        this.name = name;
        this.relatedTags = relatedTags;
    }

    public Tag() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Tag, Double> getRelatedTags() {
        return relatedTags;
    }

    public void setRelatedTags(Map<Tag, Double> relatedTags) {
        this.relatedTags = relatedTags;
    }

    public void addRelatedTag(Tag tag, Double similarity) {
        relatedTags.put(tag, similarity);
        tag.getRelatedTags().put(this, similarity);
    }
}
