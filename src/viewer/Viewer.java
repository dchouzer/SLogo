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

/**
 * Demo program to show many of the awt events that can be generated.
 * 
 * Illustrates XXXListeners for consuming several types of events including
 * semantic events (e.g., ActionEvent) and low-level events (e.g., FocusEvent)
 * 
 * See this tutorial for help on how to use the variety of components:
 *   http://docs.oracle.com/javase/tutorial/uiswing/examples/components/
 * 
 * @author Owen Astrachan
 * @author Robert C. Duvall
 */
@SuppressWarnings("serial")
public class Viewer extends JFrame {
   
	
	
	private static final String USER_DIR = "user.dir";


	public Viewer()
	    {
	        setTitle("sLogo");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JTextArea myCommands = new JTextArea(20,20);
			JTextArea myOutput = new JTextArea(20,20);
			TextView textView = new TextView(new JScrollPane(), new JScrollPane(), myCommands, myOutput);
	        TextInput myTextInput = new TextInput();
	        SLogoView myGame = new SLogoView(); 
            getContentPane().add(textView, BorderLayout.WEST);
	        getContentPane().add(myTextInput, BorderLayout.SOUTH);
	        getContentPane().add(myGame, BorderLayout.CENTER);
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
