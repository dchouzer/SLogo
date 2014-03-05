package viewer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;

import model.Turtle;

import controller.Controller;

public class AggregateViewer extends JFrame {
  
	private Controller myController;
	private Dimension TOTAL_SIZE = new Dimension(1200,800);
	
	private Dimension TURTLE_SIZE = new Dimension(800,600);
	private Dimension TEXT_OUTPUT_SIZE = new Dimension(400,250);
	private Dimension PROGRAM_INPUT_SIZE = new Dimension(800,300);
	private Dimension COMPUTATION_SIZE = new Dimension(400,250);
	
	private Turtle myTurtle;
	
	
	
	
	public AggregateViewer(Controller controller) {
			myController = controller;
	        setTitle("sLogo");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JTextArea myCommands = new JTextArea(100,20);
			JTextArea myOutput = new JTextArea(100,20);
			TurtleViewer myGame = new TurtleViewer(myTurtle, TURTLE_SIZE, myController); 
			TextViewerArea textView = new TextViewerArea(myCommands, myOutput);
	        UpperView myUpperView = new UpperView(textView, myGame);
	        TextInputArea myTextInput = new TextInputArea();
	        FullView fullView = new FullView(myTextInput, myUpperView);
	        getContentPane().add(fullView, BorderLayout.CENTER);
	        setJMenuBar(new MenuBar());
	        pack();
	        setVisible(true);
//	        myController = controller;
	}
	 
	 
	 
	
}
