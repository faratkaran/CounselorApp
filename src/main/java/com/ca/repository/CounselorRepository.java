package com.ca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ca.entity.Counselor;

public interface CounselorRepository extends JpaRepository<Counselor, Integer> {

	Optional<Counselor> findByEmail(String email);

	Optional<Counselor> findByEmailAndPassword(String email, String password);

}