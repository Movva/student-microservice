package org.school.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONObject;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.school.component.AddressTO;
import org.school.component.StudentTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(Parameterized.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class StudentControllerTest {
	
	private static Logger log = LoggerFactory.getLogger(StudentControllerTest.class);
	
	@ClassRule public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();
	@Rule public final SpringMethodRule springMethodRule = new SpringMethodRule();
	@Autowired MockMvc mvc;
	
	@Parameter(value=0)
	public StudentTO student;

	@Parameters
	public static Collection<StudentTO> students(){
		var students = new ArrayList<StudentTO>();
		var address = new ArrayList<AddressTO>();		
		
		//Student 1
		address.add(new AddressTO("24", "4th lane", "Atlanta", "Gerogia", 5666556));
		address.add(new AddressTO("98", "9th lane", "Atlanta", "Gerogia", 5666556));
		students.add(new StudentTO("john","doe", address));
		address.clear();
		
		//Student 2
		address.add(new AddressTO("90", "9th lane", "Atlanta", "Gerogia", 5666556));
		students.add(new StudentTO("jane","doe", address));
		
		return students;
	}
	
	@Test
	public void createStudentTest() throws Exception {
		log.info(String.format("create Test initiated for %s %s",student.getFname(),student.getLname()));		
		var jsonObject = new ObjectMapper().writeValueAsString(this.student);
		var request = post("/api/Student/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonObject);
		var response = this.mvc.perform(request).andExpect(status().isCreated());
		var responseString = response.andReturn().getResponse().getContentAsString();
		String obj = new JSONObject(responseString).get("id").toString();
		Integer foo = Integer.parseInt(obj);
		this.student.setId(foo);
		log.info(responseString);
	}
	
	@Test
	public void getStudentTest() throws Exception {
		log.info("get Student");
		var request = get("/api/Student/get/"+this.student.getId());
		String response = this.mvc.perform(request)
		.andExpect(status().isOk())
		.andReturn()
		.getResponse()
		.getContentAsString();
		log.info(response);
	}
	
}
