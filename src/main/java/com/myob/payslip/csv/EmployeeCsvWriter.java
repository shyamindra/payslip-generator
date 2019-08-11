package com.myob.payslip.csv;

import com.myob.payslip.employee.Employee;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EmployeeCsvWriter {

	public void writeToCSV(List<Employee> employees, String filePath) throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter(filePath), CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER);

		for(Employee employee : employees){
			String [] employeeData = {employee.getFirstName() + " " + employee.getLastName(),
					employee.getPayStartDate(),
					String.valueOf(employee.getSalary().getGrossSal()),
					String.valueOf(employee.getSalary().getTax()),
					String.valueOf(employee.getSalary().getGrossSal() - employee.getSalary().getTax()),
					String.valueOf(employee.getSalary().getSuperAmt())};
			//Write the record to file
			writer.writeNext(employeeData);

			//close the writer
		}
		writer.close();
	}
}
