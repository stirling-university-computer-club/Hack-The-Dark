import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;

public class MiniBrowser{
	
	private Start frame;
	
	private JEditorPane display;
	
	//constructor
	public MiniBrowser(Start fram, int x, int y, int width, int height){
		frame = fram;
		display = new JEditorPane();
		display.setSize(width, height);
		display.setLocation(x, y);
		loadCrap("file:///C:/Users/Martynas/git/Hack-The-Dark2/try.htm");
		display.setEditable(false);
		frame.add(new JScrollPane(display));
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