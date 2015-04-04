import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;

public class MiniBrowser{
	
	private JFrame frame;
	
	private JEditorPane display;
	
	//constructor
	public MiniBrowser(JFrame fram){
		frame = fram;
		loadCrap("   URL AS A STRING   ");
		display = new JEditorPane();
		display.setEditable(false);
		frame.add(new JScrollPane(display), BorderLayout.CENTER);
	}
	
	//load crap to display on the screen
	private void loadCrap(String fileName){
		try {
			display.setPage(fileName);
		} catch (IOException e) {
			System.out.println("crap!");
		}
	}
}