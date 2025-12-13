package com.ca.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CounselorDTO {

	private String name;

	@Size(min = 5, message = "Password should have atleast 5 letters")
	private String password;

	@Column(unique = true)
	private Long phone;

	@Email(message = "invalid email")
	private String email;
}