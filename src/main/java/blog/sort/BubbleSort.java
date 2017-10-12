package blog.sort;

/**
 * 描述：冒泡排序
 * 介绍：http://www.cnblogs.com/skywang12345/p/3596232.html
 * 时间：2017/09/29 14:46
 * 码者: Administrator
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] num = {9, 4, 7, 5, 6};
        //bubbling(num);
        //bubbleSortBefore(num);
        bubbleSortAfter(num);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]);
            if (i != num.length - 1) {
                System.out.print(",");
            }
        }
    }

    // 将num[0...i]中最大的数据放在末尾
    public static void bubbling(int[] array) {
        int temp, length = array.length, count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    count++;
                }
            }
        }
        System.out.println("bubbling：" + count);
    }

    // 将num[0...i]中最大的数据放在末尾
    public static void bubbleSortAfter(int[] num) {
        int temp, length = num.length, count = 0;
        for (int i = length - 1; i > 0; i--) {
            int flag = 0;// 初始化标记为0
            for (int j = 0; j < i; j++) {
                if (num[j] > num[j + 1]) {
                    temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                    flag = 1;// 若发生交换，则加1
                    count++;
                }
            }
            if (0 == flag) {
                break;// 若没发生交换，则说明数列已有序。
            }
        }
        System.out.println("bubbleSortAfter：" + count);
    }

    // 将num[0...i]中最大的数据放在前面
    public static void bubbleSortBefore(int[] num) {
        int temp, length = num.length;
        for (int i = length - 1; i > 0; i--) {
            int count = 0;// 初始化标记为0
            for (int j = 0; j < i; j++) {
                if (num[j] < num[j + 1]) {
                    temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                    count++;// 若发生交换，则加1
                }
            }
            if (0 == count) {
                break;// 若没发生交换，则说明数列已有序。
            }
        }
    }
}