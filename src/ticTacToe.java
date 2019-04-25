import java.util.Scanner;
public class ticTacToe {
	static boolean playing = true;
	static boolean empty = true;
	static char[][] board = new char[3][3];
	static int player = 1;
	static String winner = "Nobody";
	static String P1;
	static String P2;
	static int e;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int count = '1';
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = (char) count;
				count++;
			}
		}
		        e = 0;
				System.out.println("Player One. What is your name?");
				P1 = input.nextLine();
				System.out.println("Player Two. What is your name?");
				P2 = input.nextLine();
				while (playing) {
					if (player == 1) {
						printBoard();
						System.out.println(P1 + ": What number do you choose?");
						int number = input.nextInt();
						makeMove(number, player);
						checkBoard();
						e++;
						if (e == 9) {
							playing = false;
							printBoard();
						System.out.println("Game Over. " + winner + " has won.");
						}
					} else if (player == 2) {
						printBoard();
						System.out.println(P2 + ": What number do you choose?");
						int number = input.nextInt();
						makeMove(number, player);
						checkBoard();
						e++;
						if (e == 9) {
							playing = false;
							printBoard();
						System.out.println("Game Over. " + winner + " has won." );
						}
					}
				}
			}

	private static void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (j == 0) {
					System.out.print(board[i][j]);
				} else {
					System.out.print("|" + board[i][j]);
				}
				if (j == 2) {
					System.out.println();
				}
			}
		}
	}

	private static void makeMove(int number, int k) {
		switch (number) {
		case 1:
			if (board[0][0] == '1') {
				board[0][0] = (k % 2 == 0) ? 'O' : 'X';
				player = (player == 1) ? 2 : 1;
			} else {
				System.out.println("Spot taken. Try again.");
				k--;
				e--;
			}
			break;

		case 2:
			if (board[0][1] == '2') {
				board[0][1] = (k % 2 == 0) ? 'O' : 'X';
				player = (player == 1) ? 2 : 1;
			} else {
				System.out.println("Spot taken. Try again.");
				player = (player == 1) ? 2 : 1;
				k--;				
				e--;
			}
			break;
		case 3:
			if (board[0][2] == '3') {
				board[0][2] = (k % 2 == 0) ? 'O' : 'X';
				player = (player == 1) ? 2 : 1;
			} else {
				System.out.println("Spot taken. Try again.");
				k--;
				e--;
			}
			break;
		case 4:
			if (board[1][0] == '4') {
				board[1][0] = (k % 2 == 0) ? 'O' : 'X';
				player = (player == 1) ? 2 : 1;
			} else {
				System.out.println("Spot taken. Try again.");
				k--;
				e--;
			}
			break;
		case 5:
			if (board[1][1] == '5') {
				board[1][1] = (k % 2 == 0) ? 'O' : 'X';
				player = (player == 1) ? 2 : 1;
			} else {
				System.out.println("Spot taken. Try again.");
				k--;
				e--;
			}
			break;
		case 6:
			if (board[1][2] == '6') {
				board[1][2] = (k % 2 == 0) ? 'O' : 'X';
				player = (player == 1) ? 2 : 1;
			} else {
				System.out.println("Spot taken. Try again.");
				k--;
				e--;
			}
			break;
		case 7:
			if (board[2][0] == '7') {
				board[2][0] = (k % 2 == 0) ? 'O' : 'X';
				player = (player == 1) ? 2 : 1;
			} else {
				System.out.println("Spot taken. Try again.");
				k--;
				e--;
			}
			break;
		case 8:
			if (board[2][1] == '8') {
				board[2][1] = (k % 2 == 0) ? 'O' : 'X';
				player = (player == 1) ? 2 : 1;
			} else {
				System.out.println("Spot taken. Try again.");
				k--;
				e--;
			}
			break;
		case 9:
			if (board[2][2] == '9') {
				board[2][2] = (k % 2 == 0) ? 'O' : 'X';
				player = (player == 1) ? 2 : 1;
			} else {
				System.out.println("Spot taken. Try again.");
				k--;
				e--;
			}
			break;
		default:
			System.out.println("Error! Invalid!");
			k--;
			e--;
			break;
		}
	}

	public static void checkBoard() {
		if ((board[0][0] == 'X') && (board[1][1] == 'X') && (board[2][2] == 'X')) {
			winner = P1;
			System.out.println(winner + " wins!!!");
			playing = false;
			printBoard();
		} else if ((board[0][0] == 'O') && (board[1][1] == 'O') && (board[2][2] == 'O')) {
			winner = P2;
			System.out.println(winner + " wins!!!");
			playing = false;
			printBoard();
		} else if ((board[0][2] == 'X') && (board[1][1] == 'X') && (board[2][0] == 'X')) {
			winner = P1;
			System.out.println(winner + " wins!!!");
			playing = false;
			printBoard();
		} else if ((board[0][2] == 'O') && (board[1][1] == 'O') && (board[2][0] == 'O')) {
			winner = P2;
			System.out.println(winner + " wins!!!");
			playing = false;
			printBoard();
		} else if ((board[0][0] == 'X') && (board[0][1] == 'X') && (board[0][2] == 'X')) {
			winner = P1;
			System.out.println(winner + " wins!!!");
			playing = false;
			printBoard();
		} else if ((board[0][0] == 'O') && (board[0][1] == 'O') && (board[0][2] == 'O')) {
			winner = P2;
			System.out.println(winner + " wins!!!");
			playing = false;
			printBoard();
		} else if ((board[1][0] == 'X') && (board[1][1] == 'X') && (board[1][2] == 'X')) {
			winner = P1;
			System.out.println(winner + " wins!!!");
			playing = false;
			printBoard();
		} else if ((board[1][0] == 'O') && (board[1][1] == 'O') && (board[1][2] == 'O')) {
			winner = P2;
			System.out.println(winner + " wins!!!");
			playing = false;
			printBoard();
		} else if ((board[2][0] == 'X') && (board[2][1] == 'X') && (board[2][2] == 'X')) {
			winner = P1;
			System.out.println(winner + " wins!!!");
			playing = false;
			printBoard();
		} else if ((board[2][0] == 'O') && (board[2][1] == 'O') && (board[2][2] == 'O')) {
			winner = P2;
			System.out.println(winner + " wins!!!");
			playing = false;
			printBoard();
		} else if ((board[0][0] == 'X') && (board[1][0] == 'X') && (board[2][0] == 'X')) {
			winner = P1;
			System.out.println(winner + " wins!!!");
			playing = false;
			printBoard();
		} else if ((board[0][0] == 'O') && (board[1][0] == 'O') && (board[2][0] == 'O')) {
			winner = P2;
			System.out.println(winner + " wins!!!");
			playing = false;
			printBoard();
		} else if ((board[0][1] == 'X') && (board[1][1] == 'X') && (board[2][1] == 'X')) {
			winner = P1;
			System.out.println(winner + " wins!!!");
			playing = false;
			printBoard();
		} else if ((board[0][1] == 'O') && (board[1][1] == 'O') && (board[2][1] == 'O')) {
			winner = P2;
			System.out.println(winner + " wins!!!");
			playing = false;
			printBoard();
		} else if ((board[0][2] == 'X') && (board[1][2] == 'X') && (board[2][2] == 'X')) {
			winner = P1;
			System.out.println(winner + " wins!!!");
			playing = false;
			printBoard();
		} else if ((board[0][2] == 'O') && (board[1][2] == 'O') && (board[2][2] == 'O')) {
			winner = P2;
			System.out.println(winner + " wins!!!");
			playing = false;
			printBoard();
		} 
	}
}