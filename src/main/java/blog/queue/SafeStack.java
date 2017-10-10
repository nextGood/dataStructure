package blog.queue;

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
					// ���� //4
				}
			}
			System.out.print("����");
			top--;
			int[] test = { values[top], top };
			dataAvailable = false;
			// �������ڵȴ�ѹ�����ݵ��߳�
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
					// ���� //2
				}
			}
			values[top] = n;
			System.out.println("ѹ������" + n + "����1���");
			top++;
			dataAvailable = true;
			notifyAll();
			System.out.println("ѹ���������");
		}
	}
}