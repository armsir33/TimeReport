package tr.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import tr.commons.GenericJpaDao;
import tr.model.UserRoles;
import tr.model.Users;

@Repository
public class UserDaoImpl extends GenericJpaDao<Users, Long> implements UserDao {

	public UserDaoImpl() {
		super(Users.class);
	}

	@Override
	public boolean checkAvaiable(String username) {
		Assert.notNull(username);
        
        Query query = getEntityManager()
                .createQuery("select count(*) from " + getPersistentClass().getSimpleName() 
                                + " u where u.username = :username").setParameter("username", username);
        
        Long count = (Long) query.getSingleResult();
        
        return count < 1;
	}

	@Override
	public List<String> getRoles(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(String username, String password, String firstName,
			String lastName, String email) {
		Users user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setEnabled(true);
		UserRoles userRoles = new UserRoles();
		userRoles.setRole("ROLE_USER");
		userRoles.setUsername(username);
		user.setUserRoles(userRoles);
		save(user);
	}

}
