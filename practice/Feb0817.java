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

	public void add(T data) {
		if (isEmpty()) {
			head = new Node<T>(data, null);
			head.next = head;
			return;
		}
		Node<T> scout = head;
		while (scout.next != head) scout = scout.next;
		scout.next = new Node<T>(data, head);
	}

	public void removeFirst(T find) {
		if (isEmpty()) return;
		if (head.next == head) {
			if (head.data == find) head = null;
			return;
		}
		Node<T> scout = head;
		while (scout.next.data != find) {
			scout = scout.next;
			if (scout.next == head) return;
		}
		scout.next = scout.next.next;
	}

	public String toString() {
		if (isEmpty()) return new String();
		StringBuilder sb = new StringBuilder();
		Node<T> scout = head;
		do {
			sb.append(scout.data + ", ");
			scout = scout.next;
		} while (scout != head);
		return sb.toString();
	}
}

public class Feb0817 {

	private static void testCLL() {
		CLL<String> list = new CLL<String>();
		list.add("yey");
		list.add("bravo");
		list.add("eh?");
		list.add("bravo");
		list.removeFirst("bravo");
		System.out.println(list.toString());
	}

	public static void main(String[] args) {
		testCLL();
	}
}
