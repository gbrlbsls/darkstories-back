package com.gbrlbsls.darkstories.Domain.Services;

import com.gbrlbsls.darkstories.Domain.Models.DTO.GameDTO;

public interface GameService {

    GameDTO newGame();

    GameDTO newGameFromStoryHash(Integer storyHash);

}
