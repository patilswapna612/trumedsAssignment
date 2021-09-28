package com.example.truemedsAssignment.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.truemedsAssignment.model.OutputDetails;

@Repository
public interface OutputDetailsRepository extends JpaRepository<OutputDetails, Long> {

}
