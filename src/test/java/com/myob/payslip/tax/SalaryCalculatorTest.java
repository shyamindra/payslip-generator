package com.myob.payslip.tax;

import com.myob.payslip.employee.Employee;
import com.myob.payslip.employee.Salary;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SalaryCalculatorTest {

	private static SalaryCalculator salaryCalculator;

	@BeforeAll
	static void setupSalaryCalc(){
		salaryCalculator = new SalaryCalculator();
	}

	@Test
	void initTest(){
		assertNotNull(salaryCalculator);
	}

	@Test
	void grossIncomeTest(){
		assertEquals(5004, salaryCalculator.getGrossIncome(60050));
	}

	@Test
	void grossIncomeNegativeTest(){
		assertNotEquals(5005, salaryCalculator.getGrossIncome(60050));
	}

	@Test
	void calcSuperTest(){
		assertEquals(450, salaryCalculator.getSuperAmt(5004, "9%"));
	}

	@Test
	void calcSuperNegativeTest(){
		assertNotEquals(450.36, salaryCalculator.getSuperAmt(5004, "9%"));
	}

	@Test
	void getTaxTest(){
		assertEquals(922, salaryCalculator.getTax(60050));
	}

	@Test
	void getTaxLowerLimitTest(){
		assertEquals(0, salaryCalculator.getTax(12000));
	}

	@Test
	void employeeSalTest(){
		assertEquals(new Salary(10000, 2669, 900)
				,salaryCalculator.getEmployeeSalary(
				new Employee("Michael",
						"Scott",
						120000,
						"9%",
						"01 May - 30 May")));
	}

	@Test
	void populateSalaryTest(){
		List<Employee> employees =  new ArrayList<>() {{
			add(new Employee("Michael",
					"Scott",
					120000,
					"9%",
					"01 May - 30 May"));
		}};
		employees = salaryCalculator.populateSalaries(employees);
		assertEquals(new Salary(10000, 2669, 900), employees.get(0).getSalary());
	}
}
