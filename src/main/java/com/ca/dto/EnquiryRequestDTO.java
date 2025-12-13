package com.ca.dto;

import com.ca.enums.ClassMode;
import com.ca.enums.Course;
import com.ca.enums.STATUS;

import ch.qos.logback.core.status.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnquiryRequestDTO {

	private String name;

	private Long phone;

	@Email(message = "invalid email")
	private String email;

	@NotNull(message = "ClassMode Should not be null")
	private ClassMode classMode = ClassMode.OFFLINE;

	@NotNull(message = "Status Should not be null")
	private STATUS status = STATUS.ACTIVE;

	@NotNull(message = "Course Should not be null")
	private Course course;
}
