package com.dumm;

/**
 * 划分、递归、快排
 * @author bjh
 *
 */
class QuickSort {

    /**待排序、划分数组*/
    private int[] array;
    /**数组长度*/
    private int length;

    public QuickSort(int[] array){
        this.array = array;
        this.length = array.length;
    }

    /**
     * 打印元素
     */
    public void printArray(){
        for(int i=0; i<length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }


    /**
     * 划分
     * @return 划分的分界点
     */
    public void partition(int left, int right){

        int start = left;
        int end = right;
        int key = array[left];
        while(start<end){
            //找到右边小于pivot的数据，或者走到了最左边仍然没有找到比pivot小的数据
            while(start<end && array[end]>=key)end--;
            if(array[end]< key){
                //交换左边大的和右边小的数据
                swap(start,end);
            }
            //找到左边大于pivot的数据，或者走到了最右边仍然没有找到比pivot大的数据
            while(start<end && array[start]<=key)start++;
            if(array[start]> key){
                //交换左边大的和右边小的数据
                swap(start,end);
            }
        }
        //返回分界点，即右边子数组中最左边的点
        System.out.println("划分的分界点为：" + array[start] + "，分界点的坐标为：" + start);
        printArray();
        if(start > left){
            partition(left,start-1);
        }
        if(end < right){
            partition(end+1,right);
        }

    }


    /**
     * 交换数据
     */
    public void swap(int leftpoint,int rightpoint){
        int temp = array[leftpoint];
        array[leftpoint] = array[rightpoint];
        array[rightpoint] = temp;
    }

    public static void main(String args[]){
        int[] array = {99,78,26,17,82,36,9,81,22,100,30,20,17,85};
        QuickSort qs = new QuickSort(array);
        System.out.println("划分前的数据为：");
        qs.printArray();
        qs.partition(0, array.length-1);
        System.out.println("划分后的数据为：");
        qs.printArray();

    }

}