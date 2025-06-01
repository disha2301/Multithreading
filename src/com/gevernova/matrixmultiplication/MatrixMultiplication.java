package com.gevernova.matrixmultiplication;

public class MatrixMultiplication implements Runnable{
    private int[][]matA,matB,matResult;
    private int row;

    // constructor
    public MatrixMultiplication(int [][]matA, int [][]matB,int [][] matResult, int row){
        this.matA = matA;
        this.matB = matB;
        this.matResult = matResult;
        this.row = row;
    }

    // each thread will compute one row of the result matrix
    public void run(){
        int colsB = matB[0].length;
        int colsA = matA[0].length;
        for(int i = 0; i<colsB;i++){
            matResult[row][i] = 0;
            for(int j = 0; j < colsA; j++){
                matResult[row][j] += matA[row][j] * matB[row][j];
            }
        }
    }
}
