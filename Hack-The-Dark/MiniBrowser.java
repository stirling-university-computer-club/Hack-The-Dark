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
		loadCrap("file:///C:/Users/Martynas/git/Hack-The-Dark2/try.htm");
		JScrollPane scroll = new JScrollPane(display);
		scroll.setLocation(x, y);
		scroll.setSize(width, height);
		display.setLocation(x, y);
		display.setSize(width, height);
		display.setEditable(false);
		frame.add(scroll);
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