package com.ash.linemanager;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	private final String name;
	private List<Employee> employees;

	public Employee(String name) {
		this.name = name;
		this.employees = new ArrayList<Employee>(2);
	}

	public void addEmployee(Employee employee) {
		if (employees.size() < 2) {
			this.employees.add(employee);
		}
	}

	public String getName() {
		return name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", employees=" + employees + "]";
	}

}
