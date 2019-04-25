package NewGame;

import java.util.ArrayList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class floor extends JPanel {
	private static int slope;
	private static double y;
	public static int levelNumber = 0;
	public static int[][] floorX = new int[][] { { 0, 200, 400, 600, 800 }, { 5 } };
	public static int[][] floorY = new int[][] { { 300, 350, 400, 450, 500 }, { 5 } };
	public static int[][] floorWidth = new int[][] { { 150, 150, 150, 150, 150 }, { 5 } };
	public static int[][] floorHeight = new int[][] { { 5, 5, 5, 5, 5 }, { 5 } };
	public static ArrayList<JPanel> floors = new ArrayList<JPanel>();
	public static ArrayList<JPanel> line = new ArrayList<JPanel>();
	static JPanel contentPane = WindowHandler.contentPane;
	static ArrayList<ArrayList<JPanel>> lines = new ArrayList<ArrayList<JPanel>>();
	static WindowHandler windowHandler;

	public floor() {
		for (int k = 0; k < floorX[0].length; k++) {
			JPanel floor = new JPanel();
			floor.setBounds(floorX[0][k], floorY[0][k], floorWidth[0][k], floorHeight[0][k]);
			contentPane.add(floor);
			floors.add(floor);
			floor.setBackground(player.DARK_GREEN);
			floor.setVisible(true);
			setFocusable(true);
		}
//		for (int k = 0; k < 4; k++) {
//			drawLine((floorX[k] + floorWidth[k]), floorY[k], floorX[k + 1], floorY[k + 1]);
//		}
	}

	public static void nextLevel(int level) {
		setVisibility(false);
		levelNumber++;
		setVisibility(true);
	}

	public static void setVisibility(boolean visible) {
		for (int a = 0; a < floors.size(); a++) {
			floors.get(a).setLocation(floorX[levelNumber][a], floorY[levelNumber][a]);
			floors.get(a).setVisible(visible);
		}
	}

	@SuppressWarnings("unused")
	private static void drawLine(int x1, int y1, int x2, int y2) {
		slope = ((y2 - y1) / (x2 - x1));
		for (int x = x1; x <= x2; x++) {
			JPanel point = new JPanel();
			y = ((slope) * (x - x1)) + y1;
			point.setBounds(x, (int) y, 5, 5);
			point.setBackground(player.DARK_GREEN);
			point.setVisible(true);
			line.add(point);
			contentPane.add(point);
		}
		lines.add(line);

	}
}