package NewGame;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class healthBar extends JLabel {
	public static int health = player.health;
	static JPanel contentPane = WindowHandler.contentPane;
	static JLabel bar = new JLabel();
	
	public healthBar (Dimension screenSize) {
		bar.setText(String.valueOf(health));
		bar.setBounds((int) (screenSize.getWidth() - 100), 0, 50, 50);
		contentPane.add(bar);
		bar.setVisible(true);
	}
	
	public static void update() {
		bar.setVisible(false);
		bar.setText(String.valueOf(health));
		bar.setVisible(true);
	}

}
