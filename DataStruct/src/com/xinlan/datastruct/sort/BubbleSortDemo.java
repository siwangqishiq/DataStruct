package com.xinlan.datastruct.sort;

public class BubbleSortDemo
{
    public static final int[] sortNumber = { 10, 16, 11, 3, 29, 8, 7, 14, 13,
            9, 23, 90, 2, 41, 5, 6, 91, 1, 4 };

    public static final int[] sortNumber2 = { 3, 2, 5, 1 };

    public static void main(String[] args)
    {
        show(sortNumber);
        bubbleSort(sortNumber);
    }

    /**
     * bubble sort
     * √∞≈›≈≈–Ú
     * 
     * @param data
     */
    public static void bubbleSort(int[] data)
    {
        for (int i = 0; i < data.length; i++)
        {
            show(data);
            for (int j = data.length - 1; j > i; j--)
            {
                if (data[j] < data[j - 1])
                {
                    int temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                }
            }// end for j
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
