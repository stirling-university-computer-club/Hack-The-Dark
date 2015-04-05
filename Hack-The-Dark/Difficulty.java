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


public class Difficulty extends JPanel{

	private BufferedImage bg;

	private BufferedImage easyMLH, mediumMLH, hardMLH;
	final private int size_x = 600, size_y = 370; 
	final private int easy_x = 40, easy_y = 300, medium_x = 660, medium_y = 300, hard_x = 1280, hard_y = 300;
	
	final private int start_x = 1455, start_y = 941;
	final private int start_xx = 1794, start_yy = 984;
	
	private int selected = 1; 
	
	public Difficulty(final JFrame frame){
		System.out.println("difficulty");
		
		try {                
	          bg = ImageIO.read(new File("assets/bg.gif"));
	          easyMLH = ImageIO.read(new File("assets/easyMLH.gif"));
	          mediumMLH = ImageIO.read(new File("assets/mediumMLH.gif"));
	          hardMLH = ImageIO.read(new File("assets/hardMLH.gif"));
		} catch (IOException ex) {}
		
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				System.out.println("pressed " + x + "/" + y);
				
				// select easy
				if ((x > easy_x) && (x < easy_x + size_x) && (y > easy_y) && (y < easy_y + size_y)){
					selected = 1;
					repaint();
				}				
				// select medium
				if ((x > medium_x) && (x < medium_x + size_x) && (y > medium_y) && (y < medium_y + size_y)){
					selected = 2;
					repaint();
				}				
				// select hard
				if ((x > hard_x) && (x < hard_x + size_x) && (y > hard_y) && (y < hard_y + size_y)){
					selected = 3;
					repaint();
				}
				// proceed with the game
				if ((x > start_x) && (x < start_xx) && (y > start_y) && (y < start_yy)){
					Main.disposePanel(frame);
					Main.process(frame, selected);
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
		g.setFont(new Font("Cambria", Font.PLAIN, Main.SCREEN_WIDTH / 24));
		g.drawString("Choose a design you wish to hack:", 200, 100);

		// difficulty
		g.setFont(new Font("Cambria", Font.PLAIN, Main.SCREEN_WIDTH / 35));
		g.drawString("Easy", 250, 250);
		g.drawString("Medium", 850, 250);
		g.drawString("Hard", 1490, 250);
		
		// time
		g.setFont(new Font("Cambria", Font.PLAIN, Main.SCREEN_WIDTH / 40));
		g.drawString("15 min", 250, 750);
		g.drawString("15 min", 850, 750);
		g.drawString("10 min", 1490, 750);
		
		// designs
		g.drawImage(easyMLH, easy_x, easy_y, size_x, size_y, null);
		g.drawImage(mediumMLH, medium_x, medium_y, size_x, size_y, null);
		g.drawImage(hardMLH, hard_x, hard_y, size_x, size_y, null);
		
		// stroking selected design
		stroke(g, 10);
		
		// starting game
		g.drawString("[ Start Game ]", 1450, 975);
	}
	
	public void stroke(Graphics g, int strength) {
		int x = 0, y = 0;
		switch(selected){
		case 1:
			x = easy_x;
			y = easy_y;
			break;
		case 2:
			x = medium_x;
			y = medium_y;			
			break;
		case 3:
			x = hard_x;
			y = hard_y;
			break;
		default:
			break;
		}
		
		for (int i = 0; i < strength; i++){
			g.drawRect(x, y, size_x - i * 2, size_y - i * 2);
			x++;
			y++;
		}
		
	}

}
