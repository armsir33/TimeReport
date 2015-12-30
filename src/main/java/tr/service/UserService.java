package tr.service;

import java.util.List;

public interface UserService {
	public boolean checkAvaiable(String username);
	
	public List<String> getRoles(long id);

	public void addUser(String username, String password, String firstName,
			String lastName, String email);
}
