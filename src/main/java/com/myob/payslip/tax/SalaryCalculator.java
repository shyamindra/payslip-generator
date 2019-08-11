package com.myob.payslip.tax;

import com.myob.payslip.employee.Employee;
import com.myob.payslip.employee.Salary;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SalaryCalculator {

	private List<TaxSlab> taxSlabList;

	// Assumption: the max salary would not exceed Long.MAX_VALUE, unless it's Bezos
	public SalaryCalculator(){
		taxSlabList = new ArrayList<>(){{
			add(new TaxSlab(0, 18200, 0, 0));
			add(new TaxSlab(18201, 37000, 0, 0.19));
			add(new TaxSlab(37001, 87000, 3572, 0.325));
			add(new TaxSlab(87001, 180000, 19822, 0.37));
			add(new TaxSlab(18001, Long.MAX_VALUE, 54232, 0.45));
		}};
	}

	public List<Employee> populateSalaries(List<Employee> employees){
		employees
				.stream()
				.forEach(employee -> employee.setSalary(getEmployeeSalary(employee)));

		return employees;
	}

	public Salary getEmployeeSalary(Employee employee){
		long grossSalary = getGrossIncome(employee.getAnnualSal());
		return new Salary(grossSalary,
				getTax(employee.getAnnualSal()),
				getSuperAmt(grossSalary, employee.getSuperRate()));
	}

	/*
		Assumption: the input for the super value is correct and has a % at the end
	 */
	public long getSuperAmt(long grossSal, String superRate){
		return Math.round((grossSal * Double.parseDouble(superRate.substring(0, superRate.length() - 1)))/100);
	}

	/*
		returns the rounded gross income per month
	 */
	public long getGrossIncome(long annualSal){
		return annualSal/12; // int/int returns rounded int
	}

	/*
		Find the effective tax slab and calculate the tax based off that
		Ideally only one tax la would be returned from the filter
	 */
	public long getTax(long annualSal){
		TaxSlab effectiveTaxSlab = taxSlabList
										.stream()
										.filter(taxSlab -> annualSal > taxSlab.getLowerRange()
												&& annualSal < taxSlab.getUpperRange())
										.collect(Collectors.toList()).get(0);
		return Math.round((effectiveTaxSlab.getMintax()
				+ ((annualSal - effectiveTaxSlab.getLowerRange()) * effectiveTaxSlab.getTaxPerDollar()))/12);

	}
}
