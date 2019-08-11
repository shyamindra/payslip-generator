package com.myob.payslip.csv;


import com.myob.payslip.employee.Employee;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class EmployeeCsvReaderTest {

	@Test
	void initTest(){
		EmployeeCsvReader csvReader = new EmployeeCsvReader("input.csv");
		assertNotNull(csvReader);
	}

	@Test
	void readInvalidCsvTest() {
		assertThrows(IOException.class, () -> new EmployeeCsvReader("inp.csv").readCsv());
	}

	@Test
	void readCsvTest() throws IOException {
		List<Employee> employeeList = new EmployeeCsvReader("input.csv").readCsv();
		assertEquals(2, employeeList.size());
		Employee employee = new Employee("David","Rudd",60050,"9%","01 March – 31 March");
		assertEquals(employee, employeeList.get(0));
	}

	@Test
	void compareEmployeeTest() throws IOException {
		List<Employee> employeeList = new EmployeeCsvReader("input.csv").readCsv();
		Employee employee = new Employee("Dav","Rudd",60050,"9%","01 March – 31 March");
		assertNotEquals(employee, employeeList.get(0));

	}
}
