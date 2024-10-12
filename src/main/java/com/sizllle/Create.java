package com.sizllle;

import java.util.Random;

public class Create {
    Random random = new Random();
    int row;
    int col;
    int minValue;
    int maxValue;
    int [][] matrix;

    /**
     * Default constructor
     */
    public Create () {
        this.row = random.nextInt(10) + 1;
        this.col = random.nextInt(10) + 1;
        matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }
    }

    /**
     * Constructor that initializes a matrix of the given size with random values
     *
     * @param row the number of rows in the matrix
     * @param col the number of columns in the matrix
     */
    public Create(int row, int col) {
        this.row = row;
        this.col = col;
        matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }
    }

    /**
     * Constructor that initializes a matrix with specified dimensions and a specified maximum value for the matrix elements
     *
     * @param row the number of rows in the matrix
     * @param col the number of columns in the matrix
     * @param maxValue the maximum value (exclusive) for elements in the matrix
     */
    public Create(int row, int col, int maxValue) {
        this.row = row;
        this.col = col;
        this.maxValue = maxValue;
        matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = random.nextInt(maxValue);
            }
        }
    }

    /**
     * Constructor that initializes a matrix with specified dimensions and random values
     * between a given minimum and maximum value
     *
     * @param row the number of rows in the matrix
     * @param col the number of columns in the matrix
     * @param minValue the minimum value (inclusive) for elements in the matrix
     * @param maxValue the maximum value (exclusive) for elements in the matrix
     */
    public Create(int row, int col, int minValue, int maxValue) {
        this.row = row;
        this.col = col;
        this.minValue = minValue;
        this.maxValue = maxValue;
        matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = random.nextInt(maxValue - minValue) + minValue;
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }



}
