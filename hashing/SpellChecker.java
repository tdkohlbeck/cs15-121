import java.util.*;
import java.io.*;
import java.net.*;

public class SpellChecker {
	private HashSet<String> dict = new HashSet<String>();
	private static String dictUrl = "http://www.andrew.cmu.edu/course/15-121/dictionary.txt";
	private Scanner scanner = null;

	public SpellChecker() {
		try {
			URL url = new URL(dictUrl);
			scanner = new Scanner(url.openStream());
		} catch (IOException ioe) {
			System.err.println("Could not open" + dictUrl);
			System.exit(0);
		}
		while (scanner.hasNextLine()) {
			String word = scanner.nextLine();
			dict.add(word);
		}
	}

	public void check(String word) {
		if (!dict.contains(word)) System.out.println(word);
	}

	public static void main(String[] args) {
		SpellChecker checker = new SpellChecker();
		String listUrl = args[0];
		Scanner listScanner = null;

		try {
			URL url = new URL(listUrl);
			listScanner = new Scanner(url.openStream());
		} catch (IOException ioe) {
			System.err.println("Could not open " + listUrl);
			System.exit(0);
		}

		while (listScanner.hasNextLine()) {
			String word = listScanner.nextLine();
			checker.check(word);
		}
	}
}
