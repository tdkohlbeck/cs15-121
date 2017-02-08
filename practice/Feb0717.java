import java.util.*;

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
			addFirst(data);
			return;
		}
		if (head.next == head) {
			head.next = new Node<T>(data, head);
			return;
		}
		Node<T> scout = head;
		while (scout.next != head) scout = scout.next;
		scout.next = new Node<T>(data, head);
		return;
	}

	public void addFirst(T data) {
		if (isEmpty()) {
			head = new Node<T>(data, null);
			head.next = head;
			return;
		}
		head = new Node<T>(data, head);
		Node<T> prevHead = head.next;
		Node<T> scout = prevHead;
		while (scout.next != prevHead) scout = scout.next;
		scout.next = head;
	}

	public T removeFirst() {
		if (isEmpty()) throw new Error("nothing to remove");
		T data = head.data; // (2)
		if (head.next == head) {
			head = null;
			return data;
		}
		Node<T> scout = head;
		while (scout.next != head) scout = scout.next;
		scout.next = head.next;
		head = head.next;
		return data;
	}

	public CLL<T> copy() {
		CLL<T> copy = new CLL<T>();
		if (isEmpty()) return copy;
		Node<T> scout = head;
		do {
			copy.add(scout.data);
			scout = scout.next;
		} while (scout != head);
		return copy;
	}

	public String toString() {
		if (isEmpty()) return ""; // (3)
		StringBuilder sb = new StringBuilder();
		Node<T> scout = head;
		do {
			sb.append(scout.data + ", ");
			scout = scout.next;
		} while (scout != head); // (1)
		return sb.toString();
	}
}

class Stack<T> {
	private LinkedList<T> list = new LinkedList<T>(); // (2)
	public void push(T data) {
		list.add(data);
	}
	public T peek() {
		return list.get(list.size()-1);
	}
	public T pop() {
		T data = list.peek();
		list.removeLast();
		return data;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (T item : list) {
			sb.append(item + ", ");
		}
		return sb.toString();
	}
}

class Q<T> {

	private Object[] arr;
	private int front, back, curr, size;

	public Q(int s) {
		arr = new Object[s];
		front = 0;
		back = 0;
		curr = 0;
		size = s;
	}

	public void enq(T data) {
		if (curr == size) throw new Error("no room");
		back = front + curr;
		if (back >= size) back = back % size;
		arr[back] = (Object) data;
		curr++;
	}

	public T deq() {
		if (curr == 0) throw new Error("nothing there");
		T data = (T) arr[front];
		front = front == size - 1 ? 0 : front++;
		curr--;
		return data;
	}
}

public class Feb0717 {

	private static void testCLL() {
		CLL<String> list = new CLL<String>();
		list.addFirst("eh?");
		list.addFirst("yey");
		list.addFirst("bravo");
		System.out.println(list.toString());
		list.removeFirst();
		list.removeFirst();
		System.out.println(list.toString());
		CLL<String> copy = list.copy();
		copy.add("1");
		copy.add("2");
		copy.add("3");
		System.out.println(copy.toString());
		System.out.println(list.toString());
	}

	private static void testStack() {
		Stack<String> s = new Stack<String>(); // (1)
		s.push("yey");
		s.push("bravo");
		s.push("eh?");
		System.out.println(s.peek());
		s.pop();
		System.out.println(s.peek());
	}

	private static void testQ() {
		Q<String> q = new Q<String>(4);
		q.enq("yey");
		q.enq("bravo");
		q.enq("eh?");
		System.out.println(q.deq());
		System.out.println(q.deq()); // TODO
	}

	public static void main(String[] args) {
		//testCLL();
		//testStack();
		testQ();
	}
}
/*
LESSONS:
CLL:
(1) scout != null -> SLL, scout != head -> CLL
(2) don't forget to return a value!
(3) edge cases for toString too!
Stack:
(1) String not T when instantiating ;)
(2) if initialized to null, then initialize it eventually
*/
