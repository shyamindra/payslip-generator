package com.myob.payslip.tax;

public class TaxSlab {

	private final long lowerRange;
	private final long upperRange;
	private final long mintax;
	private final double taxPerDollar;

	public TaxSlab(final long lowerRange, final long upperRange, final long mintax, final double taxPerDollar){
		this.lowerRange = lowerRange;
		this.upperRange = upperRange;
		this.mintax = mintax;
		this.taxPerDollar =	taxPerDollar;
	}

	public long getLowerRange() {
		return lowerRange;
	}

	public long getUpperRange() {
		return upperRange;
	}

	public long getMintax() {
		return mintax;
	}

	public double getTaxPerDollar() {
		return taxPerDollar;
	}
}
