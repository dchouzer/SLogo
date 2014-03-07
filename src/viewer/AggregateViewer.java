package viewer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import model.Turtle;

import controller.Controller;

/**
 * 
 * @author katharinekrieger
 * @author David Chou
 */
public class AggregateViewer extends JPanel {

	private JFrame myFrame;
	private JSplitPane myPanel;
	private TurtleViewer myGame;
	private Controller myController;
	private Dimension TOTAL_SIZE = new Dimension(1200, 800);
	private Dimension TURTLE_SIZE = new Dimension(800, 600);
	private Dimension TEXT_OUTPUT_SIZE = new Dimension(400, 250);
	private Dimension PROGRAM_INPUT_SIZE = new Dimension(800, 300);
	private Dimension COMPUTATION_SIZE = new Dimension(400, 250);

	private Turtle myTurtle;


	public AggregateViewer(Controller controller) {
		//Basic instantiation
		myTurtle = new Turtle(0, 0);
		myController = controller;
		myPanel = new JSplitPane();
		myPanel.setLayout(new BorderLayout());
		//setTitle("SLogo Turtle Simulator");
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		JTextArea myCommands = new JTextArea(300, 100);
		JTextArea myOutput = new JTextArea(300, 100);
		myGame = new TurtleViewer(myTurtle, TURTLE_SIZE, this);
		TopLeftView textView = new TopLeftView(myCommands, myOutput);
		TextInputArea myTextInput = new TextInputArea(myController);
		LeftView myUpperView = new LeftView(textView, myTextInput);
		myPanel = new FullView(myUpperView, myGame);
		
		// Set up the menuBar
		
		setSize(1200, 800);
		add(myPanel);
		setVisible(true);
	}
	
	public void update () {
        Random rand = new Random();
        myPanel.setSize(TOTAL_SIZE);
        validate();
    }

	public void setTurtleImage(String str){
		myGame.setImage(str);
	}
}
