package queue;

public class SafeStack implements StackInterface {
	private int top = 0;

	private int[] values = new int[10];

	private boolean dataAvailable = false;

	public int[] pop() {
		synchronized (this) {
			while (!dataAvailable){ // 3
				try {
					wait();
				} catch (InterruptedException e) {
					// 忽略 //4
				}
			}
			System.out.print("弹出");
			top--;
			int[] test = { values[top], top };
			dataAvailable = false;
			// 唤醒正在等待压入数据的线程
			notifyAll();
			return test;
		}
	}

	public void push(int n) {
		synchronized (this) {
			while (dataAvailable) { // 1
				try {
					wait();
				} catch (InterruptedException e) {
					// 忽略 //2
				}
			}
			values[top] = n;
			System.out.println("压入数字" + n + "步骤1完成");
			top++;
			dataAvailable = true;
			notifyAll();
			System.out.println("压入数字完成");
		}
	}
}