package com.guoxinan.practice;

public class DoubleDimensional {
    public static void main(String[] args) {
        int[][] a = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                a[i][j] = (int) (Math.random() * 10);
            }
        }
        displayDoubleDimensional(a);


    }
    public static void displayDoubleDimensional(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

}
