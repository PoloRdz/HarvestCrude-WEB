package com.harvestcrude.web.security.authentication.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LoginController implements Serializable {
	private static final long serialVersionUID = 1L;
	//TODO add logger
	
	public String login(){
		return "/home";
	}
}
