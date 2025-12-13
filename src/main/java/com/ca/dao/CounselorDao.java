package com.ca.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ca.dto.LoginDTO;
import com.ca.entity.Counselor;
import com.ca.repository.CounselorRepository;

@Repository
public class CounselorDao {

	@Autowired
	private CounselorRepository counselorRepository;

	public boolean findByEmail(String email) {
		return counselorRepository.findByEmail(email).isPresent();
	}

	public Counselor save(Counselor counselor) {
		return counselorRepository.save(counselor);
	}

	public boolean findByEmailAndPassword(LoginDTO loginDTO) {
		return counselorRepository.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword()).isPresent();
	}

	public Optional<Counselor> findById(Integer cid) {
		return counselorRepository.findById(cid);
	}

	public void deleteById(Integer cid) {
		counselorRepository.deleteById(cid);
	}

}

