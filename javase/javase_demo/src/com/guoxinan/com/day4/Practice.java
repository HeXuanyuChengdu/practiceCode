package com.guoxinan.com.day4;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
/*
        int[] a = new int[10];

        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        for(int elem : a)
        {
            System.out.print(elem+" ");
        }

        int[] copyA = Arrays.copyOf(a, a.length);
        for(int elem : copyA)
        {
            System.out.print("copy中元素由"+elem+" ");
        }

        System.out.println(Arrays.toString(a));
*/

        //practice2();
        //practice3();
        int codePoint =0x13000;
        String str = new String(Character.toChars(codePoint));
        System.out.println(str);
    }

    public static void practice2(){
        int[] oldArr = {1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
        System.out.println(Arrays.toString(oldArr));

       /*
        int index = 0;
        for(int elem : oldArr)
        {
            if(elem != 0)
            {
                newArr[index] = elem;
                index++;
            }
        }
*/

       oldArr = deleteZero(oldArr);
       System.out.println(Arrays.toString(oldArr));



    }
    public static int[] deleteZero(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i] != 0 )
            {
                arr[index] = arr[i];
                //System.out.println("oldArr[index]="+oldArr[index]+",oldArr[i]="+oldArr[i]+"index="+index+"i="+i);
                index++;
            }
        }

        return Arrays.copyOf(arr, index);
    }

    public static void practice3(){
        int[] arr = new int[20];

        for(int i=0;i<arr.length;i++)
        {
            arr[i] =(int) (Math.random() * 101);
        }

        System.out.println(Arrays.toString(arr));
        int indexMin = findMin(arr);

        System.out.printf("arr中最小值是下标为%d的%d\n",indexMin,arr[indexMin]);
        sortBubble(arr);
        System.out.println("arr排序后:"+Arrays.toString(arr));

    }

    /**
     * 找到一个数组中的最小值
     * @param arr 用来查找的数组
     * @return 最小值索引
     */
    public static int findMin(int[] arr){
        int index = 0;
        int min = arr[0];

        for (int i = 1; i < arr.length; i++)
        {
            if(arr[i] < min)
            {
                min = arr[i];
                index = i;
            }
        }

        return index;

    }

    /**
     * 冒泡排序实现
     * @param arr 排序的数组
     */
    public static void sortBubble(int[] arr){
        boolean swapped = false;
        int temp;
        for(int i=0;i<arr.length-1;i++)
        {
            swapped = false;//表示是否发生交换，如果一整个遍历都没有发生交换，提前结束循环
            for (int j=0;j<arr.length-1-i;j++)
            {
                if (arr[j]>arr[j+1])
                {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
            {
                break;
            }
        }
    }

}
