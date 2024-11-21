package com.sizllle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MatrixScalarOperationsTest {

    private Create matrix;

    @BeforeEach
    void prepare() {
        System.out.println("Preparing test matrix");
        // Creating a Basic Matrix for Tests
        matrix = new Create(2, 2);
        matrix.setMatrix(new int[][]{
                {1, 2},
                {3, 4}
        });
    }

    @Test
    void testMultiplyByScalar() {
        System.out.println("Testing multiply by scalar");
        int[][] expected = {
                {2, 4},
                {6, 8}
        };

        Create result = MatrixScalarOperations.multiplyByScalar(matrix, 2);
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    void testDivideByScalar() {
        System.out.println("Testing divide by scalar");
        int[][] expected = {
                {1, 1},
                {2, 2}
        };

        Create result = MatrixScalarOperations.divideByScalar(matrix, 2);
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    void testDivideByScalarWithRounding() {
        System.out.println("Testing divide by scalar with rounding");
        matrix.setMatrix(new int[][]{
                {5, 15},
                {25, 35}
        });

        int[][] expected = {
                {1, 3},
                {4, 6}
        };

        Create result = MatrixScalarOperations.divideByScalar(matrix, 6);
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    void testDivideByZero() {
        System.out.println("Testing divide by zero");
        // Checking for an exception to be thrown when dividing by zero
        assertThrows(IllegalArgumentException.class, () -> {
            MatrixScalarOperations.divideByScalar(matrix, 0);
        });
    }

    @Test
    void testMultiplyByScalarWithZero() {
        System.out.println("Testing multiply by scalar with 0");
        int[][] expected = {
                {0, 0},
                {0, 0}
        };

        Create result = MatrixScalarOperations.multiplyByScalar(matrix, 0);
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    void testDivideByScalarWithOne() {
        System.out.println("Testing divide by scalar with 1");
        int[][] expected = matrix.getMatrix(); // Dividing by 1 doesn't change the matrix

        Create result = MatrixScalarOperations.divideByScalar(matrix, 1);
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    void testMultiplyByScalarNegative() {
        System.out.println("Testing multiply by scalar negative");
        int[][] expected = {
                {-1, -2},
                {-3, -4}
        };

        Create result = MatrixScalarOperations.multiplyByScalar(matrix, -1);
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    void testDivideByScalarNegative() {
        System.out.println("Testing divide by scalar negative");
        matrix.setMatrix(new int[][]{
                {-4, -8},
                {12, 16}
        });
        int[][] expected = {
                {2, 4},
                {-6, -8}
        };

        Create result = MatrixScalarOperations.divideByScalar(matrix, -2);
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    void testEmptyMatrix() {
        System.out.println("Testing empty matrix");
        Create emptyMatrix = new Create(0, 0); // Matrix with zero dimensions

        int[][] expected = {};
        Create multiplied = MatrixScalarOperations.multiplyByScalar(emptyMatrix, 5);
        Create divided = MatrixScalarOperations.divideByScalar(emptyMatrix, 5);

        assertArrayEquals(expected, multiplied.getMatrix());
        assertArrayEquals(expected, divided.getMatrix());
    }

    @AfterEach
    void cleanUp() {
        System.out.println("Cleaning up test matrix\n");
        matrix = null; // Releasing an object reference
    }
}
