class CLL<T> {
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

	public void orderInsert(T data) {
		if (isEmpty()) {
			head = new Node<T>(data, null);
			head.next = head;
			return;
		}
		System.out.println(toString());
		Node<T> scout = head;
		if (data.hashCode() < head.data.hashCode()) { // (3)
			while (scout.next != head) scout = scout.next;
			scout.next = new Node<T>(data, head);
			head = scout.next;
			return;
		}
		while (data.hashCode() > scout.next.data.hashCode()) {
			if (scout.next == head) break; // (4)
			scout = scout.next;
		}
		scout.next = new Node<T>(data, scout.next);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> scout = head;
		do {
			sb.append(scout.data + ", ");
			scout = scout.next;
		} while (scout != head);
		return sb.toString();
	}
}

public class Feb0217 {
	private static void testCLL() { // (1)
		CLL<String> list = new CLL<String>();
		list.orderInsert("c");
		list.orderInsert("d");
		list.orderInsert("yey");
		list.orderInsert("f");
		list.orderInsert("bravo");
		list.orderInsert("a");
		//list.toString(); // (2)
		System.out.println(list.toString());
	}
	public static void main(String[] args) {
		testCLL();
	}
}
/*
LESSONS:
(1) methods called in a static method must also be static
(2) output the string as well as calling it ;)
(3) need a case where data < head
(4) as well as when data > all
*/
