package application.model;

//import java.util.Arrays;
//import java.util.Enumeration;
//import java.util.Hashtable;
//import java.util.Map;

public class taxCalcBracket {
	private double taxRate;
	private int startingIncome;
	private int maxIncome;
	private double maxTaxes;
	
	public taxCalcBracket(double txRate, int stIncome, int mxIncome) {
		this.taxRate = txRate;
		this.maxIncome = mxIncome;
		this.startingIncome = stIncome;
		this.maxTaxes = this.maxIncome*this.taxRate;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public int getStartingIncome() {
		return startingIncome;
	}

	public void setStartingIncome(int startingIncome) {
		this.startingIncome = startingIncome;
	}

	public int getMaxIncome() {
		return maxIncome;
	}

	public void setMaxIncome(int maxIncome) {
		this.maxIncome = maxIncome;
	}

	public double getMaxTaxes() {
		return maxTaxes;
	}

	public void setMaxTaxes(double maxTaxes) {
		this.maxTaxes = maxTaxes;
	}
	
}