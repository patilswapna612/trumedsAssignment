package com.example.truemedsAssignment.service;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.truemedsAssignment.datajpa.repository.InputDetailsRepository;
import com.example.truemedsAssignment.datajpa.repository.OutputDetailsRepository;
import com.example.truemedsAssignment.model.InputDetails;
import com.example.truemedsAssignment.model.OutputDetails;

@Service
@Transactional
public class DataProcessService {

	private static final Logger log = LogManager.getLogger(DataProcessService.class);
	@Autowired
	InputDetailsRepository inputDetailsRepository;
	@Autowired
	OutputDetailsRepository outputDetailsRepository;

	public static final String CREATED_BY = "Swapnagandha Patil";
	public List<OutputDetails> processDataAndSaveIntoTheOutput(String createdBy) {
		List<OutputDetails> outPutList = new ArrayList<OutputDetails>();
		String createdByName = (createdBy!=null)?createdBy:CREATED_BY;
		try {
			List<InputDetails> inputlist = inputDetailsRepository.findAll();
			if (inputlist != null && inputlist.size() > 0) {
				for (InputDetails inputDetails : inputlist) {
					String inputStr = inputDetails.getData();
					Optional<String> checkNull = Optional.ofNullable(inputStr);
					if (checkNull.isPresent()) { // check for value is present or not
						Map<String, Integer> outputMap = processInputString(inputStr);
						if (outputMap.size() > 0) {
							Map.Entry<String, Integer> entry = outputMap.entrySet().iterator().next();
							Timestamp createdDateAndTime = Timestamp.from(Instant.now());
							OutputDetails OutputDetails = new OutputDetails(entry.getKey(), entry.getValue(), createdByName,
									createdDateAndTime);
							try {
								outPutList.add(outputDetailsRepository.save(OutputDetails));
							}catch(Exception e) {
								log.error("Exception  Occured while saving data into output table", e.getMessage());
							}
						}
					} else {
						log.info("Input String is null");
					}
				}
			}
		} catch (Exception e) {
			log.error("Exception  Occured ", e.getMessage());
		}
		return outPutList;
	}

	private Map<String, Integer> processInputString(String inputDataStr) {
		Map<String, Integer> outputMap = new HashMap<String, Integer>();
		try {
		
			int countOfSteps = 0;
			Stack<Character> st = new Stack<Character>();
			int i = 0;
			// Traverse the String str
			while (i < inputDataStr.length()) {
				if (st.isEmpty() || inputDataStr.charAt(i) != st.peek()) {
					if (Character.isWhitespace(inputDataStr.charAt(i))) {
						inputDataStr = inputDataStr.replaceAll("\\s", "");
						continue;
					}
					st.add(inputDataStr.charAt(i));
					i++;
				} else {
					st.pop();
					countOfSteps++;
					i++;
				}
			}

			if (st.isEmpty()) {
				return outputMap;
			}

			else {
				String short_String = "";
				while (!st.isEmpty()) {
					short_String = st.peek() + short_String;
					st.pop();
				}
				outputMap.put(short_String, countOfSteps);
			}
		
		
		}catch(Exception e) {
			log.error("Exception  Occured while processing data", e.getMessage());
		}
		return outputMap;
	}	
}
