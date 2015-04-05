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
		
		g.setColor(new Color(0.6f, 0.6f, 0.6f, 1));
		g.setFont(new Font("Cambria", Font.PLAIN, Main.SCREEN_WIDTH / 40));
		g.drawString("INSTRUCTIONS", 1920/2-150, 200);
		g.drawString("Welcome to a brand new, still hot from the coding game which will", 1920/7, 1080/3);
		g.drawString("not only let you to feel the horrors provided by MLH & Bloomberg", 1920/7, 1080/3+50);
		g.drawString("while attending the \"Code in the dark\" event, but also inevitably make", 1920/7, 1080/3+100);
		g.drawString("you to get a superb experience and win their outstanding prizes!", 1920/7, 1080/3+150);
		
		g.drawString("The basic idea of this game is that you get a picture of a website and", 1920/7, 1080/3+250);
		g.drawString("you will have to write a code for a webpage that would look as similar", 1920/7, 1080/3+300);
		g.drawString("as possible in appearance to the provided one until the time runs out.", 1920/7, 1080/3+350);
		g.drawString("You can only use HTML5 and internal CSS and no web browsing is", 1920/7, 1080/3+400);
		g.drawString("allowed, which means no code compiling as well. In case you are super", 1920/7, 1080/3+450);
		g.drawString("fast, you can press the \"Submit\" button after you finish writing the code.", 1920/7, 1080/3+500);
		g.drawString("Good Luck!", 1920/2-110, 1080/3+550);
	}
}
