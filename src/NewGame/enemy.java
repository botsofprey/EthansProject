package NewGame;

import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class enemy extends JPanel {
	private static boolean jumping = true;
	private static final int LOITER = 0;
	private static final int FOLLOW = 1;
	private static final int ATTACK = 2;
	private static final int STILL = 0;
	private static final int LEFT = 1;
	private static final int RIGHT = 2;
	private static int statis = LOITER;
	private static int direction = STILL;
	private static int r = -1;
	private static int jumpForce = 0;
	public static boolean onGround = false;
	public static boolean isDead = false;
	public static int xDistance;
	public static int yDistance;
	public static int health = 10;
	public static ArrayList<JPanel> pixels = new ArrayList<JPanel>();
	static JPanel contentPane = WindowHandler.contentPane;
	static int[] X = new int[50];
	static int[] Y = new int[50];
	static int[] movingLeftColors = new int[] { 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0,
			0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1 };
	static int[] movingRightColors = new int[] { 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0,
			0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1 };
	static int[] standingColors = new int[] { 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0,
			1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1 };

	public enemy(int x, int y) {
		int b = 0;
		for (int c = 0; c < 10; c++) {
			for (int d = 0; d < 5; d++) {
				X[b] = (d * 10) + x;
				Y[b] = (c * 10) + y;
				b++;
			}
		}
		for (int a = 0; a < 50; a++) {
			JPanel pixel = new JPanel();
			pixel.setBounds(X[a], Y[a], 10, 10);
			pixels.add(pixel);
			contentPane.add(pixel);
		}
		player.color(pixels, standingColors);
		setVisibility(true);
	}

	private static void move() {
		if (direction == RIGHT) {
			for (int a = 0; a < X.length; a++) {
				pixels.get(a).setVisible(false);
				X[a] += 5;
			}
			if (r != -1 && statis != LOITER) {
				if (X[49] + 5 > (floor.floorX[floor.levelNumber][r] + floor.floorWidth[floor.levelNumber][r])) {
					jumpForce = 20;
					jump();
				}
			}
			player.color(pixels, movingRightColors);
		} else if (direction == LEFT) {
			for (int a = 0; a < X.length; a++) {
				pixels.get(a).setVisible(false);
				X[a] -= 5;
			}
			if (r != -1 && statis != LOITER) {
				if (X[0] - 5 < (floor.floorX[floor.levelNumber][r])) {
					jumpForce = 20;
					jump();
				}
			}
			player.color(pixels, movingLeftColors);
		}
		if (r != -1) {
			if (!((X[0] + 50) > (floor.floorX[floor.levelNumber][r])
					&& (X[0] < (floor.floorX[floor.levelNumber][r] + floor.floorWidth[floor.levelNumber][r])))
					&& ((Y[47]) <= floor.floorY[floor.levelNumber][r])) {
				jumpForce = 0;
				jumping = true;
			}
		}
	}

	public static void xDistance(JPanel a, JPanel b) {
		/*
		 * a is the player's JPanel, b is the enemy's
		 */
		int x1 = a.getX();
		int x2 = b.getX();
		xDistance = x2 - x1;
		if (Math.abs(xDistance) < 75 && yDistance < 50)
			statis = ATTACK;
		else if (Math.abs(xDistance) < 300)
			statis = FOLLOW;
		else
			statis = LOITER;
		/*
		 * if xDistance is positive, the enemy is on the right, but if the
		 * distance is negative, the player is to the right
		 */
	}

	public static void yDistance(JPanel a, JPanel b) {
		/*
		 * a is the player's JPanel, b is the enemy's
		 */
		int y1 = a.getY();
		int y2 = a.getY();
		yDistance = Math.abs(y2 - y1);
	}

	public void update() {
		if (pixels.get(0).getY() >= 960)
			die(pixels.get(0).getX(), pixels.get(0).getY());
		xDistance(player.pixels.get(0), pixels.get(0));
		yDistance(player.pixels.get(0), pixels.get(0));
		if (NewGame.canMove) {
			if (jumping) {
				jump();
			}
			if (statis == LOITER)
				loiter();
			else if (statis == FOLLOW)
				follow();
			else if (statis == ATTACK)
				attack();
			setVisibility(true);
		} else if (NewGame.canMove == false) {
			direction = STILL;
			statis = LOITER;
		}
	}

	public static void loiter() {
		if (r != -1) {
			if (NewGame.ones % 2 == 0 && X[0] + 50 > floor.floorX[floor.levelNumber][r]
					&& X[0] < floor.floorX[floor.levelNumber][r] + floor.floorWidth[floor.levelNumber][r])
				direction = RIGHT;
			else if (NewGame.ones % 2 == 1 && X[0] + 50 > floor.floorX[floor.levelNumber][r]
					&& X[0] < floor.floorX[floor.levelNumber][r] + floor.floorWidth[floor.levelNumber][r])
				direction = LEFT;
		} else
			direction = STILL;
		if (!isDead) {
			move();
		}
	}

	public static void follow() {
		if (player.X[0] > X[49])
			direction = RIGHT;
		else if (player.X[49] < X[0])
			direction = LEFT;
		if (!isDead) {
			move();
		}
	}

	public static void attack() {
		direction = STILL;
		player.color(pixels, standingColors);
	}

	public static void jump() {
		r = -1;
		for (int x = 4; x >= 0; x--) {
			if (((X[0] + 50) > (floor.floorX[floor.levelNumber][x])
					&& (X[0] < (floor.floorX[floor.levelNumber][x] + floor.floorWidth[floor.levelNumber][x])))
					&& (Y[47] <= floor.floorY[floor.levelNumber][x])) {
				r = x;
			}
		}
		if ((jumpForce < 0) && (r != -1)) {
			if (!(Y[47] + Math.abs(jumpForce) < floor.floorY[floor.levelNumber][r])) {
				for (int i = 0; i <= (Math.abs(jumpForce) + 5); i += 5) {
					if (((Y[47] + (Math.abs(jumpForce) - i)) + 10) == floor.floorY[floor.levelNumber][r]) {
						jumping = false;
						jumpForce = 0;
						for (int j = 0; j < Y.length; j++) {
							Y[j] += ((Math.abs(jumpForce) - i) + 30);
						}
					}
				}
			}
		} else
			jumping = true;
		for (int p = 0; p < Y.length; p++) {
			pixels.get(p).setVisible(false);
			Y[p] -= jumpForce;
		}
		if (jumpForce != -30) {
			jumpForce -= 5;
		}
	}

	public static void setVisibility(boolean visible) {
		for (int a = 0; a < pixels.size(); a++) {
			pixels.get(a).setLocation(X[a], Y[a]);
			pixels.get(a).setVisible(visible);
		}
	}

	public static void die(int x, int y) {
		isDead = true;
		setVisibility(false);
		floorItems.dropItem(x, y + 50);
	}

}
