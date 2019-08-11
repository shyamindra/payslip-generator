package com.myob.payslip.employee;

public class Salary {

	private long grossSal;
	private long tax;
	private long superAmt;

	public Salary(final long grossSal, final long tax, final long superAmt){
		this.grossSal = grossSal;
		this.tax = tax;
		this.superAmt =	superAmt;
	}

	public long getGrossSal() {
		return grossSal;
	}

	public long getTax() {
		return tax;
	}

	public long getSuperAmt() {
		return superAmt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Salary salary = (Salary) o;

		if (grossSal != salary.grossSal) return false;
		if (tax != salary.tax) return false;
		return superAmt == salary.superAmt;
	}

	@Override
	public int hashCode() {
		int result = (int) (grossSal ^ (grossSal >>> 32));
		result = 31 * result + (int) (tax ^ (tax >>> 32));
		result = 31 * result + (int) (superAmt ^ (superAmt >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "Salary{" +
				"grossSal=" + grossSal +
				", tax=" + tax +
				", superAmt=" + superAmt +
				'}';
	}
}
