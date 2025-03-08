package com.guoxinan.com.day4;

import java.util.Arrays;
import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {

        int[] arrayOne = new int[10];
        getArray(arrayOne);
        System.out.println("第一题:"+ Arrays.toString(arrayOne));

        int[] arrayTwo = new int[10];
        fillArrayByRandom0TO9(arrayTwo,10);
        System.out.println("第二题:"+ Arrays.toString(arrayTwo));

        int[] arrayThree = {10,20,30,40,50,60,70,80,90,100};
        int elem;
        System.out.print("第三题，取出的元素有:");
        for (int j : arrayThree) {
            elem = j;
            System.out.print(elem+" ");
        }
        System.out.println();

        int[] arrayFour = new int[10];
        fillArrayByRandom0TO9(arrayFour,10);
        int sumArrayFour = sumArray(arrayFour);
        double averageArrayFour = averageArray(arrayFour);
        System.out.println("第四题:产生的数组为:"+
                Arrays.toString(arrayFour)+
                "和为:"+sumArrayFour+
                "平均值为:"+averageArrayFour);

        int[] arrayFive = new int[10];
        fillArrayByRandom0TO9(arrayFive,10);
        int indexMinOfArrayFive = findMin(arrayFive);
        int indexMaxOfArrayFive = findMax(arrayFive);
        System.out.println("第五题:产生的数组为:"+
                Arrays.toString(arrayFive)+
                "最大值为:"+arrayFive[indexMaxOfArrayFive]+
                "最小值为:"+arrayFive[indexMinOfArrayFive]);

        int[] arraySix = {1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
        System.out.print("第六题:除零前"+Arrays.toString(arraySix));
        arraySix = deleteZero(arraySix);
        System.out.println("除零后"+Arrays.toString(arraySix));

        int[] arraySeven = {1,1,2,2,2,3,3,3,3};
        System.out.print("第七题:"+Arrays.toString(arraySeven));
        arraySeven = deleteRepeat(arraySeven);
        System.out.println("去重后:"+Arrays.toString(arraySeven));

        int[] arrayEight = new int[10];
        System.out.println("开始对选手打分，评分范围是1~10的整数");
        Scanner sc = new Scanner(System.in);
        int scoreCount = 0;
        //boolean isLegalInput = false;
        while(scoreCount<10)
        {
            System.out.printf("请输入第%d个分数:",scoreCount+1);
            int score = sc.nextInt();
            if (score >= 1 && score <= 10)
            {
                arrayEight[scoreCount] = score;
                scoreCount++;
            }else {
                System.out.println("请输入在正确范围的数!");
            }

        }
        System.out.println("选手最终得分是:"+markSing(arrayEight));

        String[] names = new String[20];
        names = makeRandomName(names.length);
        System.out.print("第九题,随机生成的姓名有：");
        System.out.println(Arrays.toString(names));

        int[] arrayTen = new int[10];
        fillArrayByRandom0TO9(arrayTen,10);
        System.out.print("第十题：反转前:"+Arrays.toString(arrayTen));
        flipArray(arrayTen);
        System.out.println("反转后:"+Arrays.toString(arrayTen));

        int[] arrayEleven = {9, 28, 37, 46, 50};
        System.out.println("第十一题：数组为：:"+Arrays.toString(arrayEleven));
        System.out.println("请输入您要查找的数:");
        int userInput = sc.nextInt();
        int result = searchArray(arrayEleven,userInput);
        if (result == -1)
        {
            System.out.println("抱歉，没有找到");
        }else {
            System.out.printf("您查找的%d的索引是%d\n",userInput,result);
        }


        int[] arrayTwelve = new int[10];
        fillArrayByEven(arrayTwelve);
        System.out.println("第十二题:");
        System.out.println("随机偶数数组是:"+Arrays.toString(arrayTwelve));
        sortArray(arrayTwelve);
        System.out.println("排序后:"+Arrays.toString(arrayTwelve));


        int[] crowd = new int[500];
        fillArrayByRandom0TO9(crowd,500);
        int index = findRat(crowd.length);
        System.out.printf("是叛徒的是第%d个人，%d\n",index+1,crowd[index]);

    }


    /**
     * 将1-10存入数组
     * @param array：要存入数据的数组
     */
    public static void getArray(int[] array){
        for(int i=0;i<array.length;i++)
        {
            array[i]=i+1;
        }
    }

    /**
     * @param array：被0~9随机数填充的数组
     * @param length：填充随机数的长度
     */
    public static void fillArrayByRandom0TO9(int[] array, int length){
        for (int i=0;i<length;i++)
        {
            array[i]=(int)(Math.random()*10);
        }
    }

    /**
     * 计算一个元素中所有元素之和
     * @param array：要计算的数组
     * @return 元素之和
     */
    public static int sumArray(int[] array){
        int sum=0;
        for (int element : array)
        {
            sum+=element;
        }
        return sum;
    }

    /**
     * 计算一个数组中的元素平均值
     * @param array ：要求平均数的数组
     * @return 元素的平均值
     */
    public static double averageArray(int[] array){
        return ((double)sumArray(array)/array.length);
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
     * 从数组中找到最大元素，返回它的索引
     * @param arr 要查询的数组
     * @return 最大值索引
     */
    public static int findMax(int[] arr){
        int index = 0;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    /**
     * 删除一个数组中的零元素，并将删除后的新数组返回
     * @param arr 要删除0的数组
     * @return 删除0后的新数组
     */
    public static int[] deleteZero(int[] arr) {
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

    /**
     * 删除数组中重复的元素，并将不重复的元素组成新数组返回
     * @param arr 要进行除重的数组
     * @return 新的数组
     */
    public static int[] deleteRepeat(int[] arr) {
       boolean repeated = false;
       int[] newArr = new int[arr.length];
       int index = 0;
       for (int i = 0; i < arr.length; i++)
       {
           repeated = false;
           for(int j=i+1; j<arr.length;j++)
           {
               if(arr[i]==arr[j])
               {
                   repeated=true;
                   break;
               }
           }
           if (!repeated)
           {
               newArr[index] = arr[i];
               index++;
           }
       }
       newArr = Arrays.copyOf(newArr, index);
       return newArr;
    }

    /**
     * 对一个选手进行打分：去掉最高分和最高分后求平均数
     * @param scoresList:存储选手评分的数组
     * @return 选手最终得分
     */
    public static double markSing(int[] scoresList){
        int[] newScores = new int[scoresList.length-2];
        int maxScore = scoresList[findMax(scoresList)];
        int minScore = scoresList[findMin(scoresList)];
        int index = 0;
        boolean maxFound = false;
        boolean minFound = false;

        for (int j : scoresList) {
            if(!maxFound && j==maxScore)
            {
                maxFound = true;
                continue;
            }
            if(!minFound && j==minScore)
            {
                minFound = true;
                continue;
            }
            newScores[index] = j;
            index++;
            if (index == newScores.length) {
                break;
            }
        }
        //System.out.println(Arrays.toString(newScores));
        return averageArray(newScores);
    }

    /**
     * 产生指定个数的不同的随机姓名
     * @return 产生的随机姓名数组
     * @param length : 需要产生多少个随机姓名
     */
    public static String[] makeRandomName(int length){
        String[] firstName = new String[]{"张","王","李","赵","欧阳","上官"};
        String[] lastName = new String[]{"飞","悟空","八戒","三疯"};
        String[] name = new String[length];
        String fullName;
        int firstIndex, lastIndex,nameCount;
        boolean repeated = false;
        nameCount=0;

        //虽然长度已知，但不能确定是否会发生重复姓名导致重新生成，所以使用while循环
        while (nameCount < length)
        {
            fullName = firstName[(int)(Math.random()*firstName.length)]+ lastName[(int)(Math.random()*lastName.length)];
            repeated = false;
            for(String str : name)
            {
                if (str != null && str.equals(fullName))
                {
                    repeated = true;
                    break;
                }
            }
            //只有不重复时才加入返回的结果
            if (!repeated)
            {
                name[nameCount] = fullName;
                nameCount++;
            }
        }

        return name;

    }

    /**
     * 将数组进行逆序
     * @param arr ：要进行反转操作的数组
     */
    public static void flipArray(int[] arr){
        int rear = arr.length-1;
        int front = 0;
        int temp;
        while (rear >= front)
        {
            temp = arr[front];
            arr[front] = arr[rear];
            arr[rear] = temp;
            front++;
            rear --;
        }
    }

    /**
     * 查找一个数是否在数组中
     * @param arr 要查找的数组
     * @param target 要查找的数
     * @return 若找到返回数的索引，否则返回-1
     */
    public static int searchArray(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;

        while (low <= high)
        {
            if (arr[low] == target )
            {
                return low;
            }
            if (arr[high] == target )
            {
                return high;
            }
            high--;
            low++;
        }
        return -1;
    }

    /**
     * 对数组进行升序排序
     * @param arr 要排序的数组
     *
     */
    public static void sortArray(int[] arr)
    {
        boolean swapped = false;
        int temp;
        for (int i = 0; i < arr.length; i++)
        {
            swapped = false;//表示是否发生交换
            for (int j = 0; j < arr.length-1; j++)
            {
                if (arr[j] > arr[j+1])
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

    /**
     * 用偶数填充数组
     * @param arr 要填充的数组
     */
    public static void fillArrayByEven(int[] arr){
        int randomNum;
        int index = 0;
        int maxRandom = 100;
        int minRandom = 1;
        while (index<arr.length)
        {
            randomNum = (int) (Math.random()*((maxRandom-minRandom+1))+minRandom);
            if (randomNum%2==0)
            {
                arr[index] = randomNum;
                index++;
            }
        }
    }

    /**
     * 寻找叛徒 ，按照给定的人数，所有人坐成一圈，每三个出一个人，到最后的人就是叛徒
     * @param length:要寻找的人数，
     * @return 找到的叛徒的值
     */
    public static int findRat(int length){
        boolean[] clearList = new boolean[length];
        int countRest = length;
        int indexPtr = 0;  //代表清白名单的下标移动
        int index = 0;      //返回的索引
        int count = 1;    //用来计数，每数到3个还没清白的重置为1

        while(countRest>1)
        {
          //System.out.println("indexPtr="+indexPtr+",count="+count);
          if(count==3 && !clearList[indexPtr])
          {
              count = 1;
              clearList[indexPtr] = true;
              countRest--;
             // System.out.printf("第%d人为清白\n",indexPtr+1);
          }
          if(!clearList[indexPtr] )
          {
              count++;
          }
          indexPtr++;


          if(indexPtr >= length)
          {
              indexPtr = 0;
          }

        }

        for(int i=0;i<clearList.length;i++)
        {
            if(!clearList[i])
            {
                index = i;
                break;
            }
        }
        return index;

    }

    public static void deleteReapeatedArray(int[] arr){
        int frontElem,nextElem;
        for(int i=0;i<arr.length;i++){
            frontElem = arr[i];
            nextElem = arr[i+1];

        }
    }


}
