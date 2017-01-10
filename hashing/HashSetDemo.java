import java.util.*;

public class HashSetDemo {
	public static void main(String[] args) {
		String[] words = {"one", "two", "yey", "bravo", "Aa", "BB", "yey"};
		HashSet<String> hs = new HashSet<String>();

		for (int i = 0; i < words.length; i++) hs.add(words[i]);
		Iterator itr = hs.iterator();

		while (itr.hasNext()) System.out.print(itr.next() + ", ");
		System.out.println();

		for (String s : hs) System.out.print(s + ", ");
		System.out.println();
	}
}
