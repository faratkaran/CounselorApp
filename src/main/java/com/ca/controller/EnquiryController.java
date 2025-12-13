package com.ca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ca.dto.EnquiryRequestDTO;
import com.ca.service.EnquiryService;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

	@Autowired
	private EnquiryService enquiryService;

	@PostMapping("/{cid}")
	public  ResponseEntity<String> addEnquiry(@PathVariable Integer cid, @RequestBody EnquiryRequestDTO dto) {
		return enquiryService.add(cid, dto);
	}
}