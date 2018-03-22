package licence.spin.ba.Licence.service;

public interface SecurityService {
	
	String findLoggedInUserName();
	
	void autoLogin(String userName,String password);

}
