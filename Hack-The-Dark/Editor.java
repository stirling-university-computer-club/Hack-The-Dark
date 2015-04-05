import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Editor
{
	private static JTextArea testEditor;

	public Editor(JPanel panel, int width, int height)
	{
		testEditor = new JTextArea();
		testEditor.setPreferredSize(new Dimension(width-10, height-10));
		testEditor.setText
		("<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "<style>\n"
				+ "\n<!-- Your web style goes here --> \n \n"
				+ "</style>\n"
				+ "<title>Hack The Dark</title>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "\n"
				+ "<!-- Write your code here -->\n"
				+ "\n"
				+ "</body>\n"
				+ "</html>");

		testEditor.setEditable(true);

		//JScrollPane scrollPane = new JScrollPane(testEditor);
		panel.add(new JScrollPane(testEditor));

	}
	public static void writer()
	{
		Object inputText = testEditor.getText();
		PrintStream ps;
		try {
			ps = new PrintStream(new FileOutputStream("assets/htmlout.html", false));
			ps.println(inputText);
			ps.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
