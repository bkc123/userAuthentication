package com.hcl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "allusers")
@Data
@NoArgsConstructor
public class User {
	@Column(name = "id")
	private long id;

	@Id
	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

}
