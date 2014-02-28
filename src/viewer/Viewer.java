package viewer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
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
	        JMenuBar menuBar;
	        JMenu menu, submenu;
	        JMenuItem menuItem;
	        JRadioButtonMenuItem rbMenuItem;
	 
	        //Create the menu bar.
	        menuBar = new JMenuBar();
	        menu = new JMenu("Choose Pen Color");
	        menu.setMnemonic(KeyEvent.VK_A);
	        menuBar.add(menu);
	        ButtonGroup group = new ButtonGroup();
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
	 
	        return menuBar;
	    }

	 
	 
	 public static void main(String[] args) {
	       Viewer view = new Viewer();
	    }
	}