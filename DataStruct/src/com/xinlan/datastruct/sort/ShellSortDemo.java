package com.xinlan.datastruct.sort;

public class ShellSortDemo
{
    public static final int[] sortNumber = { 10, 16, 11, 34, 51, 3, 29, 8, 7,
            14, 13, 9, 23, 90, 2, 41, 5, 6, 91 };

    public static void main(String[] args)
    {
        show(sortNumber);
        shellSort(sortNumber);
        show(sortNumber);
    }

    /**
     * Ï£¶ûÅÅÐò
     * 
     * @param data
     */
    public static void shellSort(int[] data)
    {
        for (int gap = data.length / 2; gap >= 1; gap = gap / 2)
        {
            int len = data.length / gap;
            for (int p = 1; p < len; p++)
            {
                // a[gap*0] a[gap*1] a[gap*2]
                int temp = data[gap * p];
                int index = gap * p;
                for (; index > 0 && temp < data[index - gap]; index -= gap)
                {
                    data[index] = data[index - gap];
                }// end for index
                data[index] = temp;
            }// end for p
        }// end for gap;
    }

    public static void insertSort(int a[])
    {
        for (int p = 1; p < a.length; p++)
        {
            int i = p;
            int temp = a[p];
            for (; i > 0 && temp < a[i - 1]; i--)
            {
                a[i] = a[i - 1];
            }// end for i
            a[i] = temp;
        }// end for p
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
