import java.util.Scanner;

public class price {
	// calculate how many pennies, quarters, dimes, and nickels to give based
	// off of a certain amount of money
	public static void main(String[] Args) {
		Scanner input = new Scanner(System.in);
		int p = 1;
		int n = 5;
		int d = 10;
		int q = 25;
		System.out.print("Gimme some money");
		int money = (int) Math.round(input.nextDouble() * 100);
		if (money <= 0) {
			System.out.println("What am I supposed to do with this? You've given me debt!");
		} else if (money / q >= 0) {
			if (money / q > 1) {
				System.out.println((money / q) + " Quarters");
			} if (money / q == 1) {
			System.out.println((money / q) + " Quarter");
			money = money % q;
			}
			if (money / d == 1) {
				System.out.println((money / d) + " Dime");
			} if (money / d > 1) {
				System.out.println((money / d) + " Dimes");
			}
				money = money % d;
			
			if (money / n >= 0) {
				if (money / n > 1) {
				System.out.println((money / n) + " Nickels");
	    	} else if (money / n == 1) {
	      System.out.println((money / n) + " Nickel");
	      money = money % n;
	    	}
			if (money / p > 1) {
				System.out.println((money / p) + " Pennies");
			} else if (money / p == 0) {
				System.out.println((money / p) + " Penny");
			}
		}
	}
}
}