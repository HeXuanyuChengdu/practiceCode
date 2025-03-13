package main.java.homework.homework_03_10;

import java.util.Arrays;

public class Homework_03_10 {
    public static void main(String[] args) {
        final int MAX = 20;
        int[] arr = new int[MAX];
        for (int i = 0; i < 10; i++) {
            arr[i] = i+1;
        }

        System.out.println("操作开始前，数组为:"+ Arrays.toString(arr));
        deleteElementinArray(arr,9);
        System.out.println("删除第九个位置的元素后，数组为:"+ Arrays.toString(arr));

        insertElementinArray(arr,2,500);
        System.out.println("在第二2个位置插入500:"+Arrays.toString(arr));
        System.out.println();

        int[] arr2 = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            arr2[i] = (int)(Math.random() *MAX); //用随机数填充数组
        }
        System.out.println("排序前，数组为：:"+ Arrays.toString(arr2));
        sortChoice(arr2);
        System.out.println("选择排序后，数组为：:"+ Arrays.toString(arr2));
        System.out.println();

        int[] arr3 = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            arr3[i] = (int)(Math.random() *MAX);
        }
        System.out.println("排序前,数组为:"+ Arrays.toString(arr3));
        sortBubble(arr3);
        System.out.println("冒泡排序后，数组为：:"+ Arrays.toString(arr3));

    }

    /**
     * 删除数组中的元素
     * @param arr 要删除元素的数组
     * @param position 要删除的元素的位置(从1开始计数)
     */
    public static void deleteElementinArray(int[] arr,int position) {
        int targetIndex = position - 1;  //将位置转换成对应下标，方便操作
        for(int i = targetIndex; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
    }

    /**
     * 在数组中的position位置插入一个元素
     * @param arr 要插入的数组
     * @param position 要插入的位置，（从1开始）
     * @param value 要插入的值
     */
    public static void insertElementinArray(int[] arr,int position,int value) {
        int targetIndex = position - 1;
        for(int i = arr.length-1; i > targetIndex; i--) {
            arr[i] = arr[i-1];
        }
        arr[targetIndex] = value;
    }

    /**
     * 用选择排序对数组按照从小到大排序
     * @param arr 要排序的数组
     */
    public static void sortChoice(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 利用冒泡算法对数组进行升序排序
     * @param arr
     */
    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
