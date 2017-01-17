class CLL<T> {
	private static class Node<T> {
		T data;
		Node<T> next;
		public Node(T d, Node<T> n) {
			data = d;
			next = n;
		}
	}
	private Node<T> head = null;
	public boolean isEmpty() {
		return head == null;
	}
	public void add(T data) {
		if (isEmpty()) {
			head = new Node<T>(data, null);
			head.next = head;
			return;
		}
		Node<T> scout = head;
		while (scout.next != head){
			scout = scout.next;
		}
		Node<T> toAdd = new Node<T>(data, head);
		scout.next = toAdd;
	}
	public int findIndexOf(T data) {
		if (isEmpty()) return -1;
		Node<T> scout = head;
		int index = 0;
		while (scout.data != data) {
			scout = scout.next;
			index++;
			if (scout == head) return -1;
		}
		return index;
	}
	public String toString() {
		if (isEmpty()) throw new Error("ain't no list yo");
		StringBuffer s = new StringBuffer();
		Node<T> iter = head;
		do {
			s.append(iter.data + ", ");
			iter = iter.next;
		} while (iter != head);
		return s.toString();
	}
}

class Q<T> {
	private Object[] arr;
	private int front, back, curr, cap;
	public Q(int size) {
		front = 0;
		back = 0;
		curr = 0;
		cap = size;
		arr = new Object[size];
	}
	public void enq(T data) {
		if (curr == cap) throw new Error("at capacity");
		back = (front + curr) % cap;
		arr[back] = (T) data;
		curr++;
	}
	public T deq() {
		if (curr == 0) throw new Error("ain\'t nothing there");
		@SuppressWarnings("unchecked")
		T data = (T) arr[front];
		arr[front] = null;
		front = (front + 1) % cap;
		curr--;
		return data;
	}
	public String toString() {
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < curr; i++) {
			int next = (front + i) % cap;
			s.append(arr[next] + ", ");
		}
		return s.toString();
	}
}

public class Jan1617<T> {
	public static void testCLL() {
		CLL<String> list = new CLL<String>();
		list.add("eh");
		list.add("real");
		list.add("dolphins");
		System.out.println(list.toString());
	}
	public static void testQ() {
		Q<Integer> q = new Q<Integer>(4);
		q.enq(1);
		System.out.println(q.toString());
		q.enq(2);
		System.out.println(q.toString());
		q.enq(3);
		System.out.println(q.toString());
		q.enq(4);
		System.out.println(q.toString());
		q.deq();
		System.out.println(q.toString());
		q.deq();
		System.out.println(q.toString());
		q.enq(9);
		System.out.println(q.toString());
	}
	public static void main(String[] args) {
		//testCLL();
		testQ();
	}
}
/*
LESSONS:
* make sure there"s a list when calling toString()
* double quotes, not singles!
* adding first cyclic, you have to have head point to something before instantiating first node (so that you can pass that pointer to the node)
* make sure methods return something when they say they will
* a static method can only call other static methods... makes sense.
* increment and decrement curr when calling enq and deq!!
*/
