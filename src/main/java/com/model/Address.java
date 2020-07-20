package com.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "address")
@XmlAccessorType (XmlAccessType.FIELD)
public class Address {

	private String doorNo;
	private String street;
	private String town;
	private String state;
	
	public Address() {}
	private Address(String doorNo, String street, String town, String state) {
		this.doorNo = doorNo;
		this.street = street;
		this.town = town;
		this.state = state;
	}
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "[doorNo=" + doorNo + ", street=" + street + ", town=" + town + ", state=" + state + "]";
	}
	public static class AddressBuilder {
		private String doorNo;
		private String street;
		private String town;
		private String state;
		
		public static AddressBuilder addressBuilder() {
			return new AddressBuilder();
		}
		public AddressBuilder withStreetName(String streetName) {
			this.street = streetName;
			return this;
		}
		
		public AddressBuilder withDoorNum(String doorNum) {
			this.doorNo = doorNum;
			return this;

		}	

		public AddressBuilder withTown(String town) {
			this.town = town;
			return this;

		}
		
		public AddressBuilder withState(String state) {
			this.state = state;
			return this;
		}
		
		public Address build() {
			return new Address(doorNo, street, town, state);
		}
	}
}
