package com.gbrlbsls.darkstories.Domain.Services.Impl;

import com.gbrlbsls.darkstories.Application.Exception.CustomException;
import com.gbrlbsls.darkstories.Data.Repositories.StoryRepository;
import com.gbrlbsls.darkstories.Domain.Models.Entity.Story;
import com.gbrlbsls.darkstories.Domain.Services.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoryServiceImpl implements StoryService {

    @Autowired
    private StoryRepository storyRepository;

    @Override
    public Story getStoryById(Long id) {
        return storyRepository.getStoryById(id)
                                    .orElseThrow(() -> new CustomException("Invalid story id"));
    }

    @Override
    public Story getStoryByStoryHash(Integer storyHash) {
        return storyRepository.getStoryByHash(storyHash)
                                .orElseThrow(() -> new CustomException("Invalid story hash"));
    }

}
