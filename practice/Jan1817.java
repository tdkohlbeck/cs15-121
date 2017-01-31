import java.util.*;

class CowboyHashMap<T> {
	private static class Node<T> {
		T data;
		Node<T> next;
		public Node(T d, Node<T> n) {
			data = d;
			next = n;
		}
	}
	private ArrayList<Node<T>> table = new ArrayList<Node<T>>(4);
	private int nodes = 0;
	private void checkLoad() {
		float loadFactor = nodes / table.size();
		if (loadFactor >= 2) rehash();
	}
	public void add(T data) {
		Node<T> toAdd = new Node<T>(data, null);
		if (table.size() == 0) {
			table.add(toAdd);
			nodes++;
			return;
		}
		int hash = data.hashCode();
		int size = table.size();
		int location = hash >= size ? hash % size : hash;
		Node<T> scout = table.get(location);
		System.out.println(typeof(scout));
		if (scout == null) {
			table.set(location, toAdd);
		}
		while (scout != null) {
			System.out.println("in bucket " + location + ": " + scout.data);
			scout = scout.next;
		}
		scout.next = toAdd;
		nodes++;
		checkLoad();
	}
	public void rehash() {
		ArrayList<Node<T>> newTable = new ArrayList<Node<T>>(table.size()*2);
		Iterator<Node<T>> iter = table.iterator();
		while (iter.hasNext()) {
			Node<T> scout = iter.next();
			while (scout != null) {
				int hash = scout.data.hashCode();
				int size = table.size();
				int location = hash >= size ? hash % size : hash;
				newTable.add(location, scout);
				scout = scout.next;
			}
		}
		table = newTable;
		System.out.println("rehash!");
	}
	public void printState() {
		int index = 0;
		for (Node<T> scout : table) {
			System.out.print("[" + index + "]: ");
			ArrayList<String> vals = new ArrayList<String>();
			while (scout != null) {
				vals.add(scout.data.toString());
				scout = scout.next;
			}
			for (String s : vals) System.out.print(s + ", ");
			System.out.print("\n");
			index++;
		}
	}
}

public class Jan1817<T> {
	private static void testCowboyHashMap() {
		CowboyHashMap<Object> ht = new CowboyHashMap<Object>();
		ht.add("yey");
		ht.add("bravo");
		/*ht.add("yay");
		ht.add(1);
		ht.add(2);
		ht.add(3);*/
		ht.printState();
	}
	public static void main(String[] args) {
		testCowboyHashMap();
	}
}
/*
LESSONS:
1. CowboyHashMap:
 	* Errors
		* 'printlin'
		* used 'array' instead of 'table' in add method
		* Iterator needs to have generic specified at instantiation
			(Iterator<Node<T>>)
		* addAtIndex() not a list method, use add(int i, T val)
		* scan for semi-colons!
		* missing arrow bracket on Iterator
		* don't pass an iterator to for (T val : list), just
			pass an iterable (i.e. the list itself)
		* tried accessing a list outside of its scope
		* forgot to move scout to next in printState
		* forgot 'private' for class properties
		* don't just mod the hash, because it could be less than its modulator!
		* forgot to inc index in printState
*/
