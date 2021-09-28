package com.example.truemedsAssignment.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name = "firstname_lastname_java_output_new")
public class OutputDetails {
	
	

	public OutputDetails(String finalOutput, int count, String createdBy, Timestamp creationdateTimestamp) {
		super();
		this.finalOutput = finalOutput;
		this.count = count;
		this.createdBy = createdBy;
		this.creationdateTimestamp =creationdateTimestamp;
	}

	public OutputDetails(){
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "final_output")
	String finalOutput;

	@Column(name = "count")
	int count;
	
	@Column(name = "createdBy")
	String createdBy;
	
	@Column(name = "creationdateTimestamp")
	Timestamp creationdateTimestamp;
	
	public Timestamp getCreationdateTimestamp() {
		return creationdateTimestamp;
	}

	public void setCreationdateTimestamp(Timestamp creationdateTimestamp) {
		this.creationdateTimestamp = creationdateTimestamp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFinalOutput() {
		return finalOutput;
	}

	public void setFinalOutput(String finalOutput) {
		this.finalOutput = finalOutput;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	


	
	
	
}
