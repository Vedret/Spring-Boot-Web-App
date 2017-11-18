package licence.spin.ba.Licence.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
    public boolean validateUser(String userid, String password) {
        // in28minutes, dummy
        return userid.equalsIgnoreCase("1")
                && password.equalsIgnoreCase("1");
    }

}
