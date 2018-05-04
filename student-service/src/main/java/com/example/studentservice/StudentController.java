package com.example.studentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudentController {
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private AddressProxy addressProxy;
	
	
	@GetMapping("student/{studentId}")
	public Student getStudent(@PathVariable("studentId")Long studentId){
		Student s= new Student();
		s.setId(studentId);
		s.setName("Ray Mcfallen");
		s.setRoll(5);
		ResponseEntity<Addresses> studentAddress=restTemplate.getForEntity("http://localhost:8080//student/"+studentId+"/addresses", Addresses.class);
		s.setAddress(studentAddress.getBody().getAddresses());
		return s;
		
	}

	
	@GetMapping("feign/student/{studentId}")
	public Student getStudentViaFeigh(@PathVariable("studentId")Long studentId){
		Student s= new Student();
		s.setId(studentId);
		s.setName("Ray Mcfallen");
		s.setRoll(5);
		ResponseEntity<Addresses> studentAddress=addressProxy.getStudentAddress(studentId);
		s.setAddress(studentAddress.getBody().getAddresses());
		return s;
		
	}
}
