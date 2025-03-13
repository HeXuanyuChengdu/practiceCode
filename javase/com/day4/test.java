package com.guoxinan.day4;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        final int MAX = 20;
        int[] arr = new int[MAX];
        for (int i = 0; i < 5; i++) {
            arr[i] = i+1;
        }
        //arr  = deleteZero(arr);
        System.out.println(Arrays.toString(arr));
        insertArray(arr,3,10);
        System.out.println(Arrays.toString(arr));

    }
    public static void insertArray(int[] arr,int point,int number){
        int indexSrc = point-1;
        for(int i =arr.length-1-1;i>=indexSrc;i--){
           arr[i+1] = arr[i];
        }
        arr[indexSrc] = number;
    }
    public static int[] deleteZero(int[] arr){
        int index = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i] != 0 )
            {
                arr[index] = arr[i];
                index++;
            }
        }
        return Arrays.copyOf(arr, index);
    }
}
