import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Output extends JPanel{

	private BufferedImage bg, goal;
	private int selected;
	
	private int stars = 1;
	
	final private int start_x = 1500, start_y = 941;
	final private int start_xx = 1845, start_yy = 984;
		
	public Output(final JFrame frame, int s){
		System.out.println("output");		
		
		selected = s;
		
		String goalPath = "assets/";
		switch(selected){
		case 1:
			goalPath += "easyMLH.gif";
			break;
		case 2:
			goalPath += "mediumMLH.gif";
			break;
		case 3:
			goalPath += "hardMLH.gif";
			break;
		default:
			break;
		}
		
		try {                
	          bg = ImageIO.read(new File("assets/bg.gif"));
	          goal = ImageIO.read(new File(goalPath));
		} catch (IOException ex) {}
		
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				System.out.println("pressed " + x + "/" + y);
				// stars
				for (int i = 0; i < 5; i++){
					if ((x > 800 + i * 120) && (x < 900 + i * 120) && (y > 935) && (y < 975)){
						stars = i+1;
						repaint();
					}
				}
				if ((x > start_x) && (x < start_xx) && (y > start_y) && (y < start_yy)){
					Main.disposePanel(frame);
					Main.start(frame);
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// draw background
		g.drawImage(bg, 0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT, null);

		g.setColor(new Color(0.6f, 0.6f, 0.6f, 1));
		g.setFont(new Font("Cambria", Font.PLAIN, Main.SCREEN_WIDTH / 35));
		g.drawString("Here is your output!", 200, 100);
		g.fillRect(40, 272, 900, 555);
		g.drawString("Goal: ", 1100, 200);
		g.drawImage(goal, 980, 272, 900, 555, null);

		g.drawString("Evaluate yourself!", 200, 975);
		
		for (int i = 0; i < 5; i++){
			
			if (i < stars)
				g.setColor(new Color(0.84f,0.84f,0.41f,1));
			else
				g.setColor(new Color(0.6f, 0.6f, 0.6f, 1));
			
			g.drawString("<*>", 800 + i * 120, 975);
		}
		// play again
		g.setColor(new Color(0.6f, 0.6f, 0.6f, 1));
		g.drawString("[ Play again ]", 1500, 975);
	}
}
