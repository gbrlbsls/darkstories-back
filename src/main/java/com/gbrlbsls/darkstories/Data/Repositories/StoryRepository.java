package com.gbrlbsls.darkstories.Data.Repositories;

import com.gbrlbsls.darkstories.Domain.Models.Entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StoryRepository extends JpaRepository<Story, Long> {

    @Query(value = "SELECT * FROM story ORDER BY RAND() LIMIT 1;", nativeQuery = true)
    Story getRandomStory();

    Optional<Story> getStoryByHash(Integer storyHash);

    Optional<Story> getStoryById(Long id);

}