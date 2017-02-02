class CLL<T> {
	private static class Node<T> {
		public T data;
		public Node<T> next;
		public Node(T d, Node<T> n) {
			data = d;
			next = n;
		}
	}

	private Node<T> head = null;
	private Node<T> scout = null;

	public boolean isEmpty() {
		return head == null;
	}

	public void add(T data) {
		if (isEmpty()) {
			head = new Node<T>(data, null);
			head.next = head;
			return;
		}
		scout = head;
		while (scout.next != head) {
			scout = scout.next;
		}
		scout.next = new Node<T>(data, head);
	}

	public void remove(T find) {
		if (isEmpty()) throw new Error("nothing to remove");
		scout = head;
		while (scout.next.data != find) {
			if (scout.next == head) return;
			scout = scout.next;
		}
		Node<T> skip = scout.next.next;
		if (scout.next == head) head = skip; // (1)
		scout.next = skip;
	}

	public int size() {
		if (isEmpty()) return 0;
		int size = 1;
		scout = head;
		while (scout.next != head) {
			size++;
			scout = scout.next;
		}
		return size;
	}

	public void removeAll(T find) {
		while (true) {
			int before = size();
			remove(find);
			if (size() == before) {
				return;
			}
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		scout = head;
		sb.append(scout.data + ", ");
		while (scout.next != head) {
			scout = scout.next;
			sb.append(scout.data + ", ");
		}
		return sb.toString();
	}
}

public class Feb0117 {
	private static void testCLL() {
		CLL<Integer> list = new CLL<Integer>();
		list.add(1);
		System.out.println(list.toString());
		list.add(3);
		list.add(5);
		list.add(1);
		list.add(7);
		System.out.println(list.toString());
		list.removeAll(1);
		System.out.println(list.toString());
	}
	public static void main(String[] args) {
		testCLL();
	}
}
/*
LESSONS:
* when you first loop back and assign head.next to head in a
	CLL, make sure to add a node before referencing head (or
	else it will just be null!)
(1)	make sure to reassign head when removing the head (and
		keep track of your block state!)
*/
