package com.gevernova.matrixmultiplication;

public class Main {
    public static void main(String[] args) {
        // Example matrices A (2x3) and B (3x2)
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] B = {
                {7, 8},
                {9, 10},
                {11, 12}
        };

        // Result matrix (2x2)
        int[][] result = new int[A.length][B[0].length];

        // Create and start threads - one for each row
        Thread[] threads = new Thread[A.length];
        for (int i = 0; i < A.length; i++) {
            threads[i] = new Thread(new MatrixMultiplication(A, B, result, i));
            threads[i].start();
        }

        // Wait for all threads to complete
        for (int i = 0; i < A.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Print the result matrix
        System.out.println("Result Matrix:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
