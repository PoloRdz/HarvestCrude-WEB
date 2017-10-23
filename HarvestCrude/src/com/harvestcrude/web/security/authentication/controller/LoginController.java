package com.harvestcrude.web.security.authentication.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.harvestcrude.services.security.auth.UserAuthService;

@ManagedBean
@RequestScoped
public class LoginController implements Serializable {
	private static final long serialVersionUID = 1L;
	//TODO add logger
	
	public String login(){
		UserAuthService service = new UserAuthService();
		service.getUserAccount();
		return "/private/dispatch/dispatch?faces-redirect=true&dispatch=1";
	}
}
