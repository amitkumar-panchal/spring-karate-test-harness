package cmccarthyirl.controllers;

import cmccarthyirl.models.Hero;
import cmccarthyirl.storage.HeroList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HeroController {

    @PutMapping("/hero/{id}")
    public ResponseEntity<?> updateHero(@RequestBody Hero newHero, @PathVariable int id) {
        HeroList.updateHero(newHero, id);
        return new ResponseEntity<>(HeroList.getHero(id), HttpStatus.OK);
    }

    @GetMapping("/hero")
    public static ResponseEntity<?> getHeroList()
    {
        return new ResponseEntity<>(HeroList.getListOfHeros(), HttpStatus.OK);
    }

    @GetMapping("/hero/{id}")
    public static ResponseEntity<?> getHero(@PathVariable int id)
    {
        return new ResponseEntity<>(HeroList.getHero(id), HttpStatus.OK);
    }
}