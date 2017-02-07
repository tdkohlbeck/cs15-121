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

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> scout = head;
		do {
			sb.append(scout.data + ", ");
			scout = scout.next;
		} while (scout != head); // (1)
		return sb.toString();
	}
}

public class Feb0717 {

	private static void testCLL() {
		CLL<String> list = new CLL<String>();
		list.addFirst("eh?");
		list.addFirst("yey");
		list.addFirst("bravo");
		System.out.println(list.toString());
	}

	public static void main(String[] args) {
		testCLL();
	}
}
/*
LESSONS:
CLL:
(1) scout != null -> SLL, scout != head -> CLL
*/
