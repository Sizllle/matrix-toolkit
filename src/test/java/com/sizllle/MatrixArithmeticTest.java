package com.sizllle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixArithmeticTest {

    private Create matrix1;
    private Create matrix2;

    @BeforeEach
    void setUp() {
        System.out.println("Setting up test matrices");
        matrix1 = new Create(2, 2);
        matrix1.setMatrix(new int[][]{
                {1, 2},
                {3, 4}
        });

        matrix2 = new Create(2, 2);
        matrix2.setMatrix(new int[][]{
                {5, 6},
                {7, 8}
        });
    }

    @Test
    void testAddition() {
        System.out.println("Testing addition");
        int[][] expected = {
                {6, 8},
                {10, 12}
        };

        Create result = MatrixArithmetic.addition(matrix1, matrix2);
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    void testSubtraction() {
        System.out.println("Testing subtraction");
        int[][] expected = {
                {-4, -4},
                {-4, -4}
        };

        Create result = MatrixArithmetic.subtraction(matrix1, matrix2);
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    void testMultiplication() {
        System.out.println("Testing multiplication");
        matrix2.setMatrix(new int[][]{
                {1, 2},
                {3, 4}
        });
        int[][] expected = {
                {7, 10},
                {15, 22}
        };

        Create result = MatrixArithmetic.multiply(matrix1, matrix2);
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    void testAdditionWithDimensionMismatch() {
        System.out.println("Testing addition with dimension mismatch");
        Create matrix3 = new Create(3, 3);
        matrix3.setMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        assertThrows(IllegalArgumentException.class, () -> MatrixArithmetic.addition(matrix1, matrix3));
    }

    @Test
    void testMultiplicationWithDimensionMismatch() {
        System.out.println("Testing multiplication with dimension mismatch");
        Create matrix3 = new Create(3, 3);
        matrix3.setMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        assertThrows(IllegalArgumentException.class, () -> MatrixArithmetic.multiply(matrix1, matrix3));
    }

    @Test
    void testTransposeSquareMatrix() {
        System.out.println("Testing transpose square matrix");

        Create matrix = new Create(3, 3);
        matrix.setMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        int[][] expected = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };

        Create result = MatrixArithmetic.transpose(matrix);
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    void testTransposeRectagularMatrix() {
        System.out.println("Testing transpose rectagular matrix");

        Create matrix = new Create(2, 3);
        matrix.setMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        });

        int[][] expected = {
                {1, 4},
                {2, 5},
                {3, 6}
        };

        Create result = MatrixArithmetic.transpose(matrix);
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    void testTransposeSingleRowMatrix() {
        System.out.println("Testing transpose single row matrix");

        Create matrix = new Create(1, 3);
        matrix.setMatrix(new int[][]{
                {1, 2, 3}
        });

        int[][] expected = {
                {1},
                {2},
                {3}
        };

        Create result = MatrixArithmetic.transpose(matrix);
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    void testTransposeSingleColumnMatrix() {
        System.out.println("Testing transpose single column matrix");

        Create matrix = new Create(3, 1);
        matrix.setMatrix(new int[][]{
                {1},
                {2},
                {3}
        });

        int[][] expected = {
                {1, 2, 3}
        };

        Create result = MatrixArithmetic.transpose(matrix);
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    void testTransposeEmptyMatrix() {
        System.out.println("Testing transpse empty matrix");

        Create matrix = new Create(0, 0);

        int[][] expected = {};

        Create result = MatrixArithmetic.transpose(matrix);
        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    void testDeterminant1x1() {
        System.out.println("Testing determinant 1x1");

        Create matrix = new Create(1, 1);
        matrix.setMatrix(new int[][]{{5}});

        assertEquals(5, MatrixArithmetic.determinant(matrix));
    }

    @Test
    void testDeterminant2x2() {
        System.out.println("Testing determinant 2x2");

        Create matrix = new Create(2, 2);
        matrix.setMatrix(new int[][]{
                {3, 8},
                {4, 6}
        });

        assertEquals(-14, MatrixArithmetic.determinant(matrix));
    }

    @Test
    void testDeterminant3x3() {
        System.out.println("Testing determinant 3x3");

        Create matrix = new Create(3, 3);
        matrix.setMatrix(new int[][]{
                {6, 1, 1},
                {4, -2, 5},
                {2, 8, 7}
        });

        assertEquals(-306, MatrixArithmetic.determinant(matrix));
    }

    @Test
    void testDeterminantNonSquareMatrix() {
        System.out.println("Testing determinant non square matrix");

        Create matrix = new Create(2, 3);
        matrix.setMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        });

        assertThrows(IllegalArgumentException.class, () -> MatrixArithmetic.determinant(matrix));
    }

    @AfterEach
    void tearDown() {
        System.out.println("Cleaning up test matrices\n");
        matrix1 = null;
        matrix2 = null;
    }

}
