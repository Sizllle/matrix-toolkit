package com.sizllle;

import java.util.Random;

public class Create {
    Random random = new Random();
    private int row;
    private int col;
    private int minValue;
    private int maxValue;
    private int [][] matrix;

    // Default constructor
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

    // Constructor that initializes a matrix of the given size with random values
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

    // Constructor that initializes a matrix with specified dimensions
    // And a specified maximum value for the matrix elements
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

    // Constructor that initializes a matrix with specified dimensions and random values
    // Between a given minimum and maximum value
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

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public void setMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            this.matrix = new int[0][0];
            this.row = 0;
            this.col = 0;
            return;
        }

        this.matrix = matrix;
        this.row = matrix.length;
        this.col = matrix[0].length;
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
