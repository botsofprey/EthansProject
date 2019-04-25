package NewGame;

import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class items extends JPanel {
	private static boolean[] weaponIsOccupied = new boolean[] { false, false };
	private static boolean[] supplyIsOccupied = new boolean[] { false, false, false, false, false };
	public static boolean hasSword = false;
	public static boolean hasShield = false;
	public static boolean hasBow = false;
	public static boolean itemOnFloor = false;
	public static final int NONE = -1;
	public static final int SWORD = 0;
	public static final int SHIELD = 1;
	public static final int BOW = 2;
	public static final int FOOD = 3;
	public static final int HEALING_POTION = 4;
	public static final int SPEED_POTION = 5;
	public static int[] bigBoxesX = new int[] { 326, 326 };
	public static int[] bigBoxesY = new int[] { 28, 210 };
	public static int[] smallBoxesX = new int[] { 38, 130, 222, 314, 406 };
	public static int[] smallBoxesY = new int[] { 396, 396, 396, 396, 396 };
	// boxesX and boxesY are the starting points of the boxes
	public static int[] bigX = new int[100];
	public static int[] bigY = new int[100];
	public static int[] smallX = new int[100];
	public static int[] smallY = new int[100];
	public static int[] fieldX = new int[100];
	public static int[] fieldY = new int[100];
	// X and Y are the points for the JPanels
	public static int[] supplies = new int[] { HEALING_POTION, SPEED_POTION, SPEED_POTION, SPEED_POTION, FOOD };
	public static int[] weapons = new int[] { SWORD, SHIELD };
	public static int[] swordColors = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1,
			1, 1, 1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 1, 1, 1, 0, 1, 1, 2, 2, 2, 1, 1, 1, 1, 1, 0, 1, 2, 2, 1, 1, 1,
			1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 0, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1 };
	public static ArrayList<JPanel> sword = new ArrayList<JPanel>();
	public static int[] shieldColors = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 1, 1, 1, 1, 3, 3, 1, 1, 3, 3,
			3, 1, 1, 3, 3, 3, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 1,
			1, 1, 1, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1 };
	public static ArrayList<JPanel> shield = new ArrayList<JPanel>();
	public static int[] bowColors = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 3, 1, 1, 1, 1, 1,
			1, 1, 0, 1, 3, 1, 1, 1, 1, 1, 1, 0, 1, 1, 3, 1, 1, 1, 1, 1, 0, 1, 1, 1, 3, 1, 1, 1, 1, 0, 1, 1, 1, 3, 1, 1,
			1, 1, 0, 1, 1, 1, 3, 1, 1, 1, 1, 0, 1, 1, 1, 3, 1, 1, 1, 1, 1, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1 };
	public static ArrayList<JPanel> bow = new ArrayList<JPanel>();
	public static int[] foodColors = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 7, 7, 7, 7, 7, 7, 7, 1, 1, 7, 7, 7,
			7, 7, 7, 7, 7, 1, 1, 1, 6, 1, 6, 1, 6, 1, 6, 1, 1, 6, 1, 6, 1, 6, 1, 6, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 1,
			1, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 7, 7, 7, 7, 7, 7, 7, 7, 1, 1, 7, 7, 7, 7, 7, 7, 7, 7, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1 };
	public static ArrayList<JPanel> food = new ArrayList<JPanel>();
	public static int[] healingPotionColors = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 1, 1, 1, 1, 1,
			1, 1, 1, 4, 4, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 1, 1, 1, 1, 4, 4, 4, 4, 4,
			4, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 1, 1, 1, 1, 1, 4, 4, 4, 4, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1 };
	public static ArrayList<JPanel> healingPotion = new ArrayList<JPanel>();
	public static int[] speedPotionColors = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 1, 1, 1, 1, 1,
			1, 1, 1, 5, 5, 1, 1, 1, 1, 1, 1, 1, 5, 5, 5, 5, 1, 1, 1, 1, 1, 5, 5, 5, 5, 5, 5, 1, 1, 1, 1, 5, 5, 5, 5, 5,
			5, 1, 1, 1, 1, 5, 5, 5, 5, 5, 5, 1, 1, 1, 1, 5, 5, 5, 5, 5, 5, 1, 1, 1, 1, 1, 5, 5, 5, 5, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1 };
	public static ArrayList<JPanel> speedPotion = new ArrayList<JPanel>();
	static JPanel contentPane = WindowHandler.contentPane;

	public items() {
		addPoints();
		addPanels();
	}

	private static void addPoints() {
		/*
		 * called when initialized
		 */
		int a = 0;
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				bigX[a] = x * 16;
				bigY[a] = y * 16;
				smallX[a] = x * 8;
				smallY[a] = y * 8;
				fieldX[a] = x * 5;
				fieldY[a] = y * 5;
				a++;
			}
		}
	}

	private static void addPanels() {
		/*
		 * called when initialized
		 */
		for (int a = 0; a < 100; a++) {
			JPanel panel = new JPanel();
			sword.add(panel);
			contentPane.add(panel);
		}
		for (int a = 0; a < 100; a++) {
			JPanel panel = new JPanel();
			shield.add(panel);
			contentPane.add(panel);
		}
		for (int a = 0; a < 100; a++) {
			JPanel panel = new JPanel();
			bow.add(panel);
			contentPane.add(panel);
		}
		for (int a = 0; a < 100; a++) {
			JPanel panel = new JPanel();
			food.add(panel);
			contentPane.add(panel);
		}
		for (int a = 0; a < 100; a++) {
			JPanel panel = new JPanel();
			speedPotion.add(panel);
			contentPane.add(panel);
		}
		for (int a = 0; a < 100; a++) {
			JPanel panel = new JPanel();
			healingPotion.add(panel);
			contentPane.add(panel);
		}
			player.color(speedPotion, speedPotionColors);
			player.color(healingPotion, healingPotionColors);
			player.color(sword, swordColors);
			player.color(shield, shieldColors);
			player.color(bow, bowColors);
			player.color(food, foodColors);
	}

	public void addWeapons() {
		/*
		 * called when inventory is opened, colors and adds weapons
		 */
		for (int a = 0; a < weapons.length; a++) {
			if (weapons[a] == SWORD && weaponIsOccupied[a] == false) {
				hasSword = true;
				addWeapon(bigBoxesX[a], bigBoxesY[a], SWORD);
				weaponIsOccupied[a] = true;
			}
			if (weapons[a] == SHIELD && weaponIsOccupied[a] == false) {
				hasShield = true;
				addWeapon(bigBoxesX[a], bigBoxesY[a], SHIELD);
				weaponIsOccupied[a] = true;
			}
			if (weapons[a] == BOW && weaponIsOccupied[a] == false) {
				hasBow = true;
				addWeapon(bigBoxesX[a], bigBoxesY[a], BOW);
				weaponIsOccupied[a] = true;
			}
		}
	}

	public void addSupplies() {
		/*
		 * called when inventory is opened, colors and adds supplies
		 */
		for (int a = 0; a < supplies.length; a++) {
			if (supplies[a] == HEALING_POTION && supplyIsOccupied[a] == false) {
				addSupply(smallBoxesX[a], smallBoxesY[a], HEALING_POTION);
				supplyIsOccupied[a] = true;
			}
			if (supplies[a] == SPEED_POTION && supplyIsOccupied[a] == false) {
				addSupply(smallBoxesX[a], smallBoxesY[a], SPEED_POTION);
				supplyIsOccupied[a] = true;
			}
			if (supplies[a] == SPEED_POTION && supplyIsOccupied[a] == false) {
				addSupply(smallBoxesX[a], smallBoxesY[a], FOOD);
				supplyIsOccupied[a] = true;
			}
		}
	}

	public void updateItems() {
		/*
		 * called when the player picks up an item
		 */
		for (int c = 0; c < supplies.length; c++) {
			switch (supplies[c]) {
			case -1:
				supplies[c] = NONE;
				break;
			case 0:
				supplies[c] = SWORD;
				break;
			case 1:
				supplies[c] = SHIELD;
				break;
			case 2:
				supplies[c] = BOW;
				break;
			case 3:
				supplies[c] = FOOD;
			default:
				System.out.println("Invalid");
				break;
			}
		}
	}

	public static void addWeapon(int a, int b, int Weapon) {
		/*
		 * called when items are added if the player has a sword, or when the
		 * enemy dies
		 */
		ArrayList<JPanel> weapon = new ArrayList<JPanel>();
		for (int c = 0; c < 100; c++) {
			JPanel panel = new JPanel();
			panel.setBounds(a + bigX[c], b + bigY[c], 16, 16);
			weapon.add(panel);
			contentPane.add(panel);
			panel.setVisible(true);
		}
		if (Weapon == SWORD)
			player.color(weapon, swordColors);
		else if (Weapon == SHIELD)
			player.color(weapon, shieldColors);
		else if (Weapon == BOW)
			player.color(weapon, bowColors);
	}

	public static void addSupply(int a, int b, int supply) {
		/*
		 * called when items are added if the player has a speed potion, or when
		 * the enemy dies
		 */
		ArrayList<JPanel> item = new ArrayList<JPanel>();
		for (int c = 0; c < 100; c++) {
			JPanel panel = new JPanel();
			panel.setBounds(a + smallX[c], b + smallY[c], 8, 8);
			item.add(panel);
			contentPane.add(panel);
			panel.setVisible(true);

		}
		if (supply == SPEED_POTION)
			player.color(item, speedPotionColors);
		else if (supply == HEALING_POTION)
			player.color(item, healingPotionColors);
		else if (supply == FOOD)
			player.color(item, foodColors);
	}

	public static void move() {
		if (player.direction == player.LEFT) {
			for (int a = 0; a < floorItems.floorItems.size(); a++) {
				for (int b = 0; b < floorItems.floorItems.get(a).size(); b++) {
					floorItems.floorItems.get(a).get(b).setVisible(false);
					int c = floorItems.floorItems.get(a).get(b).getX();
					c += 10;
					floorItems.floorItems.get(a).get(b).setLocation(c, floorItems.floorItems.get(a).get(b).getY());
					floorItems.floorItems.get(a).get(b).setVisible(true);
				}
			}
		} else if (player.direction == player.RIGHT) {
			for (int a = 0; a < floorItems.floorItems.size(); a++) {
				for (int b = 0; b < floorItems.floorItems.get(a).size(); b++) {
					floorItems.floorItems.get(a).get(b).setVisible(false);
					int c = floorItems.floorItems.get(a).get(b).getX();
					c -= 10;
					floorItems.floorItems.get(a).get(b).setLocation(c, floorItems.floorItems.get(a).get(b).getY());
					floorItems.floorItems.get(a).get(b).setVisible(true);
				}
			}

		}
	}

	public static void check() {
		for (int a = 0; a < weapons.length; a++) {
			if (weapons[a] == SWORD)
				hasSword = true;
			if (weapons[a] == SHIELD)
				hasShield = true;
			if (weapons[a] == BOW)
				hasBow = true;
		}
	}

	public void setVisibility(boolean visible) {
		/*
		 * called when inventory is either opened or closed
		 */
		for (int a = 0; a < sword.size(); a++) {
			sword.get(a).setVisible(visible);
			shield.get(a).setVisible(visible);
			bow.get(a).setVisible(visible);
			healingPotion.get(a).setVisible(visible);
			speedPotion.get(a).setVisible(visible);
			food.get(a).setVisible(visible);
		}
	}

	public static int findxDistance(JPanel a, JPanel b) {
		/*
		 * if the integer is negative, the player is to the right of the enemy.
		 * Otherwise, the player is to the left
		 */
		int p = a.getX();
		int e = b.getX();
		int c = Math.abs(e - p);
		return c;
	}

	public static int findyDistance(JPanel a, JPanel b) {
		int d = a.getY();
		int e = b.getY();
		int c = Math.abs(e - d);
		return c;
	}

	public static void addItem(int item, boolean isWeapon) {
		int i = 0;
		if (isWeapon) {
			for (int a = 0; a < weaponIsOccupied.length; a++) {
				if (!weaponIsOccupied[a] == false && i != 1) {
					weapons[a] = item;
					addWeapon(bigBoxesX[a], bigBoxesY[a], item);
					weaponIsOccupied[a] = true;
					i++;
				}
			}
		} else if (!isWeapon) {
			for (int a = 0; a < supplyIsOccupied.length; a++) {
				if (!supplyIsOccupied[a] && i != 1) {
					supplies[a] = item;
					addSupply(smallBoxesX[a], smallBoxesY[a], item);
					supplyIsOccupied[a] = true;
					i++;
				}
			}
		}
		i = 0;
	}

	public static boolean isInAir(int a) {
		if (floorItems.floorItems.get(a).get(0).getY() + 5 < floor.floorY[floor.levelNumber][floorItems.r[a]])
			return true;
		else
			return false;
	}


}
