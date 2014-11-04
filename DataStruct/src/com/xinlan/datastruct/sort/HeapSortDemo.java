package com.xinlan.datastruct.sort;

public class HeapSortDemo
{
    public static final int[] sortNumber = { 10, 16, 11, 3, 29, 8, 7, 14, 13,
            9, 23, 90, 2, 41, 5, 6, 91 };

    public static final int[] sortNumber2 = { 10, 16, 11, 3, 29, 8, 7, 14, 13,
            9, 23, 90, 2, 41, 5, 6, 91 };

    public static void main(String[] args)
    {
        show(sortNumber);
        heapSort(sortNumber);
        show(sortNumber);

        show(sortNumber2);
        insertSort(sortNumber2);
        show(sortNumber2);
    }

    public static void insertSort(int a[])
    {
        for (int p = 1, len = a.length; p < len; p++)
        {
            int index;
            int temp = a[p];
            for (index = p; index > 0 && temp < a[index-1]; index--)
            {
                a[index] = a[index - 1];
            }
            a[index] = temp;
        }// end for p
    }

    public static void heapSort(int data[])
    {
        // show(heapData);
        // int a[]={4,3,1,2};
        Heap heap = new Heap(data);
        heap.sort(data);
    }

    private static final class Heap
    {
        int data[];
        int count;

        public Heap(int[] a)
        {
            data = new int[a.length + 1];
            for (int i = 1; i < data.length; i++)
            {
                data[i] = a[i - 1];
            }// end for i
            count = a.length;
            buildHeap();
            // show(data);
        }

        private void buildHeap()
        {
            for (int node = count / 2; node > 0; node--)
            {
                bubbleDown(node);
            }// end for n
        }

        public void sort(int a[])
        {
            int index = 0;
            while (count > 0)
            {
                int number = deleteMin();
                a[index] = number;
                index++;
            }// end while
        }

        /**
         * 节点curPos做下滤操作
         * 
         * @param curPos
         */
        private void bubbleDown(int curPos)
        {
            // 当前node节点做下滤操作
            while (curPos <= count)
            {
                int leftPos = curPos * 2;
                int rightPos = leftPos + 1;
                if (leftPos > count)
                {
                    return;
                }
                if (rightPos > count)
                {
                    if (data[curPos] > data[leftPos])
                    {
                        int temp = data[curPos];
                        data[curPos] = data[leftPos];
                        data[leftPos] = temp;
                        curPos = leftPos;
                    }
                }
                else
                {
                    int leftValue = data[leftPos];
                    int rightValue = data[rightPos];
                    int nextPos;
                    if (leftValue < rightValue)
                    {
                        nextPos = leftPos;
                    }
                    else
                    {
                        nextPos = rightPos;
                    }

                    if (data[curPos] > data[nextPos])
                    {
                        int temp = data[curPos];
                        data[curPos] = data[nextPos];
                        data[nextPos] = temp;
                        curPos = nextPos;
                    }
                    else
                    {
                        break;
                    }
                }
            }// end while
        }

        public void inert(int data)
        {

        }

        public int deleteMin()
        {
            if (count <= 0)
            {
                return Integer.MIN_VALUE;
            }
            int ret = data[1];
            // 下滤操作
            data[1] = data[count];
            data[count] = 0;
            count--;
            bubbleDown(1);
            // show(data);
            return ret;
        }
    }// end inner class

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
