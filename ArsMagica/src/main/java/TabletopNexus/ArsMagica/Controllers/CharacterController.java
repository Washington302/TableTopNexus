package TabletopNexus.ArsMagica.Controllers;

import TabletopNexus.ArsMagica.Models.ArsCharacter;
import TabletopNexus.ArsMagica.Models.Magi;
import TabletopNexus.ArsMagica.Services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @GetMapping("test")
    public String testConnection(){
        return "I Got Access";
    }

    @Autowired
    private CharacterService characterService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<ArsCharacter> getCharacter(@PathVariable UUID id) {

        ArsCharacter createdCharacter = characterService.returnCharacter(id);

        return new ResponseEntity<>(createdCharacter, HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<ArsCharacter>> getCharacters(@RequestParam  String player) {

        List<ArsCharacter> characters =  characterService.returnCharacters(player);

        return new ResponseEntity<>(characters, HttpStatus.CREATED);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<ArsCharacter> createCharacter(@RequestBody ArsCharacter chara) {

        ArsCharacter createdCharacter = characterService.createCharacter(chara);

        return new ResponseEntity<>(createdCharacter, HttpStatus.ACCEPTED);
    }
    @PostMapping(path = "/createMagi")
    public ResponseEntity<ArsCharacter> createMagi(@RequestBody Magi chara) {

        ArsCharacter createdCharacter = characterService.createCharacter(chara);

        return new ResponseEntity<>(createdCharacter, HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<String> updateCharacter(@RequestBody ArsCharacter chara) {
        characterService.updateCharacter(chara);
        return new ResponseEntity<>("Updated",HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable UUID id) {
        characterService.deleteCharacter(id);
        return new ResponseEntity<>("Your Character has been Deleted", HttpStatus.ACCEPTED);
    }

}
