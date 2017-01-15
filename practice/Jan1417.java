import java.util.*;

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

class Stack<T> {
	private ArrayList<T> stack;
	public Stack() {
		stack = new ArrayList<T>();
	}
	public int last() {
		return stack.size() - 1;
	}
	public T peek() {
		if (stack.isEmpty()) throw new Error();
		return stack.get(last());
	}
	public T pop() {
		if (stack.isEmpty()) throw new Error();
		T data = stack.get(last());
		stack.remove(last());
		return data;
	}
	public void push(T data) {
		stack.add(data);
	}
	/*
	LESSONS:
	1. import java.util.* to use ArrayList
	2. don't access ArrayList by index, use .get(), .add(), etc.
	3. have to specify an instance's type in the method (T data = ...)
	4.
	*/
}

public class Jan1417<T> {
	private static void testSLL() {
		SLL<Integer> list = new SLL<Integer>();
		list.add(6);
		list.add(6);
		list.add(6);
		list.add(7);
		System.out.println(list.toString());
	}
	private static void testStack() {
		Stack<String> stack = new Stack<String>();
		stack.push("yey");
		stack.push("bravo");
		stack.push("eh?");
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
	}
	public static void main(String[] args) {
		//testSLL();
		testStack();
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
