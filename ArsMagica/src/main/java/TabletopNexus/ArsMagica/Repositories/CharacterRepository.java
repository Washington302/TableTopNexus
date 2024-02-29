package TabletopNexus.ArsMagica.Repositories;

import TabletopNexus.ArsMagica.Models.ArsCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface CharacterRepository extends MongoRepository<ArsCharacter, UUID> {
    public List<ArsCharacter> findByPlayer(String username);
}
