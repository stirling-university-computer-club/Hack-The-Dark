import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Process extends JPanel{

	private BufferedImage bg, goal;
	
	private int selected;
	private int min, sec = 0;
	
	final private int start_x = 1455, start_y = 941;
	final private int start_xx = 1794, start_yy = 984;
	
	private Timer timer;
	
	public Process(final JFrame frame, int selected){
		System.out.println("process");

		this.selected = selected;
		String goalPath = "assets/";
		switch(selected){
		case 1:
			min = 15;
			goalPath += "easyMLH.gif";
			break;
		case 2:
			min = 15;
			goalPath += "mediumMLH.gif";
			break;
		case 3:
			min = 10;
			goalPath += "hardMLH.gif";
			break;
		default:
			break;
		}
		
		try {                
	          bg = ImageIO.read(new File("assets/bg.gif"));
	          goal = ImageIO.read(new File(goalPath));
		} catch (IOException ex) {}
			
		timer = new Timer();
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				// counts down seconds
				if (sec > 0) sec--;
				else if(min > 0) {
					min--;
					sec = 59;
				}
				else endProcess(frame);
				
				repaint();
			}			
		}, 0, 1000);
		
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				System.out.println("pressed " + x + "/" + y);
				
				// proceed with the game
				if ((x > start_x) && (x < start_xx) && (y > start_y) && (y < start_yy)){
					endProcess(frame);
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
		
		// draw timer
		g.setColor(new Color(0.6f, 0.6f, 0.6f, 1));
		g.setFont(new Font("Cambria", Font.PLAIN, Main.SCREEN_WIDTH / 35));
		String sMin = "", sSec = "";
		if(min < 10) sMin = "0" + min;
		else		 sMin = "" + min;
		if(sec < 10) sSec = "0" + sec;
		else		 sSec = "" + sec;
		g.drawString("Time left: " + sMin + ":" + sSec, 200, 100);
		
		g.drawString("Code Here: ", 200, 200);
		g.fillRect(40, 272, 900, 555);
		g.drawString("Goal: ", 1100, 200);
		g.drawImage(goal, 980, 272, 900, 555, null);
		
		// starting game
		g.drawString("[ Submit ]", 1450, 975);
	}
	
	public void endProcess(JFrame frame){
		timer.cancel();
		Main.disposePanel(frame);
		Main.output(frame, selected);
	}
}
