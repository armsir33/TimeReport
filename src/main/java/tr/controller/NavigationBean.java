package tr.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class NavigationBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String showRegisterPage() {
		System.out.println("register ....");
		return "register.xhtml?faces-redirect=true";
	}
}
