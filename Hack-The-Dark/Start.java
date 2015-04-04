import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Start extends JPanel{

	private BufferedImage bg;
	
	public Start(){
		try {                
	          bg = ImageIO.read(new File("assets/mainBg.gif"));
		} catch (IOException ex) {	}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(0, 0, 500, 500);
		g.drawImage(bg, 0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT, null);
	}
}
