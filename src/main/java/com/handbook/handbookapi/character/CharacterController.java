package com.handbook.handbookapi.character;

import com.handbook.handbookapi.background.Background;
import com.handbook.handbookapi.character.characterclass.CharacterClass;
import com.handbook.handbookapi.character.language.Language;
import com.handbook.handbookapi.background.BackgroundType;
import com.handbook.handbookapi.character.race.Race;
import com.handbook.handbookapi.character.race.RaceDTO;
import com.handbook.handbookapi.character.race.RaceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping
    public ResponseEntity findAll() {
        List<Character> characters = characterService.findAll();
        return ResponseEntity.ok(characters);
    }

    @GetMapping("/user/{idUser}")
    public ResponseEntity findAllByUserId(@PathVariable("idUser") Long idUser) {
        List<Character> character = characterService.findAllByUserId(idUser);
        return ResponseEntity.ok(character);
    }

    @GetMapping("/{idCharacter}")
    public ResponseEntity findByCharacterId(@PathVariable("idCharacter") Long idCharacter) {
        Character character = characterService.getById(idCharacter);

        return ResponseEntity.ok(character);
    }

    @PostMapping("/new-character")
    public ResponseEntity<Character> create() {
        Character saved = characterService.createCharacter();

        return ResponseEntity.ok(saved);
    }

    @PostMapping("{idCharacter}/race")
    public ResponseEntity<Character> updateCharacterRace(@PathVariable("idCharacter") Long idCharacter, @RequestBody Race race) {
        Character saved = characterService.updateCharacterRace(idCharacter, race);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/{idCharacter}/class")
    public ResponseEntity<Character> updateCharacterClass(@PathVariable("idCharacter") Long idCharacter, @RequestBody CharacterClass characterClass) {
        Character saved = characterService.updateCharacterClass(idCharacter, characterClass);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/{idCharacter}/background")
    public ResponseEntity updateCharacterBackground(@PathVariable("idCharacter") Long idCharacter, @RequestBody Background background) {
        Character saved = characterService.updateBackground(idCharacter, background);

        return ResponseEntity.ok(saved);
    }

    @PostMapping("/{idCharacter}/language")
    public ResponseEntity<Character> addLanguages(@PathVariable("idCharacter") Long idCharacter, @RequestBody List<Language> languages){
       Character saved = characterService.addLanguages(idCharacter, languages);

       return ResponseEntity.ok(saved);
    }
}
