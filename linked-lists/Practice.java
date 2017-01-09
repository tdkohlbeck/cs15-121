// Not the game--not the game... practice.
import java.util.*;

public class Practice<T> {
	private static class Node<T> {
		T data;
		Node<T> next;
		Node<T> prev;

		public Node(T data) {
			this.data = data;
		}
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
		public Node(T data, Node<T> prev, Node<T> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

	private class LL<T> {
		private Node<T> head = null;
	}

	private class DLL<T> implements Iterable<T> {
		private Node<T> head;

		public DLL() {
			this.head = null;
		}

		public void addLast(T newData) {
			if (head == null) {
				/* TODO: move to CDLL
				head = new Node<T>(newData); // need to instantiate
				head.next = head; // head before pointing next and
				head.prev = head; // prev to head (instead of null)
				*/
				head = new Node<T>(newData, null, null);
				return;
			}
			Node<T> scout = head;
			while (scout.next != null) scout = scout.next;
			scout.next = new Node<T>(newData, scout, null);
		}

		public Iterator<T> iterator() {
			return new ListIter();
		}

		private class ListIter implements Iterator<T> {
			private Node<T> start;

			public ListIter() {
				this.start = head;
			}

			public boolean hasNext() {
				return (start.next != null || start.next != head);
			}
			public T next() {
				T data = start.data;
				start = start.next;
				return data;
			}
		}
	}

	public static void main(String[] args) {
		DLL<String> dll = new DLL<String>();
		dll.addLast("bravo");
		System.out.println("yey?");
	}
}
