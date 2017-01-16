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

public class Jan1617<T> {
	public void testCLL() {
		CLL<String> list = new CLL<String>();
		list.add("eh");
		list.add("real");
		list.add("dolphins");
		System.out.println(list.toString());
	}
	public static void main(String[] args) {
		testCLL();
	}
}
/*
LESSONS:
* make sure there"s a list when calling toString()
* double quotes, not singles!
* adding first cyclic, you have to have head point to something before instantiating first node (so that you can pass that pointer to the node)
*/
