import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
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
		
		JLayeredPane lpane = new JLayeredPane();
		frame.setLayout(new BorderLayout());
		frame.add(lpane);
		lpane.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		
		Process backPanel = new Process(frame, s);
		backPanel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		backPanel.setOpaque(true);
		
		JPanel textPanel = new JPanel();
		new Editor(textPanel, 900, 555);
		textPanel.setBounds(40, 272, 900, 555);
		textPanel.setOpaque(true);
		
        lpane.add(backPanel, new Integer(0), 0);
        lpane.add(textPanel, new Integer(1), 0);
		
		//frame.getContentPane().add(new Process(frame, s));
        frame.setVisible(true);
        
	}
	public static void output(JFrame frame, int s){
		Editor.writer();
		
		JLayeredPane lpane = new JLayeredPane();
		frame.setLayout(new BorderLayout());
		frame.add(lpane);
		lpane.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		
		Output backPanel = new Output(frame, s);
		backPanel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		backPanel.setOpaque(true);
		
		JPanel browserPanel = new JPanel();
		new MiniBrowser(browserPanel, 900, 555);
		browserPanel.setBounds(40, 272, 900, 555);
		browserPanel.setOpaque(true);
		
		lpane.add(backPanel, new Integer(0), 0);
        lpane.add(browserPanel, new Integer(1), 0);
		
		frame.setVisible(true);
		
		/*
		JLayeredPane lpane = new JLayeredPane();
		frame.setLayout(new BorderLayout());
		frame.add(lpane);
		lpane.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		Output bgPane = new Output(frame, s);
		bgPane.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		bgPane.setOpaque(true);
		JPanel p = new JPanel();
		p.setBounds(40, 272, 900, 555);
		new MiniBrowser(p, 10, 10, 100, 100);
		p.setOpaque(true);
		lpane.add(bgPane, new Integer(0), 0);
		lpane.add(p, new Integer(1), 0);
		*/
        frame.setVisible(true);
	}
	
	public static void instructions(JFrame frame){
		frame.getContentPane().add(new Instructions(frame));
        frame.setVisible(true);
	}
	
	public static void disposePanel(JFrame frame){
		frame.getContentPane().removeAll();
	}

	public static void exit(JFrame frame){
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
}
