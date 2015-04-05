import java.awt.BorderLayout;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
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
        f.setUndecorated(true);
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
		new Editor(textPanel, (int) (SCREEN_WIDTH/2.13), (int) (SCREEN_HEIGHT/1.95f));
		textPanel.setBounds((int) (SCREEN_WIDTH/48), (int) (SCREEN_HEIGHT/3.97f), (int) (SCREEN_WIDTH/2.13), (int) (SCREEN_HEIGHT/1.95f));
		textPanel.setOpaque(true);
		
        lpane.add(backPanel, new Integer(0), 0);
        lpane.add(textPanel, new Integer(1), 0);

        frame.setAlwaysOnTop(true); 
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
		new MiniBrowser(browserPanel, (int) (SCREEN_WIDTH/2.13), (int) (SCREEN_HEIGHT/1.95f));
		browserPanel.setBounds((int) (SCREEN_WIDTH/48), (int) (SCREEN_HEIGHT/3.97f), (int) (SCREEN_WIDTH/2.13), (int) (SCREEN_HEIGHT/1.95f));
		browserPanel.setOpaque(true);
		
		lpane.add(backPanel, new Integer(0), 0);
        lpane.add(browserPanel, new Integer(1), 0);
		
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
	}/*
	 /**
     * Method allows changing whether this window is displayed in fullscreen or
     * windowed mode.
     * @param fullscreen true = change to fullscreen,
     *                   false = change to windowed
     */
	/*
    public void setFullscreen( boolean fullscreen, JFrame frame )
    {
        //get a reference to the device.
        GraphicsDevice device  = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        DisplayMode dispMode = device.getDisplayMode();
        //save the old display mode before changing it.
        DisplayMode dispModeOld = device.getDisplayMode();

        if( frame.fullscreen != fullscreen )
        { //are we actually changing modes.
            //change modes.
        	frame.fullscreen = fullscreen;
            // toggle fullscreen mode
            if( !fullscreen )
            {
                //change to windowed mode.
                //set the display mode back to the what it was when
                //the program was launched.
                device.setDisplayMode(dispModeOld);
                //hide the frame so we can change it.
                frame.setVisible(false);
                //remove the frame from being displayable.
                frame.dispose();
                //put the borders back on the frame.
                frame.setUndecorated(false);
                //needed to unset this window as the fullscreen window.
                device.setFullScreenWindow(null);
                //recenter window
                frame.setLocationRelativeTo(null);
                frame.setResizable(true);

                //reset the display mode to what it was before
                //we changed it.
                frame.setVisible(true);

            }
            else
            { //change to fullscreen.
                //hide everything
            	frame.setVisible(false);
                //remove the frame from being displayable.
            	frame.dispose();
                //remove borders around the frame
            	frame.setUndecorated(true);
                //make the window fullscreen.
                device.setFullScreenWindow(this);
                //attempt to change the screen resolution.
                device.setDisplayMode(dispMode);
                frame.setResizable(false);
                frame.setAlwaysOnTop(false);
                //show the frame
                frame.setVisible(true);
            }
            //make sure that the screen is refreshed.
            frame.repaint();
        }
    }*/
}
