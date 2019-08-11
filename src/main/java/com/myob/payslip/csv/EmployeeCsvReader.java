package com.myob.payslip.csv;

import com.myob.payslip.employee.Employee;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeeCsvReader {

	private final String filePath;

	public EmployeeCsvReader(final String filePath){
		this.filePath = filePath;
	}

	public List<Employee> readCsv() throws IOException {
		Reader reader = Files.newBufferedReader(Paths.get(this.filePath));
		CsvToBean<Employee> csvToBean = new CsvToBeanBuilder<Employee>(reader)
				.withType(Employee.class)
				.withIgnoreLeadingWhiteSpace(true)
				.build();

		return csvToBean.parse();

	}
}
