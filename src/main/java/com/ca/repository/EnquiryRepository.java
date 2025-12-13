package com.ca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ca.entity.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Integer> {

	Optional<Enquiry> findByPhone(Long phone);

}