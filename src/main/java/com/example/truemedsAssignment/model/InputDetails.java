package com.example.truemedsAssignment.model;

import javax.persistence.*;

@Entity
@Table(name = "input_details")
public class InputDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "input_string")
	String inputString;

	
	  public InputDetails(String inputString) { super(); this.inputString =
	  inputString; }
	 
	public InputDetails() {
		
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getData() {
		return inputString;
	}

	public void setData(String inputString) {
		this.inputString = inputString;
	}
	

}
