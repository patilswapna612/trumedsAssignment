package com.example.truemedsAssignment.datajpa.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.truemedsAssignment.model.InputDetails;
import com.example.truemedsAssignment.model.OutputDetails;
@Repository
public interface  InputDetailsRepository extends JpaRepository<InputDetails, Long>{

}
