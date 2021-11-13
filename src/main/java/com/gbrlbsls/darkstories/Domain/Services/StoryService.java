package com.gbrlbsls.darkstories.Domain.Services;

import com.gbrlbsls.darkstories.Domain.Models.Entity.Story;

public interface StoryService {

    Story getStoryById(Long id);

    Story getStoryByStoryHash(Integer storyHash);

}
