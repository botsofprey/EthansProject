package SnakeProgram;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;

import NewGame.WindowHandler;

public class Snake extends JPanel {
	WindowHandler snakeWindow = new WindowHandler("Snake");
	private Dimension screenSize;
	public final static int UP = 1;
	public final static int DOWN = 2;
	public final static int LEFT = 3;
	public final static int RIGHT = 4;
	public static int direction = (int)(Math.random() * 4);
	int x;
	int y;
	int score = 0;
	Controller controller = new Controller();
	ArrayList<JPanel> numOfTails = new ArrayList<JPanel>(367);
	static ArrayList<Integer> X = new ArrayList<Integer>(123467);
	static ArrayList<Integer> Y = new ArrayList<Integer>(247123836);

	public Snake(Dimension screenSize) {
		this.screenSize = screenSize;
		x = (int) (Math.random() * (this.screenSize.getWidth()));
		y = (int) (Math.random() * (this.screenSize.getHeight()));
		addKeyListener(controller);
		setBackground(pickColor());
		setBounds((int) this.screenSize.getWidth(), (int) this.screenSize.getHeight(), 10, 10);
		setVisible(true);
		setBackground(Color.green);
	}

	public void spawnSnake() {
		setLocation(x, y);
		X.add(x);
		Y.add(y);
		if (X.size() > numOfTails.size()) {
			X.remove(0);
			Y.remove(0);
		}
		setVisible(true);
		for (int i = 0; i < numOfTails.size(); i++) {
			numOfTails.get(i).setVisible(false);
			numOfTails.get(i).setLocation(X.get(i), Y.get(i));
			numOfTails.get(i).setVisible(true);
		}
	}

	public void moveSnake() {
		switch (direction) {
		case UP:
			y -= 12;
			break;
		case DOWN:
			y += 12;
			break;
		case LEFT:
			x -= 12;
			break;
		case RIGHT:
			x += 12;
			break;
		}
		if (x > ((WindowHandler.screenResolution.getWidth() / 2.0) - 12) && direction == RIGHT) x = 0;
		else if (x < 12 && direction == LEFT) x = (int) (WindowHandler.screenResolution.getWidth() / 2.0);
		else if (y > ((WindowHandler.screenResolution.getHeight() / 2.0) - 12) && direction == DOWN) y = 0;
		else if (y < 0 && direction == UP) y = (int) (WindowHandler.screenResolution.getHeight() / 2.0);
		spawnSnake();
	}

	public void eatFood() {
		this.score += score;
		JPanel newTail = new JPanel();
		numOfTails.add(newTail);
		snakeWindow.getContentPane().add(newTail);
		if (direction == UP) {
			X.add(x);
			Y.add(y - 12);
		} else if (direction == DOWN) {
			X.add(x);
			Y.add(y + 12);
		} else if (direction == LEFT) {
			Y.add(y);
			X.add(x - 12);
		} else if (direction == RIGHT) {
			Y.add(y);
			X.add(x + 12);
		}
		newTail.setBounds(X.get(X.size() - 1), Y.get(Y.size() - 1), 10, 10);
		newTail.setBackground(Color.green);
		newTail.setVisible(true);
		spawnSnake();
	}

	private Color pickColor() {
		int a = (int) (Math.random() * 8);
		switch (a) {
		case 0:
			return Color.RED;
		case 1:
			return Color.ORANGE;
		case 2:
			return Color.CYAN;
		case 3:
			return Color.GREEN;
		case 4:
			return Color.BLUE;
		case 5:
			return Color.GRAY;
		case 6:
			return Color.DARK_GRAY;
		case 7:
			return Color.ORANGE;
		default:
			return Color.MAGENTA;
		}
	}

	class Controller implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			switch (arg0.getKeyCode()) {
			case KeyEvent.VK_W:
				if ((direction == RIGHT) || (direction == LEFT)) {
					direction = UP;
					moveSnake();
				}
				break;
			case KeyEvent.VK_A:
				if ((direction == DOWN) || (direction == UP)) {
					direction = LEFT;
				}
				break;
			case KeyEvent.VK_S:
				if ((direction == LEFT) || (direction == RIGHT)) {
					direction = DOWN;
				}
				break;
			case KeyEvent.VK_D:
				if ((direction == UP) || (direction == DOWN)) {
					direction = RIGHT;
				}
				break;
			}
		}

		public void keyReleased(KeyEvent arg0) {
		}

		public void keyTyped(KeyEvent arg0) {
		}

	}
}
