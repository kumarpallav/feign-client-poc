package com.example.studentservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient (name="address-service",url="http://localhost:8080")
public interface AddressProxy {
	@GetMapping("/student/{studentId}/addresses")
	ResponseEntity<Addresses> getStudentAddress(@PathVariable("studentId") Long studentId);

}
