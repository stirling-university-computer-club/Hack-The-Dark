import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Start extends JPanel{

	private BufferedImage image;
	
	public Start(){
		try {                
	          image = ImageIO.read(new File("assets/mainBg.gif"));
       } catch (IOException ex) {
            System.out.println("fail");
       }
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(0, 0, 500, 500);
		g.drawImage(image, 0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT, null);
	}
}
