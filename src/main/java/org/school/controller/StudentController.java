package org.school.controller;

import java.util.ArrayList;
import java.util.List;

import org.school.DAO.Address;
import org.school.DAO.Student;
import org.school.component.AddressRequestBody;
import org.school.component.AddressTO;
import org.school.component.StudentRequestBody;
import org.school.component.StudentResponseBody;
import org.school.component.StudentTO;
import org.school.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Student/")
public class StudentController {
	
	private static Logger log = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService stuService;
	
	@GetMapping("/get/{studentID}")
	public ResponseEntity<StudentTO> getStudent(@PathVariable(name = "studentID") String studentID){
		var stu = stuService.getStudent(Integer.valueOf(studentID));
		log.info(stu.toString());
		
		// converting DAO to TO
		List<Address> address = stu.getAddress();
		var addressTO = new ArrayList<AddressTO>();
		for(Address ele: address)
			addressTO.add(new AddressTO(ele.getIndex(),ele.getDoorNo(), ele.getStreetName(), ele.getCity(), ele.getState(), ele.getPincode()));
		var student = new StudentTO(stu.getId(),stu.getFname(), stu.getLname(), addressTO);
		
		return ResponseEntity.ok().body(student);
	}
	
	@PostMapping("/create")
	public ResponseEntity<StudentResponseBody> createStudent(@RequestBody StudentRequestBody body){
		var addresses = body.getAddress();
		List<Address> addressesList = new ArrayList<>();
		for(AddressRequestBody ele: addresses) {
			Address address = new Address();
			address.setDoorNo(ele.getDoorNo());
			address.setCity(ele.getCity());
			address.setPincode(ele.getPincode());
			address.setState(ele.getState());
			address.setStreetName(ele.getStreetName());
			addressesList.add(address);
		}
		var stu = new Student();
		stu.setFname(body.getFname());
		stu.setLname(body.getLname());
		stu.setAddress(addressesList);
		stu = stuService.createStudent(stu);
		int id = stu.getId();
		log.info(String.format("Student created with : %d for %s", id,body));
		var stuBody = new StudentResponseBody();
		stuBody.setId(String.valueOf(id));
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(stuBody);
	}
}
