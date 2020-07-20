package com.main;

import com.dao.EmployeeDetailsDao;
import com.helper.DataHandlingFactory;
import com.helper.XmlDataHandler;
import com.model.EmployeesDetails;
import com.service.EmployeeDataInputServices;
import com.service.EmployeeDataService;
import com.services.InputService;
import com.utils.ConsoleLogger;
import com.utils.ConsoleReader;
import com.utils.LoggerImpl;
import com.utils.PropertyReader;

public class Application {
	private static EmployeeDataService service;
	private static PropertyReader properties;

	/*
	 * The application is initialized for the required dependencies load the
	 * required properties
	 */
	public void initilizeApplication() {
		properties = PropertyReader.getInstance();
		// Register all possible type of handlers
		DataHandlingFactory.register(EmployeesDetails.class, new XmlDataHandler<EmployeesDetails>(properties.getProperty("db.fileName"), EmployeesDetails.class));
		LoggerImpl.registerLogger(new ConsoleLogger());

	}

	public EmployeeDataService employeeService() {
		if (service == null) {
			String dbType = properties.getProperty("db.type");
			String fileName = properties.getProperty("db.fileName");
			EmployeeDetailsDao employeeDao = new EmployeeDetailsDao(dbType, fileName);
			InputService inputService = new EmployeeDataInputServices(ConsoleReader.getConsoleReader().reader());
			service = new EmployeeDataService(employeeDao, inputService);
		}
		return service;
	}

}
