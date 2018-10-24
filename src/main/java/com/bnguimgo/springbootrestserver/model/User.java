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

import com.bnguimgo.springbootrestserver.dto.UserDTO;

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
	
	public User(UserDTO userDTO) {
        this.setId(userDTO.getId());
        this.setLogin(userDTO.getLogin());
        this.setPassword(userDTO.getPassword());
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
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (active == null) {
            if (other.active != null)
                return false;
        } else if (!active.equals(other.active))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (roles == null) {
            if (other.roles != null)
                return false;
        } else if (!roles.equals(other.roles))
            return false;
        return true;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		final int prime = 31;
        int result = 1;
        result = prime * result + ((active == null) ? 0 : active.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((roles == null) ? 0 : roles.hashCode());
        return result;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User [id=" + id + ", login=" + login + ", password=XXXXXXX, active=" + active + ", roles="
        + roles + "]";
	}

}
