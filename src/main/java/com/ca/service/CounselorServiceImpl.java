package com.ca.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ca.dao.CounselorDao;
import com.ca.dto.CounselorDTO;
import com.ca.dto.CounselorResponseDTO;
import com.ca.dto.LoginDTO;
import com.ca.entity.Counselor;
import com.ca.entity.Enquiry;
import com.ca.exception.CounselorNotFound;
import com.ca.rs.ResponseStructor;

@Service
public class CounselorServiceImpl implements CounselorService {

	@Autowired
	private CounselorDao counselorDao;

	@Override
	public ResponseEntity<?> registerCounselor(CounselorDTO dto) {
		boolean ispresent = counselorDao.findByEmail(dto.getEmail());
		if (ispresent) {
			// TODO : already exist
			return new ResponseEntity<String>("Already registered", HttpStatus.BAD_REQUEST);
		} else {
			// TODO : save and return msg
			Counselor counselor = new Counselor();

			BeanUtils.copyProperties(dto, counselor);

			counselorDao.save(counselor);

			ResponseStructor<String> rs = new ResponseStructor<String>("Registered Successfully with email ",
					dto.getEmail(), HttpStatus.CREATED);

			return new ResponseEntity<ResponseStructor<String>>(rs, HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<String> login(LoginDTO loginDTO) {
		boolean login = counselorDao.findByEmailAndPassword(loginDTO);

		if (login) {
			// TODO : succ
			return new ResponseEntity<String>("Logged in Successfully", HttpStatus.OK);
		} else {
			// TODO : invalid
			return new ResponseEntity<String>("Invalid credentials", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<ResponseStructor<CounselorResponseDTO>> updateCounselor(Integer cid, CounselorDTO dto) {
		Counselor couns = counselorDao.findById(cid).orElseThrow(() -> new CounselorNotFound());
		if (dto.getName() != null) {
			couns.setName(dto.getName());
		}
		if (dto.getEmail() != null) {
			couns.setEmail(dto.getEmail());
		}
		if (dto.getPhone() != null) {
			couns.setPhone(dto.getPhone());
		}
		Counselor saved = counselorDao.save(couns);

		CounselorResponseDTO responseDTO = new CounselorResponseDTO();

		BeanUtils.copyProperties(saved, responseDTO);

		ResponseStructor<CounselorResponseDTO> rs = new ResponseStructor<CounselorResponseDTO>("Updated Successfully",
				responseDTO, HttpStatus.OK);

		return new ResponseEntity<ResponseStructor<CounselorResponseDTO>>(rs, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteById(Integer cid) {
		Counselor couns = counselorDao.findById(cid).orElseThrow(() -> new CounselorNotFound());
		counselorDao.deleteById(cid);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructor<?>> getEnquiries(Integer cid) {
		Counselor couns = counselorDao.findById(cid).orElseThrow(() -> new CounselorNotFound());
		ResponseStructor<List<Enquiry>> rs = new ResponseStructor<List<Enquiry>>("Enquiries retrived",
				couns.getEnquiries(), HttpStatus.OK);
		return new ResponseEntity<ResponseStructor<?>>(rs, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructor<CounselorResponseDTO>> getById(Integer cid) {
		Counselor couns = counselorDao.findById(cid).orElseThrow(() -> new CounselorNotFound());
		CounselorResponseDTO responseDTO = new CounselorResponseDTO();

		BeanUtils.copyProperties(couns, responseDTO);

		ResponseStructor<CounselorResponseDTO> rs = new ResponseStructor<CounselorResponseDTO>("Fetched Successfully",
				responseDTO, HttpStatus.OK);

		return new ResponseEntity<ResponseStructor<CounselorResponseDTO>>(rs, HttpStatus.OK);

	}
}
