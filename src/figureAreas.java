import java.util.Scanner;

public class figureAreas {

	public static void main(String[] args) {
		boolean wrong1 = false;
		boolean wrong2 = false;
		Scanner input = new Scanner(System.in);
		System.out.println("How many sides does your figure have?");
		do {
			int sides = input.nextInt();
			if (sides < 0) {
				System.out.println("Invalid information. Try again");
				wrong1 = true;
			}
		} while (wrong1);
		do {
			System.out.println("What pieces of information are you given? (apothem, radius, or side)");
			String info = input.nextLine();
			info = info.toLowerCase();
			if (!info.equals(null)) {
				if (info.equals("apothem") || (info.equals("radius")) || (info.equals("side"))) {
					System.out.println("What is the length of the " + info + "?");
					double length = input.nextDouble();
					if (length < 0) {
						System.out.println("Invalid information. Try again.");
						wrong2 = true;
					}
				}
			}
		} while (wrong2);
	}
}