import java.nio.charset.Charset;
import java.util.Scanner;

public class letterCounter {

	public static void main(String[] args) {
		int a = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Gimme a phrase");
		char[] phrase = input.nextLine().toCharArray();
		for (int e = 0; e < phrase.length; e++) {
			for (int b = 0; a <= 25; a++) {
				if (phrase[e] == (char)( 97 + b)) {
					a++;
				}
			}
			System.out.println("There are " + a + " A's in this line");

		}
	}
}
