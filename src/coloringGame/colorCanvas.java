package coloringGame;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JPanel;
import NewGame.WindowHandler;
import NewGame.player;

@SuppressWarnings("serial")
public class colorCanvas extends JPanel {
	private static int[] newX = new int[23456789];
	private static int[] newY = new int[2345678];
	private static int a = 0;
	private static int b = 50;
	private static int numOfColors = 7;
	private static int yPixels = 10;
	private static int xPixels = 5;
	public static int color = 0;
	public static Color[] colors = new Color[] { Color.BLACK, Color.WHITE, player.SILVER, player.BROWN, Color.RED,
			Color.BLUE, player.DARK_GREEN, player.LIGHT_BROWN };
	public static Color[] pixelColors = new Color[b];
	public static int[] pixelnums = new int[b];
	public static int num = 0;
	public static int panel = 0;
	public static ArrayList<JPanel> pixels = new ArrayList<JPanel>();
	Scanner input = new Scanner(System.in);
	Controller controller = new Controller();
	JPanel contentPane = WindowHandler.contentPane;

	public colorCanvas() {
		addKeyListener(controller);
		for (int y = 0; y < yPixels; y++) {
			for (int x = 0; x < xPixels; x++) {
				newX[a] = (x * 50);
				newY[a] = (y * 50);
				a++;
			}
		}
		for (int q = 0; q < b; q++) {
			JPanel pixel = new JPanel();
			pixel.setBounds(newX[q], newY[q], 50, 50);
			pixel.setBackground(Color.WHITE);
			contentPane.add(pixel);
			pixels.add(pixel);
			pixels.get(q).setVisible(true);
			pixels.get(q).repaint();
		}
		setFocusable(true);
	}

	public static void color(JPanel p, int num, int panel) {
		p.setBackground(colors[num]);
		pixelColors[panel] = colors[num];
		pixelnums[panel] = num;
	}

	public class Controller implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			switch (arg0.getKeyCode()) {
			case KeyEvent.VK_SPACE:
				if (num == numOfColors) {
					num = 0;
				} else {
					num++;
				}
				break;
			case KeyEvent.VK_BACK_SPACE:
				panel--;
				break;
			case KeyEvent.VK_ENTER:
				panel++;
				if (panel == b) {
					panel = 0;
					for (int i = 0; i < b; i++) {
						System.out.print(pixelnums[i] + ",");
					}
					coloringPicsMain.running = false;
				}
				num = pixelnums[panel];
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}
}