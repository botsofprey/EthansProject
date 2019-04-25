package NewGame;

import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class floorItems extends JPanel {
	private static boolean jumping = false;
	private static int jumpForce;
	private static int[] r;
	public static final int NONE = -1;
	public static final int SWORD = 0;
	public static final int SHIELD = 1;
	public static final int BOW = 2;
	public static final int FOOD = 3;
	public static final int HEALING_POTION = 4;
	public static final int SPEED_POTION = 5;
	public static int[] floorItemTypes = new int[] { NONE, NONE, NONE, NONE, NONE };
	public static int[][] floorItemsX = new int[5][100];
	public static int[][] floorItemsY = new int[5][100];
	public static boolean[] isFull = new boolean[5];
	// checks if the floorItems[a] list is full or not
	public static ArrayList<ArrayList<JPanel>> floorItems = new ArrayList<ArrayList<JPanel>>();
	// sword, shield, bow, and food are where the JPanels are held
	static JPanel contentPane = WindowHandler.contentPane;

	public floorItems() {
		addPoints();
	}

	private static void addPoints() {
		for (int a = 0; a < 5; a++) {
			for (int b = 0; b < 100; b++) {
				floorItemsX[a][b] = 0;
				floorItemsY[a][b] = 0;
			}
		}
	}

	public static void update() {
		for (int a = 0; a < isFull.length; a++) {
			if (isFull[a] == true)
				fall(a);
		}
	}

	public static void fall(int a) {
		if (!jumping) {
			jumpForce = 40;
			jumping = true;
		}
		if ((jumpForce < 0) && (r[a] != -1)) {
			if (!(floorItemsY[a][100] + Math.abs(jumpForce) < floor.floorY[floor.levelNumber][r[a]])) {
				for (int i = 0; i <= (Math.abs(jumpForce) + 5); i += 5) {
					if (((floorItemsY[a][100] + (Math.abs(jumpForce) - i))
							+ 10) == floor.floorY[floor.levelNumber][r[a]]) {
						jumping = false;
						jumpForce = 0;
						for (int j = 0; j < floorItemsY[a].length; j++) {
							floorItemsY[a][j] += ((Math.abs(jumpForce) - i) + 30);
						}
					}
				}
			}
		} else
			jumping = true;
		for (int p = 0; p < floorItems.get(a).size(); p++) {
			floorItems.get(a).get(p).setVisible(false);
			floorItemsY[a][p] -= jumpForce;
		}
	}

	public static void calculateFloor(int a) {
		r[a] = -1;
		if (isFull[a] == true) {
			for (int x = 4; x >= 0; x--) {
				if (((floorItemsX[a][0] + 50) > (floor.floorX[floor.levelNumber][x])
						&& (floorItemsX[a][0] < (floor.floorX[floor.levelNumber][x]
								+ floor.floorWidth[floor.levelNumber][x])))
						&& (floorItemsY[a][100] <= floor.floorY[floor.levelNumber][x])) {
					r[a] = x;
				}
			}
		}
	}

	public static void dropItem(int x, int y) {
		player.itemOnFloor = true;
		int a = (int) (Math.random() * 5);
		int b = -1;
		switch (a) {
		case items.SWORD:
			drop(items.sword, items.swordColors, x, y);
			b = items.SWORD;
			break;
		case items.SHIELD:
			drop(items.shield, items.shieldColors, x, y);
			b = items.SHIELD;
			break;
		case items.BOW:
			drop(items.bow, items.bowColors, x, y);
			b = items.BOW;
			break;
		case items.FOOD:
			drop(items.food, items.foodColors, x, y);
			b = items.FOOD;
			break;
		case items.HEALING_POTION:
			drop(items.healingPotion, items.healingPotionColors, x, y);
			b = items.HEALING_POTION;
			break;
		case items.SPEED_POTION:
			drop(items.speedPotion, items.speedPotionColors, x, y);
			b = items.SPEED_POTION;
			break;
		default:
			System.out.println("Error");
			break;
		}
		if (b != -1) {
			for (int c = 0; c < 5; c++) {
				if (!isFull[c]) {
					floorItemTypes[c] = b;
					c += 5;
				}
			}
		}
		}
		
		public static void drop(ArrayList<JPanel> list, int[] colors, int x, int y) {
			player.color(list, colors);
			for (int a = 0; a < list.size(); a++) {
				list.get(a).setBounds(x + fieldX[a], y + fieldY[a], 5, 5);
			}
			floorItems.add(list);
			for (int a = 0; a < floorItems.size(); a++) {
				if (!floorItems.get(a).isEmpty()) {
					isFull[a] = true;
				} else {
					isFull[a] = false;
				}
			}
			itemOnFloor = true;
		}
	}
}
