/**
 * @author Estela V. Rodriguez-Greenfield (wgi663)
 *
 */
package application.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Fact {

	private ArrayList<String> facts;

	public Fact() {
		this.facts = new ArrayList<String>();
	}

	/**
	 * @return the facts
	 */
	public ArrayList<String> getFacts() {
		return facts;
	}

	/**
	 * @param facts the facts to set
	 */
	public void setFacts(ArrayList<String> facts) {
		this.facts = facts;
	}

	public void addFact(String fact) {
		this.facts.add(fact);
	}
	
	public String randomFact() {
		String fact = null;
		if (this.facts.isEmpty()) {
			fact = "There are no facts to display!";
		} else {
			Random rand = new Random();
			int max = this.facts.size();
			int num = rand.nextInt(max);
			fact = this.facts.get(num);
		}
		
		return fact;
	}

	public void loadFacts(String fileName) {
		try {
			File file = new File(fileName);
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String fact = scan.nextLine();
				this.addFact(fact);
			}
			scan.close();
		} catch (

		IOException e) {
			System.out.println("Error loading the file - please check its location.");
			e.printStackTrace();
		}
	}
}
