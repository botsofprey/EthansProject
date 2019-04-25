package SnakeProgram;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class foodMaker extends JPanel {
	int x;
	int y;
	int z = 0;
	private Dimension screenSize;
	private static final int score = 1;

	public foodMaker(Dimension screenSize) {
		this.screenSize = screenSize;
		spawnFood();
	}

	public void spawnFood() {
		x = (int) (Math.random() * (screenSize.getWidth()));
		if (x < 40 || x > (screenSize.getWidth() - 40)) {
			x = (int) (Math.random() * (screenSize.getWidth()));
		}
		y = (int) (Math.random() * (screenSize.getHeight()));
		if (y < 40 || y > (screenSize.getHeight() - 40)) {
			y = (int) (Math.random() * (screenSize.getHeight()));
		}
		setBounds(x, y, 5, 5);
		setBackground(Color.BLACK);
		setVisible(true);
	}

	public int eatFood() {
		setVisible(false);
		spawnFood();
		return score;
	}
}