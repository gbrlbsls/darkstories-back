package com.gbrlbsls.darkstories.Domain.Models.DTO;

import com.gbrlbsls.darkstories.Domain.Models.Entity.Story;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {

    private Story story;

}
