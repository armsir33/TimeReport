package tr.dao;

import tr.commons.GenericJpaDao;
import tr.model.Users;

public class UserDaoImpl extends GenericJpaDao<Users, Long> implements UserDao {

	public UserDaoImpl() {
		super(Users.class);
	}

	@Override
	public boolean checkAvaiable(String username) {
		return false;
	}

}
