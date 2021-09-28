package com.example.truemedsAssignment.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.truemedsAssignment.datajpa.repository.InputDetailsRepository;
import com.example.truemedsAssignment.model.OutputDetails;
import com.example.truemedsAssignment.service.DataProcessService;
@RestController("/process")
public class DataProcessController {

	
	
	@Autowired  private DataProcessService dataProcessService;
	@Autowired
	InputDetailsRepository inputDetailsRepository;
	
	@GetMapping("/getProcessedData")
	  public ResponseEntity<List<OutputDetails>> getAllTutorials(@RequestParam(required = false) String createdBy) {
	    try {
	      List<OutputDetails> outputDetails = dataProcessService.processDataAndSaveIntoTheOutput(createdBy);
	      
	      if (outputDetails.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(outputDetails, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	
	  
	  
}
