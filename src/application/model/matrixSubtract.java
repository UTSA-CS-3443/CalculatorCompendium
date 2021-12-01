package application.model;

public class matrixSubtract {
    //Variables
    private int[][] resultMatrix;
    //Constructor
    public matrixSubtract(){
        resultMatrix = new int[3][3];
    }
    public void subtractMatrix(int[][] matrixA, int[][] matrixB){
        for(int i = 0; i < matrixA.length; i++)
            for(int j = 0; j < matrixB.length; j++){
                resultMatrix[i][j] = matrixA[i][j] - matrixB[i][j];
            }
    }
    public String toString(){
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
    public int[][] getResultMatrix() {
        return resultMatrix;
    }

    public void setResultMatrix(int[][] resultMatrix) {
        this.resultMatrix = resultMatrix;
    }
}
