package com.xinlan.datastruct.sort;

public class MergeSort
{
    public static final int[] sortNumber = { 10, 16, 11, 3, 29, 8, 7, 14, 13,
            9, 23, 90, 2, 41, 5, 6, 91 };
    public static int a[] = { 1, 13, 24, 26, 100, 101, 105 };
    public static int b[] = { 2, 15, 27, 38, 49, 50 };

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // int c[]=merge(a, b);
        // show(c);
        show(sortNumber);
        // mergeSort(sortNumber);
        //shellSort(sortNumber);
        //insertSort(sortNumber);
        show(sortNumber);
    }
    
    

    /**
     * ¹é²¢ÅÅÐò
     * 
     * @param data
     */
    public static void mergeSort(int data[])
    {
        
    }
    
    

    public static void shellSort(int a[])
    {
        for (int gap = a.length / 2; gap >= 1; gap = gap / 2)
        {
            System.out.println("=========gap="+gap+"=======");
            for (int p = gap, len = a.length; p < len; p++)
            {
                int temp = a[p];
                int i = p-gap;
                for (; i >=0 && temp < a[i]; i -= gap)
                {
                    a[i+gap] = a[i];
                }// end for i
                a[i+gap] = temp;
            }// end for p
            //show(a);
        }// end for gap
    }
    /**
     * @param a
     */
    
    public static void insertSort(int a[]){
        for(int p=1,len=a.length;p<len;p++){
            int temp=a[p];
            int index=p-1;
            for(;index>0 && temp<a[index];index--){
                a[index]=a[index-1];
            }
            a[index]=temp;
        }//end for p
    }

    public static int[] merge(int a[], int b[])
    {
        int lenA = a.length;
        int lenB = b.length;
        int len = lenA + lenB;
        // System.out.println("---->"+len);
        int[] result = new int[len];
        int aIndex = 0, bIndex = 0, index = 0;
        while (aIndex < lenA && bIndex < lenB)
        {
            // System.out.println("---->"+index);
            if (a[aIndex] < b[bIndex])
            {
                result[index] = a[aIndex];
                aIndex++;
            }
            else
            {
                result[index] = b[bIndex];
                bIndex++;
            }
            index++;
        }// end while

        for (; aIndex < lenA; aIndex++, index++)
        {
            result[index] = a[aIndex];
        }// end for aIndex;

        for (; bIndex < lenB; bIndex++, index++)
        {
            result[index] = b[bIndex];
        }// end for bIndex

        return result;
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
