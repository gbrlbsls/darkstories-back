package com.gbrlbsls.darkstories.Application.Seeders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gbrlbsls.darkstories.Data.Repositories.StoryRepository;
import com.gbrlbsls.darkstories.Domain.Models.Entity.Story;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class DatabaseSeeder {

    private Logger logger = Logger.getLogger("DatabaseSeeder");
    private StoryRepository storyRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseSeeder(
            StoryRepository storyRepository,
            JdbcTemplate jdbcTemplate) {
        this.storyRepository = storyRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedStoryTable();
    }

    @SneakyThrows
    private void seedStoryTable() {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream("stories.json");

        ObjectMapper objectMapper = new ObjectMapper();

        List<Map<String, String>> stories = objectMapper.readValue(inputStream, new TypeReference<List<Map<String, String>>>(){});

        stories.forEach(story -> {
            Story newStory = new Story(null, story.get("titulo"), story.get("caso"), story.get("resolucao"), 0);
            newStory.setHash(newStory.hashCode());
            storyRepository.save(newStory);
        });

    }

}
