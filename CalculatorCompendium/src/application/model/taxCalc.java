package application.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class taxCalc {
	
	private double householdIncome;
	
	private int contribution401k;
	private int contributionIRA;
	private int deductions;
	private int numTaxExceptions;
	private String filingStatus;
	private String location;
	ArrayList<taxCalcState> states = new ArrayList<taxCalcState>();
	ArrayList<taxCalcBracket> fedTaxRatesSingle = new ArrayList<taxCalcBracket>();
	ArrayList<taxCalcBracket> fedTaxRatesMarried = new ArrayList<taxCalcBracket>();

	public taxCalc(double hshldIncome, int cont401k, int contIRA, int ded, int numExcepts, String flingStatus, String loc) {
		this.setHouseholdIncome(hshldIncome);
		this.setContribution401k(cont401k);
		this.setContributionIRA(contIRA);
		this.setDeductions(ded);
		this.setNumTaxExceptions(numExcepts);
		this.setFilingStatus(flingStatus);
		this.setLocation(loc);
		
	}
	
	public void loadFederalTaxes() {
		fedTaxRatesSingle.add(new taxCalcBracket(0.1, 0, 9950));
		fedTaxRatesSingle.add(new taxCalcBracket(0.12, 9950, 40525));
		fedTaxRatesSingle.add(new taxCalcBracket(0.22, 40525, 86375));
		fedTaxRatesSingle.add(new taxCalcBracket(0.24, 86375, 164925));
		fedTaxRatesSingle.add(new taxCalcBracket(0.32, 164925, 209425));
		fedTaxRatesSingle.add(new taxCalcBracket(0.35, 209425, 523600));
		fedTaxRatesSingle.add(new taxCalcBracket(0.37, 523600, 2147483647));
		fedTaxRatesMarried.add(new taxCalcBracket(0.1, 0, 19900));
		fedTaxRatesMarried.add(new taxCalcBracket(0.12, 19900, 81050));
		fedTaxRatesMarried.add(new taxCalcBracket(0.22, 81050, 172750));
		fedTaxRatesMarried.add(new taxCalcBracket(0.24, 172750, 329850));
		fedTaxRatesMarried.add(new taxCalcBracket(0.32, 329850, 418850));
		fedTaxRatesMarried.add(new taxCalcBracket(0.35, 418850, 628300));
		fedTaxRatesMarried.add(new taxCalcBracket(0.37, 628300, 2147483647));
	}
	
	public void loadStates(String fileName) {
		try {
			File file = new File(fileName);
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String stateName = scan.nextLine();
				taxCalcState newState = new taxCalcState(stateName);
				this.states.add(newState);
			}
			scan.close();
		} catch (IOException e) {
			System.out.println("Error loading the file - please check its location.");
			e.printStackTrace();
		}
	}
	
	public void loadTaxRates(String fileName, String sts) {
		String[] temp;
		
		try {
			File file = new File(fileName);
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				temp = scan.nextLine().split(",");
				int index = findStateIndex(temp[0]);
				for(int i = 1; i<temp.length; i+=2) {
					if(i+1 < temp.length) {
						this.states.get(index).addToArrayList(sts, Integer.parseInt(temp[i]),  Integer.parseInt(temp[i+2]), Double.parseDouble(temp[i+1]));						
					}
				}
			}
			scan.close();
		} catch (IOException e) {
			System.out.println("Error loading the file");
			e.printStackTrace();
		}
	}
	
	public void loadLocalTaxes(String fileName) {
		String[] temp;
		try {
			File file = new File(fileName);
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				temp = scan.nextLine().split(",");
				int index = findStateIndex(temp[0]);
				this.states.get(index).setAvgLocalTaxRate(Double.parseDouble(temp[1]));
			}
			scan.close();
		} catch (IOException e) {
			System.out.println("Error loading the file");
			e.printStackTrace();
		}
	}
	
	public int findStateIndex(String nm) {
		int index = -1;
		for(int i = 0; i < this.states.size(); i++) {		
			if(this.states.get(i).getName().equals(nm)) {
				index = i;
			}
		}
		return index;
	}

	public double calcFedTaxes(double householdInc, int cont401k, int contIRA, String filingStatus) {
		double federalTaxes = 0.0;
		double taxableIncome = householdInc - cont401k - contIRA;
		
		ArrayList<taxCalcBracket> current = new ArrayList<taxCalcBracket>();
		if (filingStatus.equals("Single")) {
			current = this.fedTaxRatesSingle;
		} else if (filingStatus.equals("Married")) {
			current = this.fedTaxRatesMarried;
		}
		
		for(int i=0; i<current.size(); i++) {
			if(!((taxableIncome > current.get(i).getStartingIncome()) && (taxableIncome <= current.get(i).getMaxIncome()))) {
				federalTaxes += current.get(i).getMaxTaxes();
			} else {
				federalTaxes += current.get(i).getTaxRate() * (taxableIncome - current.get(i).getStartingIncome());
				break;
			}
		}
		return federalTaxes;
	}
	
	public double calcTaxes() {
		double totalTaxes = 0.0;
		int stateIndex = findStateIndex(this.location);
		totalTaxes = this.states.get(stateIndex).calcStateAndLocalTaxes(this.householdIncome, this.contribution401k, this.contributionIRA, this.filingStatus) + this.calcFedTaxes(this.householdIncome, this.contribution401k, this.contributionIRA, this.filingStatus);
		return totalTaxes;
	}
	
	public double calcDeductions() {
		double deductions = 0;
//		if 
		return deductions;
	}
	
	public double getHouseholdIncome() {
		return householdIncome;
	}

	public void setHouseholdIncome(double householdIncome) {
		this.householdIncome = householdIncome;
	}

	public int getContribution401k() {
		return contribution401k;
	}

	public void setContribution401k(int contribution401k) {
		this.contribution401k = contribution401k;
	}

	public int getContributionIRA() {
		return contributionIRA;
	}

	public void setContributionIRA(int contributionIRA) {
		this.contributionIRA = contributionIRA;
	}

	public int getDeductions() {
		return deductions;
	}

	public void setDeductions(int deductions) {
		this.deductions = deductions;
	}

	public int getNumTaxExceptions() {
		return numTaxExceptions;
	}

	public void setNumTaxExceptions(int numTaxExceptions) {
		this.numTaxExceptions = numTaxExceptions;
	}

	public String getFilingStatus() {
		return filingStatus;
	}

	public void setFilingStatus(String filingStatus) {
		this.filingStatus = filingStatus;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}