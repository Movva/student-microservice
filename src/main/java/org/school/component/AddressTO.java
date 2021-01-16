package org.school.component;

public class AddressTO {
	private Integer index;
	private String doorNo;
	private String streetName;
	private String city;
	private String State;
	private Integer pincode;
	
	
	public AddressTO() {
		super();
	}
	public AddressTO(Integer index, String doorNo, String streetName, String city, String state, Integer pincode) {
		super();
		this.index = index;
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.city = city;
		State = state;
		this.pincode = pincode;
	}
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public Integer getIndex() {
		return index;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((State == null) ? 0 : State.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((doorNo == null) ? 0 : doorNo.hashCode());
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((pincode == null) ? 0 : pincode.hashCode());
		result = prime * result + ((streetName == null) ? 0 : streetName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressTO other = (AddressTO) obj;
		if (State == null) {
			if (other.State != null)
				return false;
		} else if (!State.equals(other.State))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (doorNo == null) {
			if (other.doorNo != null)
				return false;
		} else if (!doorNo.equals(other.doorNo))
			return false;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (pincode == null) {
			if (other.pincode != null)
				return false;
		} else if (!pincode.equals(other.pincode))
			return false;
		if (streetName == null) {
			if (other.streetName != null)
				return false;
		} else if (!streetName.equals(other.streetName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format("Address [index=%s, doorNo=%s, streetName=%s, city=%s, State=%s, pincode=%s]", index,
				doorNo, streetName, city, State, pincode);
	}
	
	
	
}
