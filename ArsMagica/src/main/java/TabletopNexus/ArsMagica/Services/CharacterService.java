package TabletopNexus.ArsMagica.Services;

import TabletopNexus.ArsMagica.Models.*;
import TabletopNexus.ArsMagica.Repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CharacterService {


    @Autowired
    private CharacterRepository repo;

    public ArsCharacter createCharacter(ArsCharacter character) {

        character.setId(UUID.randomUUID());

        repo.save(character);
        return character;
    }
    public ArsCharacter returnCharacter(UUID id) {

        if(repo.findById(id).isPresent()){
            return repo.findById(id).get();
        }else {
            return null;
        }
    }

    public List<ArsCharacter> returnCharacters(String username) {

            return repo.findByPlayer(username);

    }

    public void updateCharacter(ArsCharacter character){
        if (repo.findById(character.getId()).isPresent()){
            repo.save(character);
        }
    }
    public void deleteCharacter(UUID id){
        if (repo.findById(id).isPresent()){
            ArsCharacter chara = repo.findById(id).get();

            repo.delete(chara);

        }
    }

}
