package com.ash.linemanager;

import java.util.Stack;

public class Company {

	private Employee headOfCompany;

	public Company() {
	}

	public void addManager(String managerName, String subordinateName) {
		if (headOfCompany == null) {
			headOfCompany = new Employee(managerName);
			headOfCompany.addEmployee(new Employee(subordinateName));
		} else {
			// find the managerName to place in the tree
			Employee manager = getEmployeeForName(managerName);
			manager.addEmployee(new Employee(subordinateName));
		}
	}

	private Employee getEmployeeForName(String employeeName) {
		// recurse through the organisation looking for the employee with the
		// given name
		Stack<Employee> employeesToCheck = new Stack<Employee>();
		employeesToCheck.push(headOfCompany);

		while (!employeesToCheck.isEmpty()) {
			Employee currentEmployee = employeesToCheck.pop();
			if (currentEmployee.getName().equals(employeeName)) {
				return currentEmployee;
			} else {
				employeesToCheck.addAll(currentEmployee.getEmployees());
			}
		}
		// Employee not found
		return null;
	}

	public void printCompany() {
		Stack<Employee> currentLevel = new Stack<Employee>();
		Stack<Employee> nextLevel = new Stack<Employee>();

		currentLevel.push(headOfCompany);

		while (!currentLevel.isEmpty()) {
			Employee currentEmployee = currentLevel.pop();
			System.out.print(currentEmployee.getName() + " ");
			nextLevel.addAll(currentEmployee.getEmployees());

			if (currentLevel.size() == 0) {
				System.out.println();
				currentLevel.addAll(nextLevel);
				nextLevel.clear();
			}
		}

	}

}
