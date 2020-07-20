package com.service;

import java.util.Scanner;

import com.model.Address;
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

}
