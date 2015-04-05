import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Main {
	
	final public static int SCREEN_WIDTH  = Toolkit.getDefaultToolkit().getScreenSize().width,
							   SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	setUpFrame(); 
            }
        });
	}
	
	private static void setUpFrame(){
		JFrame f = new JFrame("Hack The Dark");
		f.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start(f);        
	}
	
	public static void start(JFrame frame){
		frame.getContentPane().add(new Start(frame));
        frame.setVisible(true);
	}
	public static void difficulty(JFrame frame){
		frame.getContentPane().add(new Difficulty(frame));
        frame.setVisible(true);
	}
	public static void process(JFrame frame, int s){
		frame.getContentPane().add(new Process(frame, s));
        frame.setVisible(true);
	}
	public static void output(JFrame frame){
		frame.getContentPane().add(new Output());
        frame.setVisible(true);
	}
	
	public static void disposePanel(JFrame frame){
		frame.getContentPane().removeAll();
	}

}
