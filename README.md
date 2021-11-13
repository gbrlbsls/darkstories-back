# darkstories-back
Dark Stories game backend made with Spring Boot

You can try the game [here](https://gbrlbsls.github.io/p/darkstories/index.html) with some friends, of course.

This server is hosted in Heroku (https://hidden-wildwood-83104.herokuapp.com/):

# Endpoints

- POST /game/new-game

  **RESPONSE:** 
  ```json
  {
    "story": {
      "id": 0,
      "title": "Random story title",
      "content": "Random story content",
      "resolution": "Random story resolution",
      "hash": 0
    }
  }
  ```

- POST /game/new-game-from-story-hash

  **BODY:** \<SOME STORY HASH NUMBER HERE\>
  
  **RESPONSE:**
  ```json
  {
    "story": {
      "id": 0,
      "title": "Story title",
      "content": "Story content",
      "resolution": "Story resolution",
      "hash": 0
    }
  }
  ```
- GET /story/get-story-by-id?id=\<SOME STORY ID HERE\>

  **RESPONSE:** 
  ```json
  {
    "title": "string",
    "content": "string"
  }
  ```
