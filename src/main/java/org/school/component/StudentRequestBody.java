package org.school.component;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StudentRequestBody {
	private String id;
	private String firstName;
	private String lastName;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
