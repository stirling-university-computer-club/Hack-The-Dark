import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;


public class Editor extends JFrame implements ActionListener
{
	private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;
    private static final int AREA_ROWS = 15;
    private static final int AREA_COLUMNS = 30;
	
	private static JTextArea testEditor;
	private JButton tempButton;
	
	private static File currentFile;
	
	private static FileWriter out;
	
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
        testEditor.setText
        ("<!DOCTYPE html>\n"
        		+ "<html>\n"
        		+ "<head>\n"
        		+ "<style>\n"
        		+ "\n\n Your web style goes here \n"
        		+ "</style>\n"
        		+ "<title>Hack The Dark</title>\n"
        		+ "</head>\n"
        		+ "<body>\n"
        		+ "\n"
        		+ "Write your code here\n"
        		+ "\n"
        		+ "</body>\n"
        		+ "</html>");
        
        
        testEditor.setEditable(true);

        JScrollPane scrollPane = new JScrollPane(testEditor);
        window.add(scrollPane);
        
		tempButton = new JButton("THIS");
		tempButton.addActionListener(this);
		window.add(tempButton);
		}

	public static void Writer() throws FileNotFoundException
	{
		
		Object inputText = testEditor.getText();
		PrintStream ps = new PrintStream(new FileOutputStream("htmltest.html", true));
		ps.println(inputText);
		ps.close();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==tempButton)
		{ try {
			Editor.Writer();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} } 
		}
		
	}

