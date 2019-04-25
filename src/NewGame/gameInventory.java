package NewGame;

import java.awt.Color;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class gameInventory extends JPanel {
	public static boolean inInventory = false;
	static JPanel[][] rectangles = new JPanel[9][4];
	static JPanel contentPane = WindowHandler.contentPane;
	static int[] widths;
	static int[] heights;
	static items items;

	public gameInventory() {
		drawRectangles();
		for (int a = 0; a < rectangles.length; a++) {
			for (int b = 0; b < rectangles[a].length; b++) {
				rectangles[a][b].setBackground(Color.BLACK);
				rectangles[a][b].setLocation(rectangles[a][b].getX(), rectangles[a][b].getY() - 10);
				rectangles[a][b].setVisible(true);
				contentPane.add(rectangles[a][b]);
			}
		}
	}

	public void setVisibility(boolean visible) {
		for (int a = 0; a < rectangles.length; a++) {
			for (int b = 0; b < rectangles[a].length; b++) {
				rectangles[a][b].setVisible(visible);
			}
		}
	}

	private static void drawRectangles() {
		drawRectangle(20, 20, 480, 480, 0);
		drawRectangle(30, 30, 278, 354, 1);
		drawRectangle(318, 30, 172, 172, 2);
		drawRectangle(318, 212, 172, 172, 3);
		drawRectangle(30, 396, 92, 96, 4);
		drawRectangle(122, 396, 92, 96, 5);
		drawRectangle(214, 396, 92, 96, 6);
		drawRectangle(306, 396, 92, 96, 7);
		drawRectangle(398, 396, 92, 96, 8);
	}

	private static void drawRectangle(int x, int y, int width, int height, int num) {
		JPanel panel1 = new JPanel();
		panel1.setBounds(x, y, width, 4);
		rectangles[num][0] = panel1;
		JPanel panel2 = new JPanel();
		panel2.setBounds(x, y, 4, height);
		rectangles[num][1] = panel2;
		JPanel panel3 = new JPanel();
		panel3.setBounds(x, y + height, width, 4);
		rectangles[num][2] = panel3;
		JPanel panel4 = new JPanel();
		panel4.setBounds(x + width, y, 4, height + 4);
		rectangles[num][3] = panel4;
	}
}
