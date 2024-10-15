package com.sizllle;

public class MatrixScalarOperations {

    // Multiplying a matrix by a scalar
    public static Create multiplyByScalar(Create matrix, int scalar) {
        int rows = matrix.getRow();
        int cols = matrix.getCol();
        int[][] result = new int[rows][cols];
        int[][] matrixData = matrix.getMatrix();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixData[i][j] * scalar;
            }
        }

        Create resultMatrix = new Create(rows, cols);
        resultMatrix.setMatrix(result);
        return resultMatrix;
    }

    // Dividing a matrix by a scalar
    public static Create divideByScalar(Create matrix, int scalar) {
        if (scalar == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }

        int rows = matrix.getRow();
        int cols = matrix.getCol();
        int[][] result = new int[rows][cols];
        int[][] matrixData = matrix.getMatrix();

        // Divide the element of the matrix by the scalar, cast it to double for precision,
        // round the result to the nearest integer, and cast it back to int
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = (int) Math.round((double) matrixData[i][j] / scalar);
            }
        }

        Create resultMatrix = new Create(rows, cols);
        resultMatrix.setMatrix(result);
        return resultMatrix;
    }

}
