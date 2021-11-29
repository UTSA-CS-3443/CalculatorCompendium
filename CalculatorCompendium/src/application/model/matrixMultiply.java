package application.model;

public class matrixMultiply {
    //Variables
    private int[][] resultMatrix;
    //Constructor
    public matrixMultiply(){
        resultMatrix = new int[3][3];
    }
    public void multiplyMatrix(int[][] matrixA, int[][] matrixB){
        for(int i = 0; i < matrixA.length; i++)
            for(int j = 0; j < matrixA.length; j++){
                for(int k = 0; k < matrixA.length; k++){
                    resultMatrix[i][j] = matrixA[i][k] * matrixB[k][j];
                }
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
