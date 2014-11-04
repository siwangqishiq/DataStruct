package com.xinlan.datastruct.sort;

public class ShellSort
{
    public static final int[] sortNumber = { 10, 16, 11, 3, 29, 8, 7, 14, 13,
            9, 23, 90, 2, 41, 5, 6, 91 };

    public static void show(int data[])
    {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < data.length; i++)
        {
            sb.append(data[i]).append("  ");
        }// end for i
        System.out.println(sb.toString());
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        show(sortNumber);
        shellSort(sortNumber);
        show(sortNumber);
    }

    public static void shellSort(int data[])
    {
        for (int gap = data.length / 2; gap >= 1; gap = gap / 2)
        {
            // System.out.println(gap);
            for (int p = gap; p < data.length; p++)
            {
                int i = p;
                int temp = data[p];
                for (; i >= gap && temp < data[i - gap]; i -= gap)
                {
                    data[i]=data[i-gap];
                }// end for i
                data[i]=temp;
            }// end for i
            
        }// end for gap
    }
}// end class
