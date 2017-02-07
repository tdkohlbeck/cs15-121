import java.util.*;
import java.net.*;
import java.io.*;

class AnagramSolver {

	private HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();

	public AnagramSolver() {
		Scanner scan = null;
		try {
			URL url = new URL("http://www.andrew.cmu.edu/course/15-121/dictionary.txt");
			scan = new Scanner(url.openStream());
		} catch (IOException ioe) {
			System.err.println("Could not open url");
			System.exit(0);
		}
		while (scan.hasNextLine()) {
			String word = scan.nextLine();
			String key = sort(word);
			//System.out.println(key);
			LinkedList<String> grams;
			if (map.containsKey(key)) grams = map.get(key);
	 		else grams = new LinkedList<String>();
			grams.add(word);
			map.put(key, grams);
		}
	}

	private String sort(String s) {
		String[] chars = s.split("");
		Arrays.sort(chars);
		StringBuilder sb = new StringBuilder();
		for (String str : chars) {
			sb.append(str);
		}
		return sb.toString();
	}

	public String[] get(String s) {
		String key = sort(s);
		LinkedList<String> list = map.get(key);
		if (list != null) return list.toArray(new String[0]);
		else {
			String[] sa = {"N/A",};
			return sa;
		}
	}
}

class TheirSolution {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://andrew.cmu.edu/course/15-121/dictionary.txt");
		Scanner sc = new Scanner(url.openStream());
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		while (sc.hasNextLine()) {
			String word = sc.nextLine();
			String sortedWord = sortString(word); // key
			ArrayList<String> anagrams = map.get(sortedWord); // value
			if (anagrams == null) anagrams = new ArrayList<String>();
			anagrams.add(word);
			map.put(sortedWord, anagrams);
		}
		System.out.println(map.get(sortString("bread"))); // test
	}
	private static String sortString(String w) {
		char[] ch = w.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
}

public class Anagrams {

	private static void testMySolution() {
		Date t0 = new Date();
		AnagramSolver solver = new AnagramSolver();
		String[] grams = solver.get("reader");
		for (String gram : grams) {
			System.out.print(gram + ", ");
		}
		System.out.println();
		Date t1 = new Date();
		System.out.println("My soln delta: " + (t0.getTime()-t1.getTime()));
	}

	private static void testTheirSolution() {
		Date t0 = new Date();
		TheirSolution solver = new TheirSolution();
		String[] args = new String[0];
		Date t1 = new Date();
		System.out.println("My soln delta: " + (t0.getTime()-t1.getTime()));
	}

	public static void main(String[] args) {
		testMySolution();
		//testTheirSolution();
	}

}
/*
LESSONS:
* a Scanner has methods .hasNextLine and .nextLine, not .hasNext and .next
* don't use an empty string literal with split (e.g. ''), pass nothing instead
* testMySolution needs a return type!
* import java.net.* to use URL
* split returns a String[] not char[]
* Arrays.sort() mutates the given array, doesn't return new array
* Need to try/catch urls, need java.io.*
*/
