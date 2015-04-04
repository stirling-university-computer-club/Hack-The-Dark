import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Editor extends JFrame implements ActionListener
{
	private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;
    private static final int AREA_ROWS = 20;
    private static final int AREA_COLUMNS = 30;
	
	protected JTextArea testEditor;
	
	protected JFileChooser fileChooser;
	protected File currentFile;
	
	public static void main(String[] args)
	{
		Editor frame = new Editor();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocation(300, 300);
		frame.createGUI();
		frame.setVisible(true);
	}
	
	public void createGUI()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );
        
        testEditor = new JTextArea(AREA_ROWS, AREA_COLUMNS);
        testEditor.setText("");
        testEditor.setEditable(true);

        JScrollPane scrollPane = new JScrollPane(testEditor);
        window.add(scrollPane);
        
        fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("."));
		}
		
			public void actionPerformed( ActionEvent e )
		    {
			if (e.getSource() == testEditor)
	        {
				FileWriter out;
				try {
				out = new FileWriter(new File ("htmloutput.html"));
	    			testEditor.write(out);
	    			out.close();
					}
				catch (IOException ex) {
		    	ex.printStackTrace();
		    	}
	        }

}
}
