package com.myob.payslip.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

	private Employee employee;

	@BeforeEach
	void setupEmployee(){
		this.employee = new Employee("Darth",
				"Vader",
				100000000,
				"27.54%",
				"01 Aug – 31 Aug");
	}

	@Test
	void testEmployeeInit(){
		assertNotNull(this.employee);
	}

	@Test
	void testEmployeeDetails(){
		assertEquals("Darth", employee.getFirstName());
		assertEquals("Vader", employee.getLastName());
		assertEquals(100000000, employee.getAnnualSal());
		assertEquals("27.54%", employee.getSuperRate());
		assertEquals("01 Aug – 31 Aug", employee.getPayStartDate());
	}

	@Test
	void testSalaryException(){
		employee = new Employee("Darth",
				"Vader",
				-2345678,
				"27.54%",
				"01 Aug – 31 Aug");
		assertThrows(RuntimeException.class, () -> employee.validateAnnualSalary());
	}
}
