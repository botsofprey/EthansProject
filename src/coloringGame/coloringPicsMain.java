package coloringGame;

import javax.swing.JPanel;
import NewGame.WindowHandler;

@SuppressWarnings("serial")
public class coloringPicsMain extends JPanel {
	static WindowHandler windowHandler;
	private static colorCanvas picture;
	public static boolean running = true;

	public static void main(String[] args) {
		windowHandler = new WindowHandler("Coloring");
		picture = new colorCanvas();
		windowHandler.add(picture);
		while (running) {
				colorCanvas.color(colorCanvas.pixels.get(colorCanvas.panel), colorCanvas.num, colorCanvas.panel);
				picture.requestFocus();
			}
		}
	}
