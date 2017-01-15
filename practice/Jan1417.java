class SLL<T> {
	private static class Node<T> {
		private T data;
		private Node<T> next;
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
	private Node<T> head = null;
	public boolean isEmpty() {
		return head == null;
	}
	public void add(T data) {
		if (isEmpty()) {
			head = new Node<T>(data, null);
			return;
		}
		Node<T> scout = head;
		while (scout.next != null) scout = scout.next;
		scout.next = new Node<T>(data, null);
	}
	public String toString() {
		StringBuffer s = new StringBuffer();
		Node<T> iter = head;
		while (iter != null) {
			s.append(iter.data + ", ");
			iter = iter.next;
		}
		return s.toString();
	}
}

public class Jan1417<T> {
	public static void main(String[] args) {
		SLL<Integer> list = new SLL<Integer>();
		list.add(6);
		list.add(6);
		list.add(6);
		list.add(6);
		System.out.println(list.toString());
	}
}
/*
LESSONS:
1. cannot have numbers as a class name
2. method declarations require braces
3. comments have to be closed
4. rename the file when you rename the class
5. static classes cannot be nested inside two classes?
6. when looping, you're checking to see if next is null, not scout
*/
