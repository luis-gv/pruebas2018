package com.udemy.backendninja.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.udemy.backendninja.entity.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

	@Id
	@Column(name="username", unique=true, nullable=false, length=45)
	private String userName;
	
	@Column(name="password", nullable=false, length=100)
	private String password;
	
	@Column(name="enabled", nullable=false)
	private boolean enabled;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="user")
	private Set<UserRole> userRol = new HashSet<UserRole>();
}
