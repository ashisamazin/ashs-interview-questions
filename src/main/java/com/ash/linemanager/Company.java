package com.ash.linemanager;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Internal tree structure. It is effectively a binary search tree since
 * Employee's can only have two sub employees. Without this restriction it is
 * not a binary tree
 *
 */
public class Company {

	private Employee headOfCompany;

	public void addManagerAndEmployee(String managerName, String subordinateName) {
		if (headOfCompany == null) {
			headOfCompany = new Employee(managerName);
			headOfCompany.addEmployee(new Employee(subordinateName));
		} else {
			// find the managerName to place in the tree
			Employee manager = getEmployeeForName(headOfCompany, managerName);
			manager.addEmployee(new Employee(subordinateName));
		}
	}

	public String getCommonManager(String firstEmployee, String secondEmployee) {
		// start at the root node and work recursively down
		return getCommonManager(headOfCompany, firstEmployee, secondEmployee);
	}

	// Level by level Breadth First Search of the binary tree
	@Override
	public String toString() {
		List<Employee> currentLevel = new LinkedList<Employee>();
		List<Employee> nextLevel = new LinkedList<Employee>();

		currentLevel.add(headOfCompany);

		StringBuffer result = new StringBuffer();
		while (!currentLevel.isEmpty()) {
			Employee currentEmployee = currentLevel.remove(0);
			result.append(currentEmployee.getName() + " ");
			nextLevel.addAll(currentEmployee.getEmployees());

			if (currentLevel.size() == 0) {
				result.append("\n");
				currentLevel.addAll(nextLevel);
				nextLevel.clear();
			}
		}
		return result.toString();
	}

	private Employee getEmployeeForName(Employee root, String employeeName) {
		// recurse through the organisation looking for the employee with
		// the given name
		Stack<Employee> employeesToCheck = new Stack<Employee>();
		employeesToCheck.push(root);

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

	private String getCommonManager(Employee root, String firstEmployee, String secondEmployee) {
		Employee manager1 = root.getEmployee1();
		Employee manager2 = root.getEmployee2();

		// if manager 1 is a parent of first and second employee, then
		// recurse
		if (isParent(manager1, firstEmployee) && isParent(manager1, secondEmployee)) {
			return getCommonManager(manager1, firstEmployee, secondEmployee);
		} else if (isParent(manager2, firstEmployee) && isParent(manager2, secondEmployee)) {
			return getCommonManager(manager2, firstEmployee, secondEmployee);
		} else {
			return root.getName();
		}
	}

	private boolean isParent(Employee manager, String employee) {
		return manager != null && getEmployeeForName(manager, employee) != null;
	}

}
