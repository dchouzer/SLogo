package viewer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ResourceBundle;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Viewer extends JFrame {
  


	public Viewer()
	    {
	        setTitle("sLogo");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JTextArea myCommands = new JTextArea(20,20);
			JTextArea myOutput = new JTextArea(20,20);
			SLogoView myGame = new SLogoView(); 
			TextView textView = new TextView(myCommands, myOutput);
	        UpperView myUpperView = new UpperView(textView, myGame);
	        TextInput myTextInput = new TextInput();
	        FullView fullView = new FullView(myTextInput, myUpperView);
	        getContentPane().add(fullView, BorderLayout.CENTER);
	        setJMenuBar(createMenuBar());
	        pack();
	        setVisible(true);
	       
	}
		
	
	 private JMenuBar createMenuBar() {
	        JMenuBar menuBar = new JMenuBar();
	        menuBar.add(createColorMenu());
	        menuBar.add(createHelpMenu());
	        return menuBar;
	    }
	 private JMenu createColorMenu(){
		 	JMenu menu = new JMenu("Choose Pen Color");
	        menu.setMnemonic(KeyEvent.VK_A);
	        ButtonGroup group = new ButtonGroup();
	        JRadioButtonMenuItem rbMenuItem;
	        rbMenuItem = new JRadioButtonMenuItem("Yellow");
	        rbMenuItem.setSelected(true);
	        rbMenuItem.setMnemonic(KeyEvent.VK_Y);
	        group.add(rbMenuItem);
	        menu.add(rbMenuItem);
	        rbMenuItem = new JRadioButtonMenuItem("Black");
	        rbMenuItem.setMnemonic(KeyEvent.VK_K);
	        group.add(rbMenuItem);
	        menu.add(rbMenuItem);
	        rbMenuItem = new JRadioButtonMenuItem("Blue");
	        rbMenuItem.setMnemonic(KeyEvent.VK_B);
	        group.add(rbMenuItem);
	        menu.add(rbMenuItem);
	        rbMenuItem = new JRadioButtonMenuItem("Red");
	        rbMenuItem.setMnemonic(KeyEvent.VK_R);
	        group.add(rbMenuItem);
	        menu.add(rbMenuItem);
	        return menu;
	 }
	 
	 private JMenu createHelpMenu(){
		 JMenu menu = new JMenu("Help");
		 menu.add(new AbstractAction("helpcommand") {
	            public void actionPerformed (ActionEvent e) {
	            	String helpSite = "http://www.cs.duke.edu/courses/compsci308/current/assign/03_slogo/commands.php";
					try {
						URI location = new java.net.URI(helpSite);
						try {
							java.awt.Desktop.getDesktop().browse(location);
						} 
						catch (IOException e1) {
							e1.printStackTrace();
						}
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
	            }}); 
		 
		 return menu;
	 }
	 
	 
	 
	 public static void main(String[] args) {
	       Viewer view = new Viewer();
	    }
	}
