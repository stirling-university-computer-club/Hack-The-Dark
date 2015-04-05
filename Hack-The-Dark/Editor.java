import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;


public class Editor
{
	JFrame frame;
	private int FRAME_WIDTH;
	private int FRAME_HEIGHT;
	private int AREA_ROWS;
	private int AREA_COLUMNS;


	private static JTextArea testEditor;
	private JButton tempButton;

	public Editor(JFrame fram, int x, int y, int width, int height)
	{
		frame=fram;
		FRAME_WIDTH = width;
		FRAME_HEIGHT = height;
		AREA_ROWS = x;
		AREA_COLUMNS = y;
	}

	//	main
	// 	Editor editor = new Editor();
	//	frame.createGUI();
	public void createGUI()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container window = frame.getContentPane();
		window.setLayout(new FlowLayout() );

		testEditor = new JTextArea(AREA_ROWS, AREA_COLUMNS);
		testEditor.setText
		("<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "<style>\n"
				+ "\n Your web style goes here \n \n"
				+ "</style>\n"
				+ "<title>Hack The Dark</title>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "\n"
				+ "Write your code here\n"
				+ "\n"
				+ "</body>\n"
				+ "</html>");

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocation(AREA_ROWS, AREA_COLUMNS);
		frame.setVisible(true);
		testEditor.setEditable(true);

		JScrollPane scrollPane = new JScrollPane(testEditor);
		window.add(scrollPane);

	}
	public static void writer()
	{
		Object inputText = testEditor.getText();
		PrintStream ps;
		try {
			ps = new PrintStream(new FileOutputStream("htmltest.html", true));
			ps.println(inputText);
			ps.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
