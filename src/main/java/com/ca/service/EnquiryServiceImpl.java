package com.ca.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ca.dao.CounselorDao;
import com.ca.dao.EnquiryDao;
import com.ca.dto.EnquiryRequestDTO;
import com.ca.entity.Counselor;
import com.ca.entity.Enquiry;
import com.ca.exception.CounselorNotFound;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private EnquiryDao enquiryDao;

	@Autowired
	private CounselorDao counselorDao;

	@Override
	public ResponseEntity<String> add(Integer cid, EnquiryRequestDTO dto) {
		Counselor counselor = counselorDao.findById(cid).orElseThrow(() -> new CounselorNotFound());
		Optional<Enquiry> enq = enquiryDao.findByPhone(dto.getPhone());

		if (enq.isPresent()) {
			return new ResponseEntity<String>(
					"Enquiry is already taken by counselor : " + enq.get().getCounselor().getName(), HttpStatus.OK);
		} else {
			Enquiry enquiry = new Enquiry();
			BeanUtils.copyProperties(dto, enquiry);
			enquiry.setCounselor(counselor);
			enquiryDao.add(enquiry);
			return new ResponseEntity<String>("Enquiry Added Successfully", HttpStatus.CREATED);
		}
	}
}
