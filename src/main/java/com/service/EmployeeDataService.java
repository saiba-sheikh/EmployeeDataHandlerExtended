package com.service;

import java.util.List;
import java.util.Scanner;

import com.dao.EmployeeDao;
import com.model.Address;
import com.model.Designation;
import com.model.EmployeeDetails;
import com.services.InputService;
import com.services.Services;

public class EmployeeDataService implements Services<EmployeeDetails> {

	private EmployeeDao employeeDao;
	private InputService inputService;
	
	public EmployeeDataService(EmployeeDao employeeDao, InputService inputService) { 
		this.employeeDao = employeeDao; 
		this.inputService = inputService;
	}
	
	public List<EmployeeDetails> getAll() {
		List<EmployeeDetails> employees = employeeDao.getAll();
		return employees;
	}

	public void deleteById() {
		String employeName = inputService.getEmployeeId();
		employeeDao.deleteById(employeName);	
	}
	public void display() {
		List<EmployeeDetails> employees = getAll();
		System.out.println("-----------------------------------------------------------------------------");
	    System.out.printf("%2s %10s %5s %10s %30s", "ID", "NAME", "AGE", "Designation", "Address");
	    System.out.println();
	    System.out.println("-----------------------------------------------------------------------------");
		employees.stream().forEach(employee ->{
			 System.out.format("%2s %10s %5s %10s %40s",
		                employee.getEmployeeId(), employee.getName(), employee.getAge(), employee.getDesignation(), employee.getAddress());
		        System.out.println();
		});
		
	    System.out.println("-----------------------------------------------------------------------------");
		
		
	}

	@Override
	public void addEmployee() {
		String employeeId = inputService.getEmployeeId();
		String employeeName = inputService.getEmployeeName();
		int age = inputService.getAge();
		Designation designation = inputService.getDesignation();
		Address address = ( (EmployeeDataInputServices)inputService).getAddress();
		EmployeeDetails employee = new EmployeeDetails(employeeId, employeeName, designation, age, address);
		employeeDao.add(employee);	
		
	}

}
