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
	private String evaluation = "Here is your output!";
	
	final private int start_x = (int) (Main.SCREEN_WIDTH / 1.32f), start_y = (int) (Main.SCREEN_HEIGHT / 1.15f);
	final private int start_xx = (int) (Main.SCREEN_WIDTH / 1.1f), start_yy = (int) (Main.SCREEN_HEIGHT / 1.1f);
	
	final private int starssX = (int) (Main.SCREEN_WIDTH / 2.4f), starssAddX = (int) (Main.SCREEN_WIDTH / 16), starssY = (int) (Main.SCREEN_HEIGHT / 1.11f);
	
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
					if ((x > starssX + i * starssAddX) && (x < starssX + (int) (Main.SCREEN_WIDTH / 19.2f) + i * starssAddX) && (y > (Main.SCREEN_HEIGHT / 1.15f)) && (y < starssY)){
						stars = i+1;
						switch (stars - 1) {
						case 0:
							evaluation = "Better luck next time!";
							break;
						case 1:
							evaluation = "I know you can do it don't let you're hopes down!";							
							break;
						case 2:
							evaluation = "Halfway through, well done!";
							break;
						case 3:
							evaluation = "Just a few more steps and you will reach the top!";
							break;
						case 4:
							evaluation = "Congratulations, I knew you were the best!";
							break;
						}
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
		g.drawString(evaluation, (int) (Main.SCREEN_WIDTH / 9.6f), (int) (Main.SCREEN_HEIGHT/13f));
		g.drawString("Goal: ", (int) (Main.SCREEN_WIDTH / 1.75f), (int) (Main.SCREEN_HEIGHT/5.4f));
		g.drawImage(goal, (int) (Main.SCREEN_WIDTH / 1.96f), (int) (Main.SCREEN_HEIGHT/3.97f), (int) (Main.SCREEN_WIDTH / 2.13f), (int) (Main.SCREEN_HEIGHT/1.95f), null);

		g.drawString("Evaluate yourself!", (int) (Main.SCREEN_WIDTH / 9.6f), starssY);
		
		for (int i = 0; i < 5; i++){
			
			if (i < stars)
				g.setColor(new Color(0.84f,0.84f,0.41f,1));
			else
				g.setColor(new Color(0.6f, 0.6f, 0.6f, 1));
			
			g.drawString("<*>", starssX + i * starssAddX, starssY);
		}
		// play again
		g.setColor(new Color(0.6f, 0.6f, 0.6f, 1));
		g.drawString("[ Play again ]", (int) (Main.SCREEN_WIDTH / 1.28f), starssY);
	}
}
