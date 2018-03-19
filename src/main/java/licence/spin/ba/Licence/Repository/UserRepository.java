package licence.spin.ba.Licence.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import licence.spin.ba.Licence.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
