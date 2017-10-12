package blog.queue;

/**
 * Java : 数组实现“队列”，只能存储int数据。
 * 介绍：http://www.cnblogs.com/skywang12345/p/3562279.html
 *
 * @author skywang
 * @date 2013/11/07
 */
public class ArrayQueue {

    private int[] mArray;
    private int mCount;

    public ArrayQueue(int sz) {
        mArray = new int[sz];
        mCount = 0;
    }

    // 将val添加到队列的末尾
    public void add(int val) {
        mArray[mCount++] = val;
    }

    // 返回“队列开头元素”
    public int front() {
        return mArray[0];
    }

    // 返回“对列首部元素值”，并删除“对列首部元素”
    public int pop() {
        int ret = mArray[0];
        for (int i = 1; i <= mCount; i++) {
            mArray[i - 1] = mArray[i];
        }
        mCount--;
        return ret;
    }

    // 返回“对列”的大小
    public int size() {
        return mCount;
    }

    // 返回“对列”是否为空
    public boolean isEmpty() {
        return size() == 0;
    }

    public static void main(String[] args) {
        int tmp;
        ArrayQueue queue = new ArrayQueue(12);

        // 将10, 20, 30 依次推入对列中
        queue.add(10);
        queue.add(20);
        queue.add(30);

        // 将“对列首部元素”赋值给tmp，并删除“对列首部元素”
        tmp = queue.pop();
        System.out.printf("tmp=%d\n", tmp);

        // 只将“对列首部”赋值给tmp，不删除该元素.
        tmp = queue.front();
        System.out.printf("tmp=%d\n", tmp);

        queue.add(40);

        System.out.printf("isEmpty()=%b\n", queue.isEmpty());
        System.out.printf("size()=%d\n", queue.size());
        while (!queue.isEmpty()) {
            System.out.printf("size()=%d\n", queue.pop());
        }
    }
}