package com.gbrlbsls.darkstories.Application.Controller;

import com.gbrlbsls.darkstories.Domain.Services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
@CrossOrigin(origins = "*")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("new-game")
    public ResponseEntity newGame() {
        return ResponseEntity.ok(gameService.newGame());
    }

    @PostMapping("new-game-from-story-hash")
    public ResponseEntity newGameFromStoryHash(@RequestBody Integer storyHash) {
        return ResponseEntity.ok(gameService.newGameFromStoryHash(storyHash));
    }

}
