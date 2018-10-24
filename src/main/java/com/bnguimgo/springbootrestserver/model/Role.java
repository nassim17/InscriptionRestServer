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
		return super.equals(obj);
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

	public int compareTo(Role role){
		return this.roleName.compareTo(role.getRoleName());
 
	}
	
}
