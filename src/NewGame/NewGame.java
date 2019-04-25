package NewGame;

import javax.swing.JPanel;
import NewGame.WindowHandler;
import NewGame.player;
import NewGame.floor;

@SuppressWarnings("serial")
public class NewGame extends JPanel {
	private static background background;
	private static floor floor;
	private static gameInventory inventory;
	private static player player;
	private static enemy enemy;
	private static items items;
	private static healthBar healthBar;
	private static statisBar statisBar;
	private static leftOrRightBar leftOrRightBar;
	private static floorItems floorItems;
	private static int t = 0;
	public static boolean inventoryIsOpen = false;
	public static boolean canMove = true;
	public static boolean running = true;
	public static int updatable = 0;
	public static int thousandths = 0;
	public static int hundredths = 0;
	public static int tenths = 0;
	public static int ones = 0;
	public static String time = String.valueOf(ones) + "." + String.valueOf(thousandths) + String.valueOf(hundredths)
			+ String.valueOf(tenths);
	static WindowHandler windowHandler;

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		initializeVariables();
		while (running) {
			Thread.sleep(1);
			t++;
			if (canMove) {
				changeTimer();
			}
			if (t == 25) {
				if (canMove) {
					player.requestFocus();
					if (!player.isDead) {
						player.update();
						statisBar.update();
						healthBar.update();
						leftOrRightBar.update();
						if (!player.canUpdateColors) {
							updatable++;
							if (updatable == 25) {
								player.canUpdateColors = true;
								updatable = 0;
							}
						}
					}
					if (!enemy.isDead)
						enemy.update();
				}
				t = 0;
			}
		}
	}

	@SuppressWarnings("static-access")
	public static void openInventory() {
		gameInventory.inInventory = true;
		items.addWeapons();
		items.addSupplies();
		inventory.setVisibility(true);
		background.setVisibility(false);
		player.setVisibility(false);
		floor.setVisibility(false);
		enemy.setVisibility(false);
		canMove = false;
	}

	@SuppressWarnings("static-access")
	public static void closeInventory() {
		gameInventory.inInventory = false;
		inventory.setVisibility(false);
		items.setVisibility(false);
		background.setVisibility(true);
		floor.setVisibility(true);
		player.setVisibility(true);
		if (enemy.isDead == false) {
			enemy.setVisibility(true);
		}
		canMove = true;
	}

	public static void changeTimer() {
		thousandths++;
		if (thousandths == 10) {
			thousandths = 0;
			hundredths++;
		}
		if (hundredths == 10) {
			hundredths = 0;
			tenths++;
		}
		if (tenths == 10) {
			tenths = 0;
			ones++;
		}
		time = String.valueOf(ones) + "." + String.valueOf(tenths) + String.valueOf(hundredths)
				+ String.valueOf(thousandths);
		player.updateTimer();

	}

	public static void initializeVariables() throws InterruptedException {
		windowHandler = new WindowHandler("Game Main");
		player = new player(windowHandler.getWindowSize());
		floor = new floor();
		enemy = new enemy(25, 100);
		items = new items();
		healthBar = new healthBar(windowHandler.getWindowSize());
		statisBar = new statisBar(windowHandler.getWindowSize());
		leftOrRightBar = new leftOrRightBar(windowHandler.getWindowSize());
		background = new background(windowHandler.getWindowSize());
		floorItems = new floorItems();
		inventory = new gameInventory();
		windowHandler.add(items);
		items.setVisible(false);
		windowHandler.add(floorItems);
		floorItems.setVisible(false);
		windowHandler.add(inventory);
		inventory.setVisible(false);
		windowHandler.add(background);
		windowHandler.add(floor);
		windowHandler.add(player);
		windowHandler.add(enemy);
	}

	public static boolean isOutsideMap(JPanel a) {
		if (a.getX() + 50 < 0 || a.getX() > windowHandler.getWindowSize().getWidth() || (a.getY() + 100 < 0)
				|| a.getY() > windowHandler.getWindowSize().getHeight())
			return true;
		else
			return false;
	}
}