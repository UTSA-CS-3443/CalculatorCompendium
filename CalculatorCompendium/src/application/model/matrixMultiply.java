package application.model;

/**
 * matrixSubtract will multiply one matrix by another
 * 
 * @author Brandon Stevenson (dvi673) UTSA CS 3443 - Program Fall 2021
 */
public class matrixMultiply {
	private int[][] resultMatrix;

	/**
	 * Constructor for the class, initializes matrix of integers
	 */
	public matrixMultiply() {
		resultMatrix = new int[3][3];
	}

	/**
	 * method for multiplying one matrix by another.
	 *
	 * @param matrixA, matrixB, an int[][]
	 */
	public void multiplyMatrix(int[][] matrixA, int[][] matrixB) {
		for (int i = 0; i < matrixA.length; i++)
			for (int j = 0; j < matrixA.length; j++) {
				for (int k = 0; k < matrixA.length; k++) {
					resultMatrix[i][j] = matrixA[i][k] * matrixB[k][j];
				}
			}
	}

	/**
	 * method for how the result matrix will print
	 *
	 * @return result, a String
	 */
	public String toString() {
		String result = "";
		for (int[] matrix : resultMatrix) {
			result = result.concat("[ ");
			for (int j = 0; j < resultMatrix.length; j++) {
				result = result.concat(matrix[j] + " ");
			}
			result = result.concat("]\n");
		}
		return result;
	}

	/**
	 * Getter method for the result matrix.
	 *
	 * @return resultMatrix, an int[][]
	 */
	public int[][] getResultMatrix() {
		return resultMatrix;
	}

	/**
	 * Setter method for the result matrix.
	 *
	 * @param resultMatrix, an int[][]
	 */
	public void setResultMatrix(int[][] resultMatrix) {
		this.resultMatrix = resultMatrix;
	}
}
