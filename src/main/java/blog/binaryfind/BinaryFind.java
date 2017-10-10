package blog.binaryfind;

/**
 * 二分搜索法
 * 2013-09-04
 */
public class BinaryFind {

	/**
	 * 二分搜索算法实现
	 * @param data 数据集合
	 * @param target 搜索的数据
	 * @return 返回找到的数据的位置，返回-1表示没有找到。
	 */
	public static int binaryFind(long[] data, long target) {
		int start = 0;
		int end = data.length - 1;
		if (start >= end) {
			return -1;
		}
		while(start <= end){
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

	public static void main(String[] args) {
		int length = 5000000;
		long[] data = new long[length];
		for (int i = 0; i < length; i++) {
			data[i] = i + 3;
		}
		long target = -1111113;
		long start = System.currentTimeMillis();
		int flag = binaryFind(data,target);
		long end = System.currentTimeMillis();
		System.out.println(flag);
		System.out.println("花费：" + (end - start));
	}
}
