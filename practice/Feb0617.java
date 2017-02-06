class DLL<T> {
	private static class Node<T> {
		private T data;
		private Node<T> prev;
		private Node<T> next;
		public Node(T d, Node<T> p, Node<T> n) {
			data = d;
			prev = p;
			next = n;
		}
	}

	Node<T> head = null;

	public boolean isEmpty() {
		return head == null;
	}

	public void removeFirst(T data) { // (2)
		if (isEmpty()) throw new Error("empty yo!");
		if (head.data == data) {
			head = head.next;
			if (head != null) head.prev = null; // (1)
			return;
		}
		Node<T> scout = head;
		while (scout.next != null) {
			scout = scout.next;
			if (scout.data == data) {
				scout.prev.next = scout.next;
				if (scout.next != null) {
					scout.next.prev = scout.prev; // (3)
				}
				return;
			}
		}
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

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> scout = head;
		while (scout != null) {
			sb.append(scout.data + ", ");
			scout = scout.next;
		}
		return sb.toString();
	}
}

class QLL<T> {
	private static class Node<T> {
		private T data;
		private Node<T> next;
		public Node(T d, Node<T> n) {
			data = d;
			next = n;
		}
	}
	private Node<T> head = null;
	public boolean isEmpty() {
		return head == null;
	}
	public void enq(T data) {
		if (isEmpty()) head = new Node<T>(data, null);
		else head = new Node<T>(data, head);
	}
	public T deq() {
		if (isEmpty()) throw new Error("empty, yo");
		T data; // (2)
		if (head.next == null) {
			data = head.data;
			head = null;
		} else {
			Node<T> scout = head;
			while (scout.next.next != null) scout = scout.next;
			data = scout.next.data;
			scout.next = null;
		}
		return data;
	}
}

public class Feb0617 {
	private static void testDLL() {
		DLL<String> list = new DLL<String>();
		list.add("yey");
		list.add("bravo");
		list.add("eh?");
		list.removeFirst("bravo");
		System.out.println(list.toString());
	}
	private static void testQLL() {
		QLL<String> q = new QLL<String>();
		q.enq("yey");
		q.enq("bravo");
		q.deq(); // (1)
		q.deq();
		q.deq();
	}
	public static void main(String[] args) {
		//testQLL();
		testDLL();
	}
}
/*
LESSONS:
QLL:
(1) (nit) don't forget parens when calling method!
(2) data was instantiated in the if and the else, so it's
		not accessable outside their scope!
DLL:
(1) in the "only head" edgecase, make sure you're not
		referencing a next node that is null.
(2) (nit) forgot return type
(3) same as (1)--check for the case when you're at the end,
		and there is no next node.
*/
