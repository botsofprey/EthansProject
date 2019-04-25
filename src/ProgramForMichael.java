import java.util.Scanner;

public class ProgramForMichael {
	static boolean gameIsOver = false;
	static int marbles = 12;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("There are twelve marbles. The person who takes the last marble wins, "
				+ "and you make take either one, two, or three each turn.");
		int a = 0;
		while (!gameIsOver) {
			System.out.println("How many marbles do you want to take?");
			int number = input.nextInt();
			if (number == 1 && marbles > 1) {
				System.out.println("There are " + marbles + " marbles remaining. Next Player.");
				marbles--;
			} else if (number == 2 && marbles > 1) {
				marbles -= 2;
				System.out.println("There are " + marbles + " marbles remaining. Next Player.");
			} else if (number == 3 && marbles > 1) {
				marbles -= 3;
				System.out.println("There are " + marbles + " marbles remaining. Next Player.");
			} else if (marbles == 0) {
				System.out.println("There are zero marbles remaining. You win!");
			} else {
				System.out.println("Number out of bounds. Try again");
			}
		}
	}
}