package com.example.project.repository;

import com.example.project.entity.YTChannel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChannelRepository extends JpaRepository<YTChannel, UUID> {
    // custom queries
}
