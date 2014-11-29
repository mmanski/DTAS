package com.rasgrass.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("serial")
@Entity
@Document(collection = "Account")
@NamedQuery(name = Account.FIND_BY_EMAIL, query = "select a from Account a where a.email = :email")
public class Account implements java.io.Serializable {

	public static final String FIND_BY_EMAIL = "Account.findByEmail";

	@Id
	@GeneratedValue
	private String id;

	@Column(unique = true)
	private String email;

	@JsonIgnore
	private String password;

	@Column(unique = true)
	private String nickname;

	private String role = "ROLE_USER";

	protected Account() {

	}

	public Account(String email, String password, String role, String nick) {
		this.email = email;
		this.password = password;
		this.role = role;
		this.nickname = nick;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nick) {
		this.nickname = nick;
	}
}
