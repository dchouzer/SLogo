package viewer;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;

public class AggregateViewer extends JFrame {
  


	public AggregateViewer()
	    {
	        setTitle("sLogo");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JTextArea myCommands = new JTextArea(20,20);
			JTextArea myOutput = new JTextArea(20,20);
			TurtleViewer myGame = new TurtleViewer(); 
			TextViewerArea textView = new TextViewerArea(myCommands, myOutput);
	        UpperView myUpperView = new UpperView(textView, myGame);
	        TextInputArea myTextInput = new TextInputArea();
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
	       AggregateViewer view = new AggregateViewer();
	    }
	}
