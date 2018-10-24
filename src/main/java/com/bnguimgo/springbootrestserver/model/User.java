package com.bnguimgo.springbootrestserver.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "UTILISATEUR")
@XmlRootElement(name = "user")
public class User implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name = "USER_ID", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "LOGIN", unique = true, insertable = true, updatable = true, nullable = false)
	private String login;
	
	@Column(name = "USER_PASSWORD", insertable = true, updatable = true, nullable = false)
	private String password;
	
	@Column(name = "USER_ACTIVE", insertable = true, updatable = true, nullable = false)
	private Integer active;
	
	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private Set<Role> roles = new HashSet<>();
	
	public User() {
		super();
	}

	public User(String login, String password, Integer active) {
		super();
		this.login = login;
		this.password = password;
		this.active = active;
	}

	public User(Long id, String login) {
		super();
		this.id = id;
		this.login = login;
	}

	public User(Long id, String login, String password, Integer active) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	@XmlElement
	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	@XmlElement
	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getActive() {
		return active;
	}

	@XmlElement
	public void setActive(Integer active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	@XmlElement
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
