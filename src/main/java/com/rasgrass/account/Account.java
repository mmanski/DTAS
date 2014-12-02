package com.rasgrass.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("serial")
@Entity
@Data
@Document(collection = "Account")
public class Account implements java.io.Serializable {

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

}
