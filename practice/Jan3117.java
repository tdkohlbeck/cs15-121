import java.util.*;

class DLL<T> { // 12'19"
	private static class Node<T> {
		T data;
		Node<T> prev;
		Node<T> next;
		public Node(T d, Node<T> p, Node<T> n) {
			data = d;
			prev = p;
			next = n;
		}
	}
	private Node<T> head = null;
	public boolean isEmpty() {
		return head == null;
	}
	public void add(T data) {
		if (isEmpty()) {
			head = new Node<T>(data, null, null);
			return;
		}
		Node<T> scout = head;
		while (scout.next != null) scout = scout.next;
		scout.next = new Node<T>(data, scout, null);
	}
	public T removeFirst() {
		if (isEmpty()) throw new Error();
		head = head.next;
		T data = head.prev.data;
		head.prev = null;
		return data;
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node<T> scout = head;
		while (scout != null) {
			sb.append(scout.data + ", ");
			scout = scout.next;
		}
		return sb.toString();
	}
}

class Queue<T> {
	private LinkedList<T> list = new LinkedList<T>();
	public boolean isEmpty() {
		return list.size() == 0;
	}
	public void enq(T data) {
		list.add(data);
	}
	public T deq() {
		return list.remove(0);
	}
	public String toString() {
		return list.toString();
	}
}

public class Jan3117 {
	public static void testDLL() {
		DLL<String> list = new DLL<String>();
		list.add("yey");
		list.add("eh?");
		list.add("bravo");
		System.out.println(list.removeFirst());
		System.out.println(list.toString());
	}
	public static void testQueue() {
		Queue<String> q = new Queue<String>();
		q.enq("yey");
		q.enq("bravo");
		q.enq("eh?");
		q.deq();
		System.out.println(q.toString());
	}
	public static void main(String[] args) {
		//testDLL();
		testQueue();
	}
}
/*
LESSONS:
* methods called in a static method must be static as well!
* no constructor? don't forget to init class props (e.g. new LinkedList<T>();)
*/
