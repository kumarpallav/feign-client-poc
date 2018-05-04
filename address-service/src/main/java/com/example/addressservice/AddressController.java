package com.example.addressservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AddressController {
	
@GetMapping("/student/{studentId}/addresses")
public Addresses getStudentAddress(@PathVariable ("studentId") Long studentId){
	List<Address> addressList =new ArrayList<> ();
	Address address= new Address();
	address.setId(1L);
	address.setAddressLine1("12 Lane XYZ");
	address.setAddressLine1("BLR");
	address.setState("KR");
	address.setCountry("IN");
	address.setPin("2233");
	addressList.add(address);
	address= new Address();
	address.setId(2L);
	address.setAddressLine1("12 Lane ABC");
	address.setAddressLine1("NDLS");
	address.setState("NEW DELHI");
	address.setCountry("IN");
	address.setPin("4223");
	addressList.add(address);
	Addresses addresses=new Addresses();
	addresses.setAddresses(addressList);
	return addresses;
	
}

}
