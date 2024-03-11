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

//    @ManyToMany
//    @JoinTable(
//            name = "tags_rel",
//            joinColumns = @JoinColumn(name = "from_tag"),
//            inverseJoinColumns = @JoinColumn(name = "to_tag")
//    )
//    @MapKeyJoinColumn(name = "to_tag")
//    private Map<Tag, Double> relatedTags;

    public Tag(UUID id, String name) {
        this.id = id;
        this.name = name;
        //relatedTags = new HashMap<>();
    }

    public Tag() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Map<Tag, Double> getRelatedTags() {
//        return relatedTags;
//    }
//
//    public void setRelatedTags(Map<Tag, Double> relatedTags) {
//        this.relatedTags = relatedTags;
//    }
//
//    public void addRelatedTag(Tag tag, Double similarity) {
//        relatedTags.put(tag, similarity);
//        tag.getRelatedTags().put(this, similarity);
//    }
}
