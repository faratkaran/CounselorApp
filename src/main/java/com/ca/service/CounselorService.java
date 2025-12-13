package com.ca.service;

import org.springframework.http.ResponseEntity;
import com.ca.dto.CounselorDTO;
import com.ca.dto.CounselorResponseDTO;
import com.ca.dto.LoginDTO;
import com.ca.rs.ResponseStructor;

public interface CounselorService {

	ResponseEntity<?> registerCounselor(CounselorDTO dto);

	ResponseEntity<String> login(LoginDTO loginDTO);

	ResponseEntity<ResponseStructor<CounselorResponseDTO>> updateCounselor(Integer cid, CounselorDTO dto);

	ResponseEntity<String> deleteById(Integer cid);

	ResponseEntity<ResponseStructor<?>> getEnquiries(Integer cid);

	ResponseEntity<ResponseStructor<CounselorResponseDTO>> getById(Integer cid);

}
