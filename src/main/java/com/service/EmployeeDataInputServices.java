package com.service;

import java.util.Arrays;
import java.util.Scanner;

import com.model.Address;
import com.model.Designation;
import com.services.InputService;

public class EmployeeDataInputServices extends InputService{

	public EmployeeDataInputServices(Scanner scanner) {
		super(scanner);
	}
	
	public Address getAddress() {
		System.out.println("Enter Address");
		
		System.out.println("Door No.: ");
		String doorNum = scanner.next();
		scanner.nextLine();
		
		System.out.println("Street Name: ");
		String streetName = scanner.nextLine();
		
		System.out.println("Town: ");
		String town = scanner.nextLine();

		System.out.println("State: ");	
		String state = scanner.nextLine();
		
		return Address.AddressBuilder.addressBuilder().withStreetName(streetName).withDoorNum(doorNum)
					.withTown(town)
					.withState(state)
					.build();

	}
	
	@Override	
	public Designation getDesignation() {
		System.out.println("Select Designation: OR Press D to default");
		System.out.println(Arrays.toString(Designation.values())); 
		String input = scanner.next().strip();
		if(input.equalsIgnoreCase("D"))
			return Designation.DEVELOPER;
		else
		return Designation.getDesignation( input );
			
	}

}
