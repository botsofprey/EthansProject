package SnakeProgram;

import javax.swing.JFrame;

import NewGame.WindowHandler;

public class SnakeProgram extends JFrame {
	static WindowHandler snakeWindow;
	static foodMaker foodMaker;
	static Snake Snake;
	static boolean a = true;
	public static int z = 0;

	public static void main(String[] args) {
		snakeWindow = new WindowHandler("Snake");
		foodMaker = new foodMaker(snakeWindow.getWindowSize());
		Snake = new Snake(snakeWindow.getWindowSize());
		snakeWindow.add(foodMaker);
		snakeWindow.add(Snake);
		while (a) {
			Snake.requestFocus();
			Snake.moveSnake();
			snakeWindow.repaint();
			try {
				Snake.requestFocus();
				Thread.sleep(100);
				hit();
				eatFood();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void eatFood() {
		for (int b = 0; b <= 10; b++) {
			for (int c = 0; c <= 10; c++) {
				for (int d = 0; d <= 10; d++) {
					for (int e = 0; e <= 10; e++) {
						if (((Snake.x + b) == (foodMaker.x + c) && (Snake.y + d) == (foodMaker.y + e))) {
							z++;
							if (z == 1) {
								Snake.eatFood();
							}
							foodMaker.eatFood();
							Snake.eatFood();
						}
					}
				}
			}
		}
	}

	public static void hit() {
		for (int eth = 4; eth < Snake.numOfTails.size() - 1; eth++) {
			if (Snake.X.get(eth).equals(Snake.x) && (Snake.Y.get(eth).equals(Snake.y))) {
				System.out.println(Snake.X + ", " + Snake.Y + ", " + Snake);
			}
		}
	}
}
