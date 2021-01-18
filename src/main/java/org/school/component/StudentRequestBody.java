package org.school.component;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StudentRequestBody {
	private String id;
	private String fname;
	private String lname;
	private List<AddressRequestBody> address;
	public List<AddressRequestBody> getAddress() {
		return address;
	}
	public void setAddress(List<AddressRequestBody> address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
}
