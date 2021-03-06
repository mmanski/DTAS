package com.rasgrass.signup;

import com.rasgrass.account.Account;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class SignupForm {

    private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
    private static final String EMAIL_MESSAGE = "{email.message}";

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    @Email(message = SignupForm.EMAIL_MESSAGE)
    private String email;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    private String password;
    
    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    @Valid
    private String nickname;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account createAccount() {
        return new Account(getEmail(), getPassword(), "ROLE_USER", getNickname());
    }
}
