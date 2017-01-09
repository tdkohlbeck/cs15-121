import java.util.*;

public class LinkedList<T> {
	private static class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<T> head;

	public LinkedList() {
		head = null;
	}

	public void addFirst(T data) {
		head = new Node<T>(data, head);
	}

	public void addLast(T data) {
		// can't access next node if there's no node to begin with!
		if (head == null) addFirst(data);
		else {
			Node<T> temp = head;
			while (temp.next != null) temp = temp.next;
			temp.next = new Node<T>(data, null);
		}
	}

	// my version
	public void addAfter1(T before, T data) {
		if (head == null) return;
		Node<T> temp = head;
		while (temp.data != before) {
			if (temp.next == null) return;
			temp = temp.next;
		}
		Node<T> after = temp.next;
		Node<T> newNode = new Node<T>(data, after);
		temp.next = newNode;
	}
	// their version
	public void addAfter2(T find, T insert) {
		Node<T> temp = head;
		while (temp != null && !temp.data.equals(find)) temp = temp.next;
		// have to check to make sure it was the data conditional that
		// broke the loop and not the null conditional!
		if (temp != null) temp.next = new Node<T>(insert, temp.next);
	}

	public void addBefore(T find, T data) {
		// don't want to try accessing next on a node that doesn't exist!
		if (head == null) return;
		// need to check data of head before moving on to next!
		if (head.data.equals(find)) head = new Node<T>(data, head);
		Node<T> temp = head;
		while (temp.next != null && !temp.next.data.equals(find)) temp = temp.next;
		if (temp.next != null) temp.next = new Node<T>(data, temp.next);
	}
	// my delete
	public void delete1(T find) {
		if (head != null && head.data.equals(find)) head = head.next;
		Node<T> refPointer = head;
		while (refPointer != null && !refPointer.data.equals(find)) refPointer = refPointer.next;
		if (refPointer != null) refPointer.next = refPointer.next.next;
	}
	// their delete
	public void remove(T key) {
		if (head == null) throw new RuntimeException("cannot delete");
		if (head.data.equals(key)) {
			head = head.next;
			return;
		}
		Node<T> cur = head;
		Node<T> prev = null;
		while (cur != null && !cur.data.equals(key)) {
			prev = cur;
			cur = cur.next;
		}
		if (cur == null) throw new RuntimeException("cannot delete");
		prev.next = cur.next;
	}

	public void removeIndex(int n) {
		if (head == null) return;
		if (n == 0) {
			head = head.next;
			return;
		}
		int i = 1;
		Node<T> ref = head;
		while (ref.next != null) {
			if (i == n) {
				ref.next = ref.next.next;
				return;
			}
			ref = ref.next;
			i++;
		}
	}

	public void reverse() {
		if (head == null || head.next == null) return;
		Node<T> ref = head;
		while (ref.next != null) {
			T val = ref.next.data;
			ref.next = ref.next.next;
			addFirst(val);
		}
	}

	/*public Node<T> copy() {

	}*/
	public String toString() {
		StringBuffer s = new StringBuffer();
		Node<T> temp = head;
		while (temp != null) {
			s.append(temp.data);
		}
		return s.toString();
	}

	private class LinkedListIterator implements Iterator<T> {
		private Node<T> nextNode;
		public LinkedListIterator() {
			nextNode = head;
		}
		public T next() {
			if (hasNext()) {
				T data = nextNode.data;
				nextNode = nextNode.next;
			 	return data;
			} else throw new RuntimeException("no next value");
		}
		public boolean hasNext() {
			return nextNode != null;
		}
	}

	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("yey");
		System.out.println(list.toString());
	}
}
