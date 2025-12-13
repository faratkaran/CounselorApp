package com.ca.entity;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ca.enums.ClassMode;
import com.ca.enums.Course;
import com.ca.enums.STATUS;
import com.fasterxml.jackson.annotation.JsonIgnore;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;

	private String name;

	@Column(unique = true)
	private Long phone;

	@Email(message = "invalid email")
	private String email;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ClassMode classMode = ClassMode.OFFLINE;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private STATUS status = STATUS.ACTIVE;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Course course;

	@ManyToOne
	@JoinColumn(name = "couselor_id")
	@JsonIgnore
	private Counselor counselor;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createdDate;

	@UpdateTimestamp
	private LocalDate updatedDate;
}
