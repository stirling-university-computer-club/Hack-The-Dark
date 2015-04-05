import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MiniBrowser{
		
	private JEditorPane display;
	
	
	//constructor
	public MiniBrowser(JPanel frame, int width, int height){
		display = new JEditorPane();
		loadCrap("assets/htmlout.html");
		display.setPreferredSize(new Dimension(width-10, height-10));
		display.setEditable(false);
		frame.add(new JScrollPane(display));
	}
	
	//load crap to display on the screen
	private void loadCrap(String fileName){
		try {
			File file = new File(fileName);
			File filePath = file.getAbsoluteFile();
			display.setPage(filePath.toURI().toURL());
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
}