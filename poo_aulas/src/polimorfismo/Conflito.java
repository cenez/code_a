package polimorfismo;

public class Conflito {
	public static void sum(int a, int b) {
		System.out.println("Sum of int: " + (a + b));
	}

	public static void sum(double a, double b) {
		System.out.println("Sum of double: " + (a + b));
	}

	public static void main(String args[]) {
		sum(1, 2);
		sum(1.1, 2.2);
		sum(1, 2.2);
		sum((int) 1.1, (int) 2.2);
	}
}
