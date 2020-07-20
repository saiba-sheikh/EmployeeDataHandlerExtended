package com.model;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "employees")
@XmlAccessorType (XmlAccessType.FIELD)
public class EmployeesDetails{
	@XmlElement(name = "employee")
    private List<EmployeeDetails> employees = null;

	public List<EmployeeDetails> getEmployees() {
        return employees;
    }
 
    public void setEmployees(List<EmployeeDetails> employees) {
        this.employees = employees;
    }


}
