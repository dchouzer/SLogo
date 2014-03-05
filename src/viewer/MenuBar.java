package viewer;

/*
 * @author Kat Krieger
 * @author David Chou
 */

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;


public class MenuBar extends JMenuBar {
	
	 public MenuBar() {
	        this.add(createColorMenu());
	        this.add(createHelpMenu());
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

}
