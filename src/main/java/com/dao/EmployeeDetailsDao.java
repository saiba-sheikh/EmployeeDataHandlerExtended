package com.dao;

import java.util.List;

import com.dao.EmployeeDao;
import com.helper.DataHandler;
import com.helper.DataHandlingFactory;
import com.model.Employee;
import com.model.EmployeeDetails;
import com.model.Employees;
import com.model.EmployeesDetails;
import com.model.exception.NoRecordFoundException;

public class EmployeeDetailsDao implements EmployeeDao<EmployeeDetails> {
	static final String FIELD_ID_NAME = "employeeId";

	private DataHandler<EmployeesDetails> dataHandler;
	
	public EmployeeDetailsDao(String dbType, String fileName) {
		this.dataHandler = DataHandlingFactory.getDataHandler(dbType, EmployeesDetails.class, fileName);
	}

	@Override
	public List<EmployeeDetails> getAll() {
		EmployeesDetails employees = dataHandler.readDocument();
		return employees.getEmployees();
	}

	@Override
	public void deleteById(String employeeId) {
		try {
			dataHandler.deleteElement(FIELD_ID_NAME, employeeId);
			System.out.println("Successfully deleted record");
		} catch (NoRecordFoundException ex) {
			System.out.println("No Record found for employee ID: " + employeeId);
		}
	}

	@Override
	public void add(EmployeeDetails employee) {
		dataHandler.addDataNode(employee, EmployeeDetails.class);
		System.out.println("Successfully added record");
	}

}
