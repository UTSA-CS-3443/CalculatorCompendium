/**
 * 
 * TaxCalcBracket is used to store the tax rates and brackets for each state and the federal level. 
 * 
 * @author Don Ayesh Sondapperumaarachchi
 * 
 */


package application.model;

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