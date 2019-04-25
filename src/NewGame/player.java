package NewGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

@SuppressWarnings("serial")
public class player extends JPanel {
	private static boolean jumping = true;
	private static boolean canMoveLeft = true;
	private static boolean canMoveRight = true;
	private static boolean usingSword = false;
	private static boolean usingShield = false;
	private static boolean keyPressed = false;
	private static int a = 0;
	private static int r;
	private static int jumpForce = 0;
	private static int width;
	private static int speed = 10;
	public static int[] standingColors = new int[] { 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0,
			0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1 };
	public static int[] movingLeftColors = new int[] { 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0,
			0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1 };
	public static int[] movingRightColors = new int[] { 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0,
			0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1 };
	public static int[] movingRightSwordLeft = new int[50];
	public static int[] movingRightSwordRight = new int[50];
	public static int[] movingRightShieldLeft = new int[] { 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 3, 1, 0, 1, 1,
			3, 0, 0, 0, 0, 3, 1, 0, 1, 1, 3, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1 };
	public static int[] movingRightShieldRight = new int[] { 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 3,
			0, 0, 0, 0, 3, 1, 1, 0, 1, 3, 1, 1, 0, 1, 3, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0 };
	public static int[] movingLeftSwordLeft = new int[50];
	public static int[] movingLeftSwordRight = new int[50];
	public static int[] movingLeftShieldLeft = new int[] { 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 3, 1, 0, 1, 1,
			3, 0, 0, 0, 0, 3, 1, 0, 1, 1, 3, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1 };
	public static int[] movingLeftShieldRight = new int[] { 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 3,
			0, 0, 0, 0, 3, 1, 1, 0, 1, 3, 1, 1, 0, 1, 3, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1 };
	public static int[] shieldLeft = new int[] { 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 3, 1, 0, 1, 1, 3, 0, 0, 0,
			0, 3, 1, 0, 1, 1, 3, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1 };
	public static int[] shieldRight = new int[] { 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 3, 0, 0, 0,
			0, 3, 1, 1, 0, 1, 3, 1, 1, 0, 1, 3, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1 };
	public static int[] swordLeft = new int[50];
	public static int[] swordRight = new int[50];
	public static int[] currentColors = standingColors;
	public static final int STILL = 0;
	public static final int LEFT = 1;
	public static final int RIGHT = 2;
	public static int direction = STILL;
	public static int pixelColors = STILL;
	public static int maximumVelocity = 30;
	public static int health = 100;
	public static boolean itemOnFloor = false;
	public static boolean isDead = false;
	public static boolean canUpdateColors = true;
	public static Color BROWN = new Color(139, 69, 19);
	public static Color PURPLE = new Color(255, 0, 255);
	public static Color DARK_GREEN = new Color(0, 150, 0);
	public static Color DARK_PINK = new Color(255, 0, 127);
	public static Color PINK = new Color(255, 153, 204);
	public static Color SILVER = new Color(192, 192, 192);
	public static Color LIGHT_BROWN = new Color(204, 123, 51);
	public static ArrayList<JPanel> pixels = new ArrayList<JPanel>();
	public static int[] X = new int[50];
	public static int[] Y = new int[50];
	static JPanel contentPane = WindowHandler.contentPane;
	static JLabel timer = new JLabel();
	static WindowHandler windowHandler;
	Controller controller = new Controller();

	public player(Dimension screenSize) {
		addKeyListener(controller);
		width = (int) screenSize.getWidth();
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 5; x++) {
				X[a] = ((x * 10) + 300);
				Y[a] = ((y * 10) + 100);
				a++;
			}
		}
		for (int q = 0; q < 50; q++) {
			JPanel pixel = new JPanel();
			pixel.setBounds(X[q], Y[q], 10, 10);
			contentPane.add(pixel);
			pixels.add(pixel);
		}
		for (int b = 0; b < 50; b++) {
			movingRightSwordLeft[b] = 2;
			movingRightSwordRight[b] = 2;
			movingLeftSwordLeft[b] = 2;
			movingLeftSwordRight[b] = 2;
			swordLeft[b] = 2;
			swordRight[b] = 2;

		}
		color(pixels, standingColors);
		setVisibility(true);
		setFocusable(true);
		makeTimer();
	}

	public static void makeTimer() {
		timer.setText(NewGame.time);
		timer.setBounds(20, 0, 100, 50);
		timer.setFont(new Font("Marker Felt", 2, 20));
		timer.setVisible(true);
		contentPane.add(timer);
	}

	public void updateTimer() {
		timer.setVisible(false);
		timer.setText(NewGame.time);
		if (NewGame.canMove)
			timer.setVisible(true);
	}

	public static void color(ArrayList<JPanel> pixels, int[] j) {
		/*
		 * Colors the JPanels based on a given integer
		 */
		for (int a = 0; a < pixels.size(); a++) {
			switch (j[a]) {
			case 0:
				pixels.get(a).setBackground(Color.BLACK);
				break;
			case 1:
				pixels.get(a).setBackground(Color.WHITE);
				break;
			case 2:
				pixels.get(a).setBackground(SILVER);
				break;
			case 3:
				pixels.get(a).setBackground(BROWN);
				break;
			case 4:
				pixels.get(a).setBackground(Color.RED);
				break;
			case 5:
				pixels.get(a).setBackground(Color.BLUE);
				break;
			case 6:
				pixels.get(a).setBackground(Color.GREEN);
				break;
			case 7:
				pixels.get(a).setBackground(LIGHT_BROWN);
				break;
			case 8:
				pixels.get(a).setBackground(Color.DARK_GRAY);
				break;
			case 9:
				pixels.get(a).setBackground(Color.LIGHT_GRAY);
				break;
			case 10:
				pixels.get(a).setBackground(Color.MAGENTA);
				break;
			case 11:
				pixels.get(a).setBackground(Color.ORANGE);
				break;
			case 12:
				pixels.get(a).setBackground(Color.PINK);
				break;
			case 13:
				pixels.get(a).setBackground(Color.YELLOW);
				break;
			case 14:
				pixels.get(a).setBackground(Color.CYAN);
				break;
			case 15:
				pixels.get(a).setBackground(PURPLE);
				break;
			case 16:
				pixels.get(a).setBackground(DARK_GREEN);
				break;
			case 17:
				pixels.get(a).setBackground(SILVER);
				break;
			case 18:
				pixels.get(a).setBackground(Color.GRAY);
				break;
			default:
				pixels.get(a).setBackground(null);
				break;
			}
		}
	}

	public void update() {
		tryToPickUpItem();
		updateJump();
		movementRestrictions();
		if (canUpdateColors)
			updateColors();
		if (direction != STILL)
			move();
		color(pixels, currentColors);
		setVisibility(true);
	}

	public static void moveFloors() {
		if (direction == LEFT && canMoveLeft) {
			for (int a = 0; a < floor.floorX[floor.levelNumber].length; a++) {
				floor.floorX[floor.levelNumber][a] += 10;
				floor.floors.get(a).setVisible(false);
				floor.floors.get(a).setLocation(floor.floorX[floor.levelNumber][a], floor.floorY[floor.levelNumber][a]);
				floor.floors.get(a).setVisible(true);
			}
			for (int a = 0; a < enemy.X.length; a++) {
				enemy.pixels.get(a).setVisible(false);
				enemy.X[a] += speed;
			}
			// for (int a = 0; a < floor.lines.size(); a++) {
			// for (int b = 0; b < floor.lines.get(a).size(); b++) {
			// int c = floor.lines.get(a).get(b).getX();
			// floor.lines.get(a).get(b).setVisible(false);
			// c += speed;
			// floor.lines.get(a).get(b).setLocation(c,
			// floor.lines.get(a).get(b).getY());
			// floor.lines.get(a).get(b).setVisible(true);
			// }
			// }
		} else if (direction == RIGHT && canMoveRight) {
			for (int a = 0; a < floor.floorX[floor.levelNumber].length; a++) {
				floor.floorX[floor.levelNumber][a] -= 10;
				floor.floors.get(a).setVisible(false);
				floor.floors.get(a).setLocation(floor.floorX[floor.levelNumber][a], floor.floorY[floor.levelNumber][a]);
				floor.floors.get(a).setVisible(true);
			}
			for (int a = 0; a < enemy.X.length; a++) {
				enemy.pixels.get(a).setVisible(false);
				enemy.X[a] -= speed;
			}
			// for (int a = 0; a < floor.lines.size(); a++) {
			// for (int b = 0; b < floor.lines.get(a).size(); b++) {
			// int c = floor.lines.get(a).get(b).getX();
			// floor.lines.get(a).get(b).setVisible(false);
			// c -= speed;
			// floor.lines.get(a).get(b).setLocation(c,
			// floor.lines.get(a).get(b).getY());
			// floor.lines.get(a).get(b).setVisible(true);
			// }
			// }
		}
	}

	public static void jump() {
		/*
		 * 1. Checks which floor the player will land on 2. Stops the player
		 * when they reach the floor 3. Updates the pixels
		 */
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
	}

	public static void move() {
		/*
		 * 1. Adjusts the x-values of the player depending on the direction it's
		 * going 2. If the player is over the edge of the floor, it falls
		 */
		if (direction == LEFT && canMoveLeft) {
			if (X[0] > 250) {
				for (int a = 0; a < X.length; a++) {
					pixels.get(a).setVisible(false);
					X[a] -= speed;
				}
			} else {
				moveFloors();
				if (itemOnFloor)
					items.move();
			}
		} else if (direction == RIGHT && canMoveRight) {
			if (X[0] + 50 < width - 250) {
				for (int a = 0; a < X.length; a++) {
					pixels.get(a).setVisible(false);
					X[a] += speed;
				}
			} else {
				moveFloors();
				if (itemOnFloor)
					items.move();
			}
		}
		if (r != -1 && !jumping) {
			if (!((X[0] + 50) > (floor.floorX[floor.levelNumber][r])
					&& (X[0] < (floor.floorX[floor.levelNumber][r] + floor.floorWidth[floor.levelNumber][r])))
					&& ((Y[47]) <= floor.floorY[floor.levelNumber][r])) {
				jumpForce = 0;
				jumping = true;
			}
		}
	}

	public static void die() {
		for (int k = 0; k < pixels.size(); k++) {
			pixels.get(k).setVisible(false);
			contentPane.remove(pixels.get(k));
		}
	}

	public void setVisibility(boolean visible) {
		for (int i = 0; i < pixels.size(); i++) {
			pixels.get(i).setLocation(X[i], Y[i]);
			pixels.get(i).setVisible(visible);
		}
		timer.setVisible(visible);
	}

	public static void restart() {
		pixels.clear();
		int a = 0;
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 5; x++) {
				X[a] = ((x * 10) + 300);
				Y[a] = ((y * 10) + 100);
				a++;
			}
		}
		for (int q = 0; q < 50; q++) {
			JPanel pixel = new JPanel();
			pixel.setBounds(X[q], Y[q], 10, 10);
			contentPane.add(pixel);
			pixels.add(pixel);
			pixel.setVisible(true);
		}
		color(pixels, standingColors);
	}

	public static void useShield() {
		usingSword = false;
		usingShield = true;
		if (direction == LEFT) {
			if (enemy.xDistance < 0) {
				currentColors = movingLeftShieldLeft;
			} else if (enemy.xDistance > 0) {
				currentColors = movingLeftShieldRight;
			} else
				System.out.println("error");
		} else if (direction == RIGHT) {
			if (enemy.xDistance < 0) {
				currentColors = movingRightShieldLeft;
			} else if (enemy.xDistance > 0) {
				currentColors = movingRightShieldRight;
			} else
				System.out.println("error");
		}
	}

	public static void useSword(int a) {
		usingShield = false;
		usingSword = true;
		if (a == RIGHT) {
			if (direction == RIGHT) {
				currentColors = movingRightSwordRight;
			} else if (direction == LEFT) {
				currentColors = movingLeftSwordRight;
			} else if (direction == STILL) {
				currentColors = swordRight;
			} else
				System.out.println("error");
		} else if (a == LEFT) {
			if (direction == RIGHT) {
				currentColors = movingRightSwordLeft;
			} else if (direction == LEFT) {
				currentColors = movingLeftSwordLeft;
			} else if (direction == STILL) {
				currentColors = swordLeft;
			} else
				System.out.println("error");
		} else
			System.out.println("error");
	}

	public static void pickUpItem(int a) {
		items.addItem(items.SWORD, true);
		for (int b = 0; b < floorItems.get(a).size(); b++) {
			floorItems.get(a).get(b).setVisible(false);
		}
		floorItems.isFull[a] = false;
		floorItems.floorItems.remove(a);
		itemOnFloor = false;
	}

	public static void updateColors() {
		/*
		 * changes the shield from the right side to the left
		 */
		if (usingShield) {
			if (enemy.xDistance < 0) {
				if (direction == LEFT) {
					currentColors = movingLeftShieldLeft;
				} else if (direction == RIGHT) {
					currentColors = movingRightShieldLeft;
				} else if (direction == STILL) {
					currentColors = shieldLeft;
				}
			} else if (enemy.xDistance > 0) {
				if (direction == LEFT) {
					currentColors = movingLeftShieldRight;
				} else if (direction == RIGHT) {
					currentColors = movingRightShieldRight;
				} else if (direction == STILL) {
					if (usingShield) {
						currentColors = shieldRight;
					}
				}
			}
		} else if (!usingShield && !usingSword) {
			if (direction == LEFT) {
				currentColors = movingLeftColors;
			} else if (direction == RIGHT) {
				currentColors = movingRightColors;
			} else if (direction == STILL) {
				currentColors = standingColors;
			} else
				System.out.println("error");
		}
	}

	public static void movementRestrictions() {
		if (!keyPressed) {
			if (enemy.xDistance == -50 && enemy.yDistance <= 50 && !enemy.isDead)
				canMoveLeft = false;
			else
				canMoveLeft = true;
			if (enemy.xDistance == 50 && enemy.yDistance <= 50 && !enemy.isDead)
				canMoveRight = false;
			else
				canMoveRight = true;
		} else if (keyPressed) {
			canMoveLeft = true;
			canMoveRight = true;
		}
	}

	public static void updateJump() {
		if (jumping) {
			jump();
			if (jumpForce != -30)
				jumpForce -= 5;
		} else if (!jumping) {
			if (Y[47] + 5 == floor.floorY[floor.levelNumber][r]) {
				for (int b = 0; b < Y.length; b++) {
					pixels.get(b).setVisible(false);
					Y[b] -= 5;
				}
			}
		}
	}

	public static void tryToPickUpItem() {
		if (items.itemOnFloor) {
			for (int a = 0; a < floorItems.size(); a++) {
				if (items.findxDistance(pixels.get(0), floorItems.get(a).get(0)) <= 25) {
					pickUpItem(a);
				}
			}
		}
	}

	public class Controller implements KeyListener {

		public void keyPressed(KeyEvent arg0) {
			switch (arg0.getKeyCode()) {
			case KeyEvent.VK_A:
				if (NewGame.canMove)
					direction = LEFT;
				break;
			case KeyEvent.VK_D:
				if (NewGame.canMove)
					direction = RIGHT;
				break;
			case KeyEvent.VK_SPACE:
				if (jumping == false && NewGame.canMove) {
					jumpForce = 40;
					jumping = true;
				}
				break;
			case KeyEvent.VK_I:
				if (gameInventory.inInventory)
					NewGame.closeInventory();
				else
					NewGame.openInventory();
				break;
			case KeyEvent.VK_U:
				if (NewGame.canMove)
					enemy.die(enemy.X[0], enemy.Y[0]);
				break;
			case KeyEvent.VK_LEFT:
				items.check();
				if (items.hasSword && !usingSword) {
					useSword(LEFT);
					canUpdateColors = false;
				} else if (usingSword) {
					usingSword = false;
					updateColors();
				}
				break;
			case KeyEvent.VK_RIGHT:
				items.check();
				if (items.hasSword && !usingSword) {
					useSword(RIGHT);
					canUpdateColors = false;
				} else if (usingSword) {
					usingSword = false;
					updateColors();
				}
				break;
			case KeyEvent.VK_UP:
				items.check();
				if (items.hasShield && !usingShield) {
					useShield();
					usingSword = false;
				} else {
					usingShield = false;
					color(pixels, currentColors);
				}
				break;
			case KeyEvent.VK_R:
				restart();
				break;
			case KeyEvent.VK_J:
				keyPressed = true;
				break;
			default:
				direction = STILL;
				break;
			}
		}

		public void keyReleased(KeyEvent arg0) {
			switch (arg0.getKeyCode()) {
			case KeyEvent.VK_A:
				direction = STILL;
				if (!usingShield && !usingSword) {
					currentColors = standingColors;
				}
				break;
			case KeyEvent.VK_D:
				direction = STILL;
				if (!usingShield && !usingSword) {
					currentColors = standingColors;
				}
				break;
			default:
				direction = STILL;
				if (!usingShield && !usingSword) {
					currentColors = standingColors;
				}
				break;
			}
		}

		public void keyTyped(KeyEvent arg0) {
		}

	}

}
