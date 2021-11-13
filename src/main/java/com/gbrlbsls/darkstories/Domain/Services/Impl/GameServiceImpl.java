package com.gbrlbsls.darkstories.Domain.Services.Impl;

import com.gbrlbsls.darkstories.Application.Exception.CustomException;
import com.gbrlbsls.darkstories.Data.Repositories.StoryRepository;
import com.gbrlbsls.darkstories.Domain.Models.DTO.GameDTO;
import com.gbrlbsls.darkstories.Domain.Models.Entity.Story;
import com.gbrlbsls.darkstories.Domain.Services.GameService;
import com.gbrlbsls.darkstories.Domain.Services.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private StoryService storyService;

    @Autowired
    private StoryRepository storyRepository;

    public GameDTO newGame() {
        GameDTO gameDTO = new GameDTO();
        gameDTO.setStory(storyRepository.getRandomStory());

        return gameDTO;
    }

    @Override
    public GameDTO newGameFromStoryHash(Integer storyHash) {

        Story story = storyService.getStoryByStoryHash(storyHash);

        GameDTO gameDTO = new GameDTO();
        gameDTO.setStory(story);

        return gameDTO;

    }

}
