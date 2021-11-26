package application.model;

import java.util.Hashtable;
import java.util.Map;

public class taxCalcState {
	private String name;
	private int avgLocalTaxRate;
	
	Hashtable<Integer, Double> single = new Hashtable<>();
	Hashtable<Integer, Double> married = new Hashtable<>();

	public taxCalcState(String nm) {
		this.name = nm;
		
	}
	
	public void addToHashTable(String status, int income, double taxRate) {
		if(status == "Single") {
			this.single.put(income, taxRate);
		} else {
			this.married.put(income, taxRate);
		}
	}
	
}