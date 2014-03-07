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
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;

import model.Turtle;
import controller.Controller;



public class MenuBar extends JMenuBar {
	HashMap<String,String> colors;
	HashMap<String,String> turtles;
	Controller myController;
	Turtle myTurtle;
	public MenuBar(Controller controller) {
		myController = controller;
		colors = new HashMap<String, String>();
		turtles = new HashMap<String, String>();
		createMaps();
		this.add(createFileMenu());
		this.add(createTurtleImageMenu());
		this.add(createBackgroundMenu());
		this.add(createColorMenu());
		this.add(createHelpMenu());

	}

	private JMenu createFileMenu(){
		JMenu menu = new JMenu("File");
		//Add save button
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e){
				try{
					myController.saveCommandsToFile();
				}
				catch (Exception k) {
					
				}
			}
		});
		menu.add(saveButton);
		//Add load button
		JButton loadButton = new JButton("Load");
		loadButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed (ActionEvent e){
				try{
					myController.loadCommandsToText();
				}
				catch (Exception k) {
					
				}
			}
		});
		menu.add(loadButton);
		return menu;
	}
	
	private JMenu createBackgroundMenu(){
		JMenu menu = new JMenu("Choose Background Color");
		
		return menu;
	}
	
	private JMenu createTurtleImageMenu(){
		JMenu menu = new JMenu("Choose Turtle Image");
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem rbMenuItem;
		boolean defaultValue = true;
		for(final String turtle : turtles.keySet()){
			rbMenuItem = new JRadioButtonMenuItem(turtle);
			rbMenuItem.setSelected(defaultValue);
			rbMenuItem.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed (ActionEvent e){
					try{
						myController.setTurtleImage(turtles.get(turtle));
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
	
	private JMenu createColorMenu(){
		JMenu menu = new JMenu("Choose Pen Color");
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
		turtles.put("Default Turtle", "turtle.gif");
		turtles.put("Color Turtle", "colorTurtle.gif");

	}
}
