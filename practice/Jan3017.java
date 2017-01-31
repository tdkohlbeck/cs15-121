import java.util.*;

class LL<T> {
	static class Node<T> {
		T data;
		Node<T> next;
		public Node(T d, Node<T> n) {
			data = d;
			next = n;
		}
	}
	private Node<T> head;
	private boolean empty(Node<T> node) {
		return node == null;
	}
	public void add(T add) {
		if (empty(head)) {
			head = new Node<T>(add, null);
			return;
		}
		Node<T> scout = head;
		while (!empty(scout.next)) scout = scout.next;
		scout.next = new Node<T>(add, null);
	}
	public void addAfter(T find, T add) {
		if (empty(head)) throw new Error();
		Node<T> scout = head;
		while (scout.data != find) {
			if (empty(scout.next)) throw new Error();
			scout = scout.next;
		}
		Node<T> toAdd = new Node<T>(add, scout.next);
		scout.next = toAdd;
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node<T> scout = head;
		while (!empty(scout)) {
			sb.append(scout.data + ", ");
			scout = scout.next;
		}
		return sb.toString();
	}
}

class Stack<T> {
	private ArrayList<T> list = new ArrayList<T>();
	private boolean isEmpty() {
		return list.size() == 0;
	}
	public void push(T data) {
		list.add(data);
	}
	public T peek() {
		if (isEmpty()) throw new Error();
		return list.get(list.size() - 1);
	}
	public T pop() {
		if (isEmpty()) throw new Error();
		return list.remove(list.size() - 1);
	}
	public String toString() {
		return list.toString();
	}
}

public class Jan3017 {
	public static void testLL() {
		LL<String> list = new LL<String>();
		list.add("yey");
		list.add("bravo");
		list.addAfter("yey", "eh?");
		System.out.println(list.toString());
	}
	public static void testStack() {
		Stack<String> stack = new Stack<String>();
		stack.push("yey");
		stack.push("eh?");
		stack.pop();
		stack.peek();
		stack.push("bravo");
		System.out.println(stack.toString());
	}
	public static void main(String[] args ) {
		//testLL();
		testStack();
	}
}
/*
LESSONS:
LL:
* can't pass a generic into a static method?
* remember to separate appends with a comma in toString()
* return in add.if.empty or include else (don't add twice!)
* class props should be private
STACK:
* peek() and pop() edge case: stack is empty
* to use ArrayList, must import java.util.*
* semi-colons!
*/
