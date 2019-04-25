package NewGame;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class leftOrRightBar extends JLabel {
	private static int width;
	private static JLabel bar;
	private static String text = "Right";
	public static final int RIGHT = 2;
	public static final int LEFT = 1;
	public static int side = RIGHT;
	public static int prev;
	static JPanel contentPane = WindowHandler.contentPane;

	public leftOrRightBar(Dimension screenSize) {
		bar = new JLabel();
		width = (int) screenSize.getWidth();
		bar.setText(text);
		bar.setBounds(width - 350, 0, 100, 50);
		contentPane.add(bar);
		bar.setVisible(true);
	}

	public static void update() {
		if (enemy.xDistance < 0) {
			text = "Right";
			side = RIGHT;
		} else if (enemy.xDistance > 0) {
			text = "Left";
			side = RIGHT;
		}
		if (prev != side) {
			bar.setVisible(false);
			bar.setText(text);
			bar.setVisible(true);
			prev = side;
		}
	}

}
