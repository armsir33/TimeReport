package tr.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tr.service.UserService;

@ManagedBean(name="registerBean", eager=true)
@RequestScoped
@Component
public class RegisterBean implements Serializable {
	/**
	 * 
	 */
	@Autowired
	UserService userService;

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;

	public void register() {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;

		if (!userService.checkAvaiable(username)) {
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "User "
					+ username + " already existed", "Invalid credentials");
		} else {
			userService.addUser(username, password, firstName, lastName, email);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome",
					username);
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
		context.addCallbackParam("register", null);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
