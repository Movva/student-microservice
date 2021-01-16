package org.school.component;

import org.springframework.stereotype.Component;

@Component
public class StudentResponseBody {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
