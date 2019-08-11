package com.myob.payslip;

import com.myob.payslip.csv.EmployeeCsvReader;
import com.myob.payslip.csv.EmployeeCsvWriter;
import com.myob.payslip.employee.Employee;
import com.myob.payslip.tax.SalaryCalculator;

import java.io.IOException;
import java.util.List;

public class PayslipGenerator {

	private static final String EMPLOYEE_CSV_FILE = "input.csv";
	private static final String EMPLOYEE_CSV_OP_FILE = "output.csv";

	public static void main(String[] args) throws Exception {
		try {

			List<Employee> employees = new EmployeeCsvReader(EMPLOYEE_CSV_FILE).readCsv();
			employees = new SalaryCalculator().populateSalaries(employees);
			new EmployeeCsvWriter().writeToCSV(employees, EMPLOYEE_CSV_OP_FILE);

		} catch (IOException e) {
			throw new Exception("Invalid input file");
		}
	}
}
