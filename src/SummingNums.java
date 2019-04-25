import java.util.Scanner;

public class SummingNums {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Input starting value");
		int start = input.nextInt();
		System.out.println("Input ending value");
		int end = input.nextInt();
		int curNum = start;
		int sum = 0;
		do {
			System.out.println(curNum);
			sum += curNum;
			curNum++;
		} while(curNum <= end);
		System.out.println("The sum of the numbers is " + sum);
		double average = sum / ((end - start) + 1);
		System.out.println("The average of these numbers is " + average);
	}
}
