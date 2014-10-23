package com.xinlan.datastruct.sort;

public class SortDemo
{
//    public static final int[] sortNumber = { 10, 16, 11, 3, 29, 8, 7, 14, 13, 9,
//            23, 90, 2, 41, 5, 6,91 };
    
    public static final int[] sortNumber = { 3,2,5,1};

    public static void main(String[] args)
    {
        insertionSort(sortNumber);
        show(sortNumber);
    }
    
    /**
     * ≤Â»Î≈≈–Ú
     * @param data
     */
    public static void insertionSort(int[] data){
        for(int i=1;i<data.length;i++){
            show(data);
            int temp=data[i];
            int j;
            for(j=0;j<i;j++){
                if(temp<data[j]){
                    break;
                }
            }//end for j
            System.out.println("insert point-->"+j);
            for(int index=i-1;index>=j;index--){
                data[index+1]=data[index];
            }//end for index
            data[j]=temp;
        }//end for i
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

}//end class
