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
		JFrame f = new JFrame("Hack The Code");
		f.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start(f);
        f.setVisible(true);
	}
	
	public static void start(JFrame frame){
		frame.getContentPane().add(new Start());
	}
	public static void difficulty(JFrame frame){
		frame.getContentPane().add(new Difficulty());
	}
	public static void process(JFrame frame){
		frame.getContentPane().add(new Process());
	}
	public static void output(JFrame frame){
		frame.getContentPane().add(new Output());
	}
	
	public static void disposePanel(JFrame frame){
		frame.getContentPane().removeAll();
	}

}
