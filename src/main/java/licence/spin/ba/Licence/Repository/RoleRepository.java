package licence.spin.ba.Licence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import licence.spin.ba.Licence.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
