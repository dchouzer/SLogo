package viewer;

/*
 * @author Kat Krieger
 * @author David Chou
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;

import controller.Controller;



public class MenuBar extends JMenuBar {
	HashMap<String,String> colors;
	Controller myController;
	public MenuBar(Controller controller) {
		myController = controller;
		colors = new HashMap<String, String>();
		createMaps();
		this.add(createColorMenu());
		this.add(createHelpMenu());

	}

	private JMenu createColorMenu(){
		JMenu menu = new JMenu("Choose Pen Color");
		menu.setMnemonic(KeyEvent.VK_A);
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem rbMenuItem;
		boolean defaultValue = true;
		for(final String color : colors.keySet()){
			rbMenuItem = new JRadioButtonMenuItem(color);
			rbMenuItem.setSelected(defaultValue);
			rbMenuItem.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed (ActionEvent e){
					try{
						myController.setPenColor(colors.get(color));
					}
					catch (Exception k) {
						
					}
				}
			});
			group.add(rbMenuItem);
			menu.add(rbMenuItem);
			defaultValue = false;
		}
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

	private void createMaps(){
		colors.put("Yellow", "Yellow");
		colors.put("Red", "Red");
		colors.put("Blue", "Blue");
		colors.put("Black", "Black");
	}
}
