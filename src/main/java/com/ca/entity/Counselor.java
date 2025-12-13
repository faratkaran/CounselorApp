package com.ca.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Counselor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;

	private String name;

	@Size(min = 5, message = "Password should have atleast 5 letters")
	private String password;

	@Column(unique = true)
	private Long phone;

	@Email(message = "invalid email")
	@Column(unique = true)
	private String email;

	@OneToMany(mappedBy = "counselor")
	private List<Enquiry> enquiries;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createdDate;

	@UpdateTimestamp
	private LocalDate updatedDate;

}
