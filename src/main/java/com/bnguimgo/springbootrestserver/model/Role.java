package com.bnguimgo.springbootrestserver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ROLE")
@XmlRootElement(name = "role")
public class Role implements Serializable{
	
	private static final long serialVersionUID = 2284252532274015507L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//IDENTITY ==> c'est la base de donnees qui va generer la cle primaire afin d'eviter les doublons, car cette table contient deja les donnees a l'initialisation
	@Column(name = "ROLE_ID", updatable = false, nullable = false)
	private int id;
	
	@Column(name = "ROLE_NAME", updatable = true, nullable = false)
	private String roleName;
	
	public Role() {
		super();
	}

	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	@XmlElement
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
		Role other = (Role) obj;
		if (id != other.id)
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		return result;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Role [id=" + id + ", role=" + roleName + "]";
	}

	public int compareTo(Role role){
		return this.roleName.compareTo(role.getRoleName());
 
	}
	
}
