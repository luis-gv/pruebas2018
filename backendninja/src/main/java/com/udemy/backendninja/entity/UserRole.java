package com.udemy.backendninja.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="user_roles", uniqueConstraints = @UniqueConstraint(
		columnNames={"role", "username"}))
public class UserRole {
	
	@Id
	@GeneratedValue
	@Column(name = "user_role_id", unique = true, nullable=false)
	private Integer userRoleId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="username", nullable=false)
	private User user;
	
	@Column(name="role",nullable=false, length=45)	
	private String role;
	
	
}
