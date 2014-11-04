package com.xinlan.datastruct.sort;

public class QuickSortDemo
{
    public static final int[] sortNumber = { 10, 16, 11, 3, 29, 8, 7, 14, 13,
            9, 23, 90, 2, 41, 5, 6, 91 };

    // public static final int[] sortNumber = { 3,2,5,1};

    public static void main(String[] args)
    {
        // insertionSort(sortNumber);
        // show(sortNumber);
        show(sortNumber);
        insertSort(sortNumber);
        show(sortNumber);
    }

    /**
     * 
     * @param data
     */
    public static void insertionSort(int[] data)
    {
        for (int p = 1, len = data.length; p < len; p++)
        {
            // show(data);
            int temp = data[p];
            int i = p - 1;
            for (; i >= 0 && temp < data[i]; i--)
            {
                data[i + 1] = data[i];
            }// end for i
            data[i + 1] = temp;
        }// end for p
    }

    public static void insertSort(int[] data)
    {
        for (int i = 1; i < data.length; i++)
        {
            int temp = data[i];
            int j = i;
            for (; j >0 && temp < data[j-1]; j--)
            {
                data[j]=data[j-1];
            }// end for j
            data[j]=temp;
        }// end for i
    }

    public static void show(int data[])
    {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < data.length; i++)
        {
            sb.append(data[i]).append("  ");
        }// end for i
        System.out.println(sb.toString());
    }
}// end class
