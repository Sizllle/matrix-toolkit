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

    // Calculate the determinant of a square matrix
    public static int determinant(Create matrix) {
        if (matrix.getRow() != matrix.getCol()) {
            throw new IllegalArgumentException("Determinant can only be calculated for square matrices.");
        }

        int n = matrix.getRow();
        int[][] mat = matrix.getMatrix();

        // Base case for 1x1 matrix
        if (n == 1) {
            return mat[0][0];
        }

        // Base case for 2x2 matrix
        if (n == 2) {
            return mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
        }

        // Recursive case for larger matrices
        int det = 0;
        for (int col = 0; col < n; col++) {
            det += ((col % 2 == 0) ? 1 : -1) * mat[0][col] * determinant(getSubMatrix(matrix, 0, col));
        }
        return det;
    }

    // Helper method to get the submatrix by excluding a specific row and column
    private static Create getSubMatrix(Create matrix, int excludeRow, int excludeCol) {
        int n = matrix.getRow();
        int[][] original = matrix.getMatrix();
        int[][] subMatrix = new int[n - 1][n - 1];

        int subRow = 0;
        for (int i = 0; i < n; i++) {
            if (i == excludeRow) continue;

            int subCol = 0;
            for (int j = 0; j < n; j++) {
                if (j == excludeCol) continue;

                subMatrix[subRow][subCol] = original[i][j];
                subCol++;
            }
            subRow++;
        }

        Create result = new Create(n - 1, n - 1);
        result.setMatrix(subMatrix);
        return result;
    }
}
