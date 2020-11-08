package licence.spin.ba.Licence.service;
import org.springframework.stereotype.Service;

import licence.spin.ba.Licence.entity.User;

@Service
public interface UserService {

	void save(User user);

	User findByUsername(String username);

}
