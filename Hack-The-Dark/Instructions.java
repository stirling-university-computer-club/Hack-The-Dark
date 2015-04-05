import java.awt.Color;
import java.awt.Font;
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
		
		float i = Main.SCREEN_HEIGHT/21.6f;
		
		g.setColor(new Color(0.6f, 0.6f, 0.6f, 1));
		g.setFont(new Font("Cambria", Font.PLAIN, Main.SCREEN_WIDTH / 50));
		g.drawString("INSTRUCTIONS", (int)(Main.SCREEN_WIDTH/2-Main.SCREEN_WIDTH/12.8f), (int) (Main.SCREEN_HEIGHT/5.4f));
		g.drawString("Welcome to a brand new, still hot from the coding game which will", Main.SCREEN_WIDTH/7, Main.SCREEN_HEIGHT/3);
		g.drawString("not only let you to feel the horrors provided by MLH & Bloomberg", Main.SCREEN_WIDTH/7, (int) (Main.SCREEN_HEIGHT/3+i));
		g.drawString("while attending the \"Code in the dark\" event, but also inevitably make", Main.SCREEN_WIDTH/7, (int) (Main.SCREEN_HEIGHT/3+i*2));
		g.drawString("you to get a superb experience and win their outstanding prizes!", Main.SCREEN_WIDTH/7, (int) (Main.SCREEN_HEIGHT/3+i*3));
		
		g.drawString("The basic idea of this game is that you get a picture of a website and", Main.SCREEN_WIDTH/7, (int) (Main.SCREEN_HEIGHT/3+i*5));
		g.drawString("you will have to write a code for a webpage that would look as similar", Main.SCREEN_WIDTH/7, (int) (Main.SCREEN_HEIGHT/3+i*6));
		g.drawString("as possible in appearance to the provided one until the time runs out.", Main.SCREEN_WIDTH/7, (int) (Main.SCREEN_HEIGHT/3+i*7));
		g.drawString("You can only use HTML5 and internal CSS and no web browsing is", Main.SCREEN_WIDTH/7, (int) (Main.SCREEN_HEIGHT/3+i*8));
		g.drawString("allowed, which means no code compiling as well. In case you are super", Main.SCREEN_WIDTH/7, (int) (Main.SCREEN_HEIGHT/3+i*9));
		g.drawString("fast, you can press the \"Submit\" button after you finish writing the code.", Main.SCREEN_WIDTH/7, (int) (Main.SCREEN_HEIGHT/3+i*10));
		g.drawString("Good Luck!", (int)(Main.SCREEN_WIDTH/2-Main.SCREEN_WIDTH/17.45f), (int) (Main.SCREEN_HEIGHT/3+i*11));
	}
}
