package com.bnguimgo.springbootrestserver.dto;

import java.io.Serializable;

public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = -443589941665403890L;
	
	private Long id;
	
	private String login;
	private String password;
	private String userType;
	
	public UserDTO() {
		super();
	}

	public UserDTO(String login, String password) {
		super();
		login = login;
		this.password = password;
	}

	public UserDTO(String login, String password, String userType) {
		super();
		login = login;
		this.password = password;
		this.userType = userType;
	}

	public UserDTO(Long id, String login) {
		super();
		this.id = id;
		login = login;
	}

	public UserDTO(Long id, String login, String password, String userType) {
		super();
		this.id = id;
		login = login;
		this.password = password;
		this.userType = userType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[id=%s, mail=%s, userType=%s]", id, login, userType);
	}
	
	

}
