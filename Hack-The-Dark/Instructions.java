import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Instructions extends JPanel{
	private BufferedImage bg;
	
	public Instructions(JFrame frame){
		System.out.println("output");		
		
		try {                
	          bg = ImageIO.read(new File("assets/bg.gif"));
		} catch (IOException ex) {}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// draw background
		g.drawImage(bg, 0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT, null);
		
		g.setColor(new Color(0.6f, 0.6f, 0.6f, 1));

	}
}
