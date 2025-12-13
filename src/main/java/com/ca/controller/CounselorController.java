package com.ca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ca.dto.CounselorDTO;
import com.ca.dto.CounselorResponseDTO;
import com.ca.dto.LoginDTO;
import com.ca.rs.ResponseStructor;
import com.ca.service.CounselorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/counselors")
public class CounselorController {

	@Autowired
	private CounselorService counselorService;

	@PostMapping
	public ResponseEntity<?> registerCounselor(@RequestBody @Valid CounselorDTO dto) {
		return counselorService.registerCounselor(dto);
	}

	@GetMapping
	public ResponseEntity<ResponseStructor<CounselorResponseDTO>> fetchById(@RequestParam Integer cid) {
		return counselorService.getById(cid);
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginCounselor(@RequestBody LoginDTO loginDTO) {
		return counselorService.login(loginDTO);
	}

	@PutMapping("/{cid}")
	public ResponseEntity<ResponseStructor<CounselorResponseDTO>> update(@PathVariable Integer cid,
			@RequestBody CounselorDTO dto) {
		return counselorService.updateCounselor(cid, dto);
	}

	@DeleteMapping("/{cid}")
	public ResponseEntity<String> deleteCounselor(@PathVariable Integer cid) {
		return counselorService.deleteById(cid);
	}

	@GetMapping("/{cid}")
	public ResponseEntity<ResponseStructor<?>> getEnqsByCid(@PathVariable Integer cid) {
		return counselorService.getEnquiries(cid);
	}

}






