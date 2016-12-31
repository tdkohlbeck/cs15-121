import java.util.*;
/*
class LinkedList<Type> {

	class Node<Type> {

		private Type data;
		private Node next;

		public Node(Type data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	Node<Type> head = new Node<Type>();
}
*/

public class Playground {
	public static void main(String args[]) {
		/*
		TestArray charArr = new TestArray(10);
		System.out.println(charArr);
		charArr.delete(0);
		System.out.println(charArr);
		charArr.insert('t', 7);
		System.out.println(charArr);
		*/
		/*
		ArrayList<Integer> num = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			num.add(i);
		}
		for (int i = 0; i < num.size(); i++) {
			if (num.get(i) % 2 == 0) num.remove(i);
		}
		System.out.println(num);
		*/
		/*
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		long t1, t2;
		int size = 10000000;
		t1 = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			tmp.add(i);
			//System.out.println(tmp);
		}
		t2 = System.currentTimeMillis();
		System.out.println("Compute time: " + (t2-t1));

		t1 = System.currentTimeMillis();
		for (int i = size-1; i >= 0; i--) {
			tmp.remove(i);
			//System.out.println(tmp);
		}
		t2 = System.currentTimeMillis();
		System.out.println("Compute time: " + (t2-t1));
		*/
	}
}

class TestArray {

	private char[] data;

	public TestArray(int size) {
		Random rand = new Random();
		data = new char[size];
		for (int i = 0; i < size; i++) {
			data[i] = (char) ('a' + rand.nextInt(26));
		}
	}

	public void delete(int pos) {
		if (pos >= 0 && pos < data.length) {
			char[] tmp = new char[data.length-1];
			System.arraycopy(data, 0, tmp, 0, pos);
			System.arraycopy(data, pos+1, tmp, pos, tmp.length-pos);
			data = tmp;
		}
	}

	public void insert(char x, int pos)	{
		if (pos >= 0 && pos < data.length) {
			char[] tmp = new char[data.length+1];
			System.arraycopy(data, 0, tmp, 0, pos);
			System.arraycopy(data, pos, tmp, pos+1, data.length-pos);
			tmp[pos] = x;
			data = tmp;
		}
	}

	public String toString() {
		return Arrays.toString(data);
	}
}
