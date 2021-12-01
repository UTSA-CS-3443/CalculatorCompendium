/**
 * Fact represents a list of facts that are loaded from a file.
 * 
 * @author Estela V. Rodriguez-Greenfield (wgi663) 
 */
package application.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Fact {

	private ArrayList<String> facts;

	/**
	 * Constructor for the class, initializes the ArrayList of Strings.
	 */
	public Fact() {
		this.facts = new ArrayList<String>();
	}

	/**
	 * Getter method for the ArrayList of Strings.
	 * 
	 * @return facts, an ArrayList<String>
	 */
	public ArrayList<String> getFacts() {
		return facts;
	}

	/**
	 * Setter method for the facts.
	 * 
	 * @param facts, an ArrayList<String>
	 */
	public void setFacts(ArrayList<String> facts) {
		this.facts = facts;
	}

	/**
	 * Method to add a fact to the list of facts.
	 * 
	 * @param fact, a String
	 */
	public void addFact(String fact) {
		this.facts.add(fact);
	}
	
	/**
	 * Method to pick a random fact from the list of facts and return it.
	 * 
	 * @return fact, a String
	 */
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

	/**
	 * Method to load the facts from a file.
	 * 
	 * @param fileName, a String
	 */
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
