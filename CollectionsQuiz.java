import java.util.*;

public class CollectionsQuiz {
	public static void main(String[] args) {

	}

	public void printIterator(ArrayList<String> strings) {
		Iterator<String> itr = strings.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	public void printForEach(ArrayList<String> strings) {
		for (String s : strings) {
			System.out.println(s);
		}
	}
}

/*
1. A set is a collection interface wherein each member object must be unique
	 A List is a collection interface that allows index-like access.
	 A Map is a collection interface where each object has a unique key associated with it.
2. An iterator is an object which references another object and is able to access/remove the elements in that object. I don't know why it is necessary.
	... but now I do. The iterator interface allows an object to be iterated, without showing how that object is implemented.
	You can iterate through a linked list, but you'd be manipulating the data structure, rather than a standard interface!
3. Generics must be an object and int is a primitive. use Integer instead.
4. see above
5. see above
6. Generics allow code to be written that can be reused for a variety of types. It also ensures type safety at compile-time.
7. No.
