package tr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	public boolean checkAvaiable(String username) {
		return userDao.checkAvaiable(username);
	}
	
	public List<String> getRoles(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addUser(String username, String password, String firstName,
			String lastName, String email) {
		userDao.addUser(username, password, firstName, lastName, email);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
