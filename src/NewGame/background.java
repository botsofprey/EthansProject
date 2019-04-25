package NewGame;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class background extends JPanel {
	private static int width;
	private static int height;
	static Dimension screenSize;
	static JPanel contentPane = WindowHandler.contentPane;
	static JPanel background;
	
	public background(Dimension screenSize) {
		height = (int) screenSize.getHeight();
		width = (int) screenSize.getWidth();
		background = new JPanel();
		background.setBounds(0, 0, width, height);
		background.setBackground(Color.WHITE);
		background.setVisible(true);
		contentPane.add(background);
		setFocusable(true);
	}
	
	public static void setVisibility(boolean visible) {
		background.setVisible(visible);
	}
}

