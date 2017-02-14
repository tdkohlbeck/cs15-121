import java.util.*;

class Tree<T> {
	private static class Node<T> {
		private T data;
		private Node<T> left;
		private Node<T> right;
		public Node(T d, Node<T> l, Node<T> r) {
			data = d;
			left = l;
			right = r;
		}
	}
	private Node<T> root = null;
	public boolean isEmpty() {
		return root == null;
	}
	private boolean isEmpty(Node<T> node) {
		return node == null;
	}
	public void add(T data) {
		if (isEmpty()) {
			root = new Node<T>(data, null, null);
			return;
		}
		Node<T> scout = root;
		while (true) {
			if (data.hashCode() < scout.data.hashCode()) {
				if (scout.left == null) {
					scout.left = new Node<T>(data, null, null);
					return;
				}
				scout = scout.left;
			}
			if (data.hashCode() >= scout.data.hashCode()) {
				if (scout.right == null) {
					scout.right = new Node<T>(data, null, null);
					return;
				}
				scout = scout.right;
			}
		}
	}
	public String toString() {
		return toString(root);
	}
	private String toString(Node<T> node) {
		if (isEmpty(node)) return new String("");
		String left = toString(node.left);
		String right = toString(node.right);
		StringBuilder sb = new StringBuilder();
		sb.append(node.data + ", ");
		return left + sb.toString() + right;
	}
}

public class Feb1317 {
	private static void testTree() {
		Tree<String> tree = new Tree<String>();
		tree.add("yey");
		tree.add("bravo");
		tree.add("eh?");
		tree.add("1");
		tree.add("2");
		tree.add("3");
		System.out.println(tree.toString());
	}
	public static void main(String[] args) {
		testTree();
	}
}
