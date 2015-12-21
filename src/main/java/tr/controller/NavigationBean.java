package tr.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class NavigationBean {
	public String showRegisterPage() {
		return "register.xhtml?faces-redirect=true";
	}
}
