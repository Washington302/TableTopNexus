package TabletopNexus.Login.Repositories;

import TabletopNexus.Login.Classes.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<User, String> {
}
