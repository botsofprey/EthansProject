package NewGame;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class statisBar {
	private static JLabel bar = new JLabel();
	public static int[] statis = player.currentColors;
	private static int[] prev = new int[statis.length];
	static JPanel contentPane = WindowHandler.contentPane;

	public statisBar(Dimension screenSize) {
		bar.setBounds((int) (screenSize.getWidth() - 250), 0, 150, 50);
		bar.setText("standingColors");
		contentPane.add(bar);
		bar.setVisible(true);
	}

	public static String findText() {
		if (statis == player.standingColors)
			return "standingColors";
		else if (statis == player.movingLeftColors)
			return "movingLeftColors";
		else if (statis == player.movingRightColors)
			return "movingRightColors";
		else if (statis == player.movingLeftShieldLeft)
			return "movingLeftShieldLeft";
		else if (statis == player.movingLeftShieldRight)
			return "movingLeftShieldRight";
		else if (statis == player.movingLeftSwordLeft)
			return "movingLeftSwordLeft";
		else if (statis == player.movingLeftSwordRight)
			return "movingLeftSwordRight";
		else if (statis == player.movingRightShieldLeft)
			return "movingRightShieldLeft";
		else if (statis == player.movingRightShieldRight)
			return "movingRightShieldRight";
		else if (statis == player.movingRightSwordLeft)
			return "movingRightSwordLeft";
		else if (statis == player.movingRightSwordRight)
			return "movingRightSwordRight";
		else if (statis == player.shieldLeft)
			return "shieldLeft";
		else if (statis == player.shieldRight)
			return "shieldRight";
		else if (statis == player.swordLeft)
			return "swordLeft";
		else if (statis == player.swordRight)
			return "swordRight";
		else
			return null;

	}

	public static void update() {
			statis = player.currentColors;
		if (prev != statis) {
			bar.setVisible(false);
			bar.setText(findText());
			bar.setVisible(true);
			prev = statis;
		}
	}

}
