package com.gbrlbsls.darkstories.Application.Controller;

import com.gbrlbsls.darkstories.Domain.Models.DTO.StoryDTO;
import com.gbrlbsls.darkstories.Domain.Services.StoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/story")
@CrossOrigin(origins = "*")
public class StoryController {

    @Autowired
    private StoryService storyService;

    @GetMapping("get-story-by-id")
    public ResponseEntity getStoryById(@RequestParam Long id) {
        return ResponseEntity.ok(
                new ModelMapper().map(storyService.getStoryById(id), StoryDTO.class)
        );
    }

}
