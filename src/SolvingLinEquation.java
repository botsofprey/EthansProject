import java.util.Scanner;

public class SolvingLinEquation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your a value for ax + b = 0");
		double a = input.nextDouble();
		System.out.println("Enter your b value for ax + b = 0");
		double b = input.nextDouble();
		double x = (-b / a);
		System.out.println("x = " + x);
		
	}
}
