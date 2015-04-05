import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Process extends JPanel{

	private BufferedImage bg;
	
	private int selected;
	private int min, sec = 0;
	
	public Process(final JFrame frame, int selected){
		System.out.println("process");
		
		try {                
	          bg = ImageIO.read(new File("assets/bg.gif"));
		} catch (IOException ex) {}
	
		this.selected = selected;
		switch(selected){
		case 1:
			min = 15;
			break;
		case 2:
			min = 15;
			break;
		case 3:
			min = 10;
			break;
		default:
			break;
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// draw background
		g.drawImage(bg, 0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT, null);
		
		// draw timer
		g.setColor(new Color(0.6f, 0.6f, 0.6f, 1));
		g.setFont(new Font("Cambria", Font.PLAIN, Main.SCREEN_WIDTH / 35));
		String sMin = "", sSec = "";
		if(min < 10) sMin = "0" + min;
		else		 sMin = "" + min;
		if(sec < 10) sSec = "0" + sec;
		else		 sSec = "" + sec;
		g.drawString("Time left: " + sMin + ":" + sSec, 200, 100);
		
	}
}
