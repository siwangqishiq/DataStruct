package com.xinlan.datastruct.search;

public class FindMinMax
{
    public static final int[] sortNumber = { 10, 16, 11, 3, 29, 8, 7, 14, 13,
            9, 23, 90, 2, 41, 5, 6, 91, 1, 4, 17, 100, 102,0 };

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        RetData data = findMinAndMax(sortNumber);
        System.out.println("min--->" + data.min);
        System.out.println("max--->" + data.max);

        sort(sortNumber);
        show(sortNumber);
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

    public static void sort(int a[])
    {
        for (int p = 1, len = a.length; p < len; p++)
        {
            int temp = a[p];
            int index = p - 1;
            for (; index >= 0 && temp < a[index]; index--)
            {
                a[index + 1] = a[index];
            }// end for index
            a[index + 1] = temp;
        }// end for p
    }

    public static RetData findMinAndMax(int a[])
    {
        RetData data = new RetData();
        int len = a.length;
        if (len <= 1)
        {
            data.min = data.max = a[0];
            return data;
        }

        int start = 0;
        if (len % 2 == 0)
        {// Å¼Êý
            start = 2;
            if (a[0] < a[1])
            {
                data.min = a[0];
            }
            else
            {
                data.max = a[1];
            }
        }
        else
        {// ÆæÊý
            data.min = data.max = a[0];
            start = 1;
        }

        for (int i = start; i < len; i += 2)
        {
            if (a[i] < a[i + 1])
            {
                if (data.min > a[i])
                {
                    data.min = a[i];
                }
                if (data.max < a[i + 1])
                {
                    data.max = a[i + 1];
                }
            }
            else
            {// a[i]>=a[i+1]
                if (data.min > a[i + 1])
                {
                    data.min = a[i + 1];
                }

                if (data.max < a[i])
                {
                    data.max = a[i];
                }
            }
        }// end for i
        return data;
    }

    private static final class RetData
    {
        int min;
        int max;
    }

}
