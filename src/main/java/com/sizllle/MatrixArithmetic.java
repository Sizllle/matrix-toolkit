package com.sizllle;


import java.util.function.BiFunction;

public class MatrixArithmetic {

    // General method for matrix operations (addition/subtraction)
    private static Create applyOperationAddSub(Create matrix1, Create matrix2, BiFunction<Integer, Integer, Integer> operation) {
        // Checking the dimension of matrices
        if (matrix1.getRow() != matrix2.getRow() || matrix1.getCol() != matrix2.getCol()) {
            throw new IllegalArgumentException("The dimensions of the matrices are not equal");
        }

        int rows = matrix1.getRow();
        int cols = matrix1.getCol();
        int[][] result = new int[rows][cols];
        int[][] matrix1Data = matrix1.getMatrix();
        int[][] matrix2Data = matrix2.getMatrix();

        // Applying an operation to each element of matrices
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = operation.apply(matrix1Data[i][j], matrix2Data[i][j]);
            }
        }

        Create resultMatrix = new Create(rows, cols);
        resultMatrix.setMatrix(result);
        return resultMatrix;
    }

    // Multiplying two matrices
    public static Create multiply(Create matrix1, Create matrix2) {
        // Checking the dimension of matrices
        if (matrix1.getCol() != matrix2.getRow()) {
            throw new IllegalArgumentException("The number of columns in the first matrix is not equal to the number of rows in the second matrix");
        }

        int rows = matrix1.getRow();
        int cols = matrix2.getCol();
        int commonDimension = matrix1.getCol();
        int[][] result = new int[rows][cols];
        int[][] matrix1Data = matrix1.getMatrix();
        int[][] matrix2Data = matrix2.getMatrix();

        // Matrix multiplication
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < commonDimension; k++) {
                    result[i][j] += matrix1Data[i][k] * matrix2Data[k][j];
                }
            }
        }

        Create resultMatrix = new Create(rows, cols);
        resultMatrix.setMatrix(result);
        return resultMatrix;
    }

    // Addition of matrices
    public static Create addition(Create matrix1, Create matrix2) {
        return applyOperationAddSub(matrix1, matrix2, (a, b) -> a + b);
    }

    // Subtraction of matrices
    public static Create subtraction(Create matrix1, Create matrix2) {
        return applyOperationAddSub(matrix1, matrix2, (a, b) -> a - b);
    }

    // Matrix transpose
    public static Create transpose(Create matrix) {
        int rows = matrix.getRow();
        int cols = matrix.getCol();
        int[][] original = matrix.getMatrix();
        int[][] transposed = new int[cols][rows];

        // Swap rows and columns
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = original[i][j];
            }
        }

        Create result = new Create(cols, rows);
        result.setMatrix(transposed);
        return result;
    }
}
