package application.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;
import java.util.Map;

public class taxCalc {
	
	private int householdIncome;
	private int contribution401k;
	private int contributionIRA;
	private int deductions;
	private int numTaxExceptions;
	private String filingStatus;
	private String location;
	private taxCalcState[] states;
	Hashtable<Integer, Double> fedTaxRatesSingle = new Hashtable<>();
	Hashtable<Integer, Double> fedTaxRatesMarried = new Hashtable<>();

	
	public taxCalc(int hshldIncome, int cont401k, int contIRA, int ded, int numExcepts, String flingStatus, String loc) {
		this.householdIncome = hshldIncome;
		this.contribution401k = cont401k;
		this.contributionIRA = contIRA;
		this.deductions = ded;
		this.numTaxExceptions = numExcepts;
		this.filingStatus = flingStatus;
		this.location = loc;
		fedTaxRatesSingle.put(0, 0.1);
		fedTaxRatesSingle.put(9950, 0.12);
		fedTaxRatesSingle.put(40525, 0.22);
		fedTaxRatesSingle.put(86375, 0.24);
		fedTaxRatesSingle.put(164925, 0.32);
		fedTaxRatesSingle.put(209425, 0.35);
		fedTaxRatesSingle.put(523600, 0.37);
		fedTaxRatesMarried.put(0, 0.1);
		fedTaxRatesMarried.put(19900, 0.12);
		fedTaxRatesMarried.put(81050, 0.22);
		fedTaxRatesMarried.put(172750, 0.24);
		fedTaxRatesMarried.put(329850, 0.32);
		fedTaxRatesMarried.put(418850, 0.35);
		fedTaxRatesMarried.put(628300, 0.37);
		

	}
	
	public void loadTaxRates(String fileName) {
		String[] temp;
		String tempName;
		try {
			File file = new File(fileName);
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				temp = scan.nextLine().split(",");
				
			}
			scan.close();
		} catch (

		IOException e) {
			System.out.println("Error loading the file");
			e.printStackTrace();
		}
	}
	
}