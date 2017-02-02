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
		Arrays.toString(chars);
		System.out.println(chars);
		return chars;
	}

	public String[] get(String s) {
		//System.out.println(s);
		String key = sort(s);
		//System.out.println(s);
		return (String[]) map.get(key).toArray();
	}
}

public class Anagrams {
	private static void testMySolution() {
		AnagramSolver grams = new AnagramSolver();
		System.out.println(grams.get("bread"));
	}
	public static void main(String[] args) {
		testMySolution();
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
