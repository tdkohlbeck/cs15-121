/*public class Dog {
	String breed;
	int ageC;
	String color;

	void barking() {

	}

	void hungry() {

	}

	void sleeping() {

	}
}*/
/*
public class Puppy {
	public Puppy() {
		// constructor with no parameters
	}

	public Puppy(String name) {
		// constructor with one parameter
	}
}
*/
public class Puppy {
	int puppyAge;

	public Puppy(String name) {
	  System.out.println("Passed Name is: " + name);
	}

	public void setAge(int age) {
		puppyAge = age;
	}

	public int getAge() {
		System.out.println("Puppy age: " + puppyAge);
		return puppyAge;
	}

	public static void main(String []args) {
		Puppy myPup = new Puppy("fido");
		myPup.setAge(3);
		myPup.getAge();
		System.out.println("Var Age: " + myPup.puppyAge);
	}
}
