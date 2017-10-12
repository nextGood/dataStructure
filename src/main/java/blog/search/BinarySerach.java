package blog.search;

/**
 * 描述：二分搜索法
 * 介绍：http://www.cnblogs.com/luoxn28/p/5767571.html#commentform
 * 时间：2017/10/12 14:46
 * 码者: Administrator
 */
public class BinarySerach {
    /**
     * 二分搜索算法实现
     *
     * @param data   数据集合
     * @param target 搜索的数据
     * @return 返回找到的数据的位置，返回-1表示没有找到。
     */
    public static int binaryFind(int[] data, int target) {
        int start = 0;
        int end = data.length - 1;
        if (start >= end) {
            return -1;
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == data[mid]) {
                return mid;
            } else if (target > data[mid]) {
                start = mid + 1;
            } else if (target < data[mid]) {
                end = mid - 1;
            }
        }
        return -1;
    }

    // 查找第一个相等的元素
    static int findFirstEqual(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < array.length && array[left] == key) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {1, 3, 4, 4, 8, 9};
        System.out.println("结果：" + findFirstEqual(data, 4));
        long start = System.currentTimeMillis();
        int flag = binaryFind(data, 4);
        long end = System.currentTimeMillis();
        System.out.println("结果：" + flag + "，花费：" + (end - start));
    }
}