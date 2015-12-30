package tr.dao;

import java.util.List;

public interface UserDao {
	public boolean checkAvaiable(String username);
	public List<String> getRoles(final long id);
	public void addUser(String username, String password, String firstName, String lastName, String email);
}
