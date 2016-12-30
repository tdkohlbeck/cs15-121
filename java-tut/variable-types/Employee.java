public class Employee {

	public static final String DEPT = "Development";
	public String name;
	private static double salary;

	public Employee(String name) {
		this.name = name;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void printInfo() {
		System.out.println("Name: " + name);
		System.out.println("Salary: " + salary);
	}
	public static void main(String args[]) {
		Employee first = new Employee("Jerry");
		first.setSalary(100000);
		first.printInfo();
	}
}
