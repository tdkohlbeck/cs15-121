@SuppressWarnings("unchecked") // weak typing for generic arrays
class MyQueue<T> implements Queue<T> {
	private T[] array;
	private int front, back, cur, cap;

	public MyQueue(int size) {
		array = (T[]) new Object[size];
		front = 0;
		cur = 0;
		cap = size;
	}

	private boolean isEmpty() {
		return cur == 0;
	}

	private boolean isFull() {
		return cur == cap;
	}

	public void enqueue(T data) {
		if (isFull()) throw new RuntimeException("queue is full");
		if (isEmpty()) {
			back = front;
			array[back] = data;
			cur++;
			return;
		}
		back = front + cur;
		if (back >= cap) back = back % cap;
		array[back] = data;
		cur++;
	}

	public T dequeue() {
		if (isEmpty()) throw new RuntimeException("queue is empty");
		T data = array[front];
		array[front] = null;
		front++;
		if (front >= cap) front = 0;
		cur--;
		return data;
	}

	public String toString() {
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < cap; i++) {
			s.append(array[i] + ", ");
		}
		return s.toString();
	}

	public static void main(String[] args) {
		MyQueue<String> q = new MyQueue<String>(4);
		q.enqueue("yey");
		q.enqueue("bravo");
		q.enqueue("eh?");
		q.dequeue();
		q.dequeue();
		q.enqueue("one");
		q.enqueue("two");
		System.out.println(q.toString());
	}
}

interface Queue<T> {
	public void enqueue(T data);
	public T dequeue();
}
