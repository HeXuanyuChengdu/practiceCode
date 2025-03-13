package com.guoxinan.practice;

import java.util.Arrays;

public class BinarySearchTest {
    public static final int ERROR = -1;
    public static void main(String[] args) {
        int[] array = new int[10];
        int number = 1;
        for (int i = 0; i < array.length; i++) {
            array[i] = number;
            number +=2;
        }
        extracted(array,1);
        extracted(array,2);


    }

    private static void extracted(int[] array,int target) {
        System.out.println("数组元素："+ Arrays.toString(array));

        System.out.println("查找目标:"+target);
        int result = binarySearch(array,target);
        if (result == ERROR) {
            System.out.println("抱歉，没有这个元素");
        }else {
            System.out.printf("查找的元素%d在数组的%d位置",target,result+1);
        }
    }

    /**
     * 二分查找的实现
     * @param arr 要查找的数组
     * @param target 要查找的元素
     * @return 若成共找到，返回元素对应的下标，否则返回-1表示失败
     */
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            }else if (arr[mid] > target) {
                high = mid - 1;
            }else if (arr[mid] < target) {
                low = mid + 1;
            }
        }
        return ERROR;
    }
}
