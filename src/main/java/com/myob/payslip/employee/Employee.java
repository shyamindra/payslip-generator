package com.myob.payslip.employee;

import com.opencsv.bean.CsvBindByPosition;

import java.util.Objects;

public class Employee {

	@CsvBindByPosition(position = 0)
	private String firstName;
	@CsvBindByPosition(position = 1)
	private String lastName;
	@CsvBindByPosition(position = 2)
	private long annualSal;
	@CsvBindByPosition(position = 3)
	private String superRate;
	@CsvBindByPosition(position = 4)
	private String payStartDate;

	private Salary salary;

	/*
		Default constructor for the CsvReader to initialize an empty Employee object
		and populate the values
	 */
	public Employee(){

	}

	public Employee(final String firstName,
					final String lastName,
					final long annualSal,
					final String superRate,
					final String payStartDate){
		this.firstName = firstName;
		this.lastName = lastName;
		this.annualSal = annualSal;
		this.superRate = superRate;
		this.payStartDate = payStartDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public long getAnnualSal() {
		return annualSal;
	}

	public String getSuperRate() {
		return superRate;
	}

	public String getPayStartDate() {
		return payStartDate;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	/*
		Verify the input salary and throw a runtime exception if the salary is invalid
	 */
	public void validateAnnualSalary(){
		if(this.annualSal <= 0) {
			throw new RuntimeException("Invalid Salary : Please verify the input details");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Employee employee = (Employee) o;

		if (annualSal != employee.annualSal) return false;
		if (!Objects.equals(firstName, employee.firstName)) return false;
		if (!Objects.equals(lastName, employee.lastName)) return false;
		if (!Objects.equals(superRate, employee.superRate)) return false;
		return Objects.equals(payStartDate, employee.payStartDate);
	}

	@Override
	public int hashCode() {
		int result = firstName != null ? firstName.hashCode() : 0;
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (int) (annualSal ^ (annualSal >>> 32));
		result = 31 * result + (superRate != null ? superRate.hashCode() : 0);
		result = 31 * result + (payStartDate != null ? payStartDate.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", annualSal=" + annualSal +
				", superRate='" + superRate + '\'' +
				", payStartDate='" + payStartDate + '\'' +
				'}';
	}
}
