package application.model;

import java.util.ArrayList;

public class taxCalcState {
	private String name;
	private double avgLocalTaxRate;
	
	ArrayList<taxCalcBracket> single = new ArrayList<taxCalcBracket>();
	ArrayList<taxCalcBracket> married = new ArrayList<taxCalcBracket>();


	public taxCalcState(String nm) {
		this.name = nm;
	}
	
	public double getAvgLocalTaxRate() {
		return this.avgLocalTaxRate;
	}
	
	public void setAvgLocalTaxRate(double txrate) {
		this.avgLocalTaxRate = txrate;
	}
	
	public void addToArrayList(String status, int stIncome, int mxIncome, double taxRate) {
		if(status == "Single") {
			this.single.add(new taxCalcBracket(taxRate, stIncome, mxIncome));
		} else if (status == "Married") {
			this.married.add(new taxCalcBracket(taxRate, stIncome, mxIncome));
		}
	}

	public String getName() {
		return this.name;
	}
	
	public double calcStateAndLocalTaxes(double taxableIncome, String filingStatus) {
		double localTaxes = taxableIncome * this.getAvgLocalTaxRate();
		double stateTaxes = calcStateTaxes(taxableIncome, filingStatus);
		return localTaxes + stateTaxes;
	}
	
	public double calcStateTaxes(double taxableIncome, String filingStatus) {
		double stateTaxes = 0.0;
		
		ArrayList<taxCalcBracket> current = new ArrayList<taxCalcBracket>();
		if (filingStatus.equals("Single")) {
			current = this.single;
		} else if (filingStatus.equals("Married")) {
			current = this.married;
		}
		
		for(int i=0; i<current.size(); i++) {
			if(!(taxableIncome > current.get(i).getStartingIncome() && taxableIncome <= current.get(i).getMaxIncome())) {
				stateTaxes += current.get(i).getMaxTaxes();
			} else {
				stateTaxes += current.get(i).getTaxRate() * (taxableIncome - current.get(i).getStartingIncome());
				break;
			}
		}

		return stateTaxes;
	}
	
}