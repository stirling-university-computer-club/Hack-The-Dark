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


public class Start extends JPanel{

	private BufferedImage bg;
	
	final private float start_x = Main.SCREEN_WIDTH / 1.6f, start_y = Main.SCREEN_HEIGHT / 3.17f;
	final private float start_xx = Main.SCREEN_WIDTH / 1.28f, start_yy = Main.SCREEN_HEIGHT / 2.63f;
	
	final private float instructions_x = Main.SCREEN_WIDTH / 1.69f, instructions_y = Main.SCREEN_HEIGHT / 1.99f;
	final private float instructions_xx = Main.SCREEN_WIDTH / 1.11f, instructions_yy = Main.SCREEN_HEIGHT / 1.76f;

	final private float quit_x = Main.SCREEN_WIDTH / 1.79f, quit_y = Main.SCREEN_HEIGHT / 1.46f;
	final private float quit_xx = Main.SCREEN_WIDTH / 1.42f, quit_yy = Main.SCREEN_HEIGHT / 1.33f;
	
	public Start(final JFrame frame){
		System.out.println("start");
		
		try {                
	          bg = ImageIO.read(new File("assets/mainBg.gif"));
		} catch (IOException ex) {}
		
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				System.out.println("pressed " + x + "/" + y);
				
				// start
				if ((x > start_x) && (x < start_xx) && (y > start_y) && (y < start_yy)){
					Main.disposePanel(frame);
					Main.difficulty(frame);
				}
				
				// instructions
				if ((x > instructions_x) && (x < instructions_xx) && (y > instructions_y) && (y < instructions_yy)){
					Main.disposePanel(frame);
					Main.instructions(frame);
				}				
				// quit
				if ((x > quit_x) && (x < quit_xx) && (y > quit_y) && (y < quit_yy)){
					Main.exit(frame);
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
		g.drawString("[ Start ]", (int)(Main.SCREEN_WIDTH / 1.6), (int)(Main.SCREEN_HEIGHT / 2.7));
		g.drawString("[ Instructions ]", (int)(Main.SCREEN_WIDTH / 1.7), (int)(Main.SCREEN_HEIGHT / 1.8));
		g.drawString("[ Quit ]", (int)(Main.SCREEN_WIDTH / 1.8), (int)(Main.SCREEN_HEIGHT / 1.35));
	}
}
