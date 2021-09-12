package com.csi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;

@Component
public class EmployeeDaoImpl {

	@Autowired
	EmployeeRepository employeeRepositoryImpl;

	public List<Employee> getAllData() {
		return employeeRepositoryImpl.findAll();
	}

	public Optional<Employee> getDataById(long empId) {
		return employeeRepositoryImpl.findById(empId);
	}

	public Employee saveData(Employee employee) {
		return employeeRepositoryImpl.save(employee);
	}

	public Employee updateData(long empId, Employee employee) {

		Employee e = new Employee();

		for (Employee emp : employeeRepositoryImpl.findAll()) {
			if (emp.getEmpId() == empId) {
				e = employeeRepositoryImpl.save(employee);
			}
		}

		return e;
	}

	public void deleteData(long empId) {
		employeeRepositoryImpl.deleteById(empId);
	}
}
