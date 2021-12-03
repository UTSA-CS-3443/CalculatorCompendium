package application.model;

/**
 * matrixDataHandler would determine the new size of the array if size of result
 * array were to change.
 * 
 * @author Brandon Stevenson (dvi673) UTSA CS 3443 - Program Fall 2021
 */
public class matrixDataHandler {
	private int[][] matrixA, matrixB;
	/**
	 * Constructor for the class, initializes matrix of integers
	 */
	public matrixDataHandler() {
	}

	/**
	 * method for finding the rows of new matrix size.
	 *
	 * @param matrixA, a String[][]
	 */
	public void findRows(String[][] matrixA) {
	}

	/**
	 * method for finding the columns of new matrix size.
	 *
	 * @param matrixA, a String[][]
	 */
	public void findColumns(String[][] matrixA) {
	}

	/**
	 * Getter method for the matrix.
	 *
	 * @return matrixA, an int[][]
	 */
	public int[][] getMatrixA() {
		return matrixA;
	}

	/**
	 * Setter method for the matrixA.
	 *
	 * @param matrixA, an ArrayList<String>
	 */
	public void setMatrixA(int[][] matrixA) {
		this.matrixA = matrixA;
	}

	/**
	 * Getter method for the matrix.
	 *
	 * @return matrixB, an int[][]
	 */
	public int[][] getMatrixB() {
		return matrixB;
	}

	/**
	 * Setter method for the matrixB.
	 *
	 * @param matrixB, an ArrayList<String>
	 */
	public void setMatrixB(int[][] matrixB) {
		this.matrixB = matrixB;
	}
}
