package viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import model.Turtle;
import model.TurtleState;
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
	private TextInputArea myTextInput;
	private Dimension TOTAL_SIZE = new Dimension(1200, 800);
	private Dimension TURTLE_SIZE = new Dimension(800, 600);
	private Dimension TEXT_OUTPUT_SIZE = new Dimension(400, 250);
	private Dimension PROGRAM_INPUT_SIZE = new Dimension(800, 300);
	private Dimension COMPUTATION_SIZE = new Dimension(400, 250);

	private TurtleState myTurtleState;
	private Turtle myTurtle;
	private TopLeftView textView;


	public AggregateViewer(Controller controller) {
		//Basic instantiation
		myTurtle = new Turtle(0, 0);
		myController = controller;
		myPanel = new JSplitPane();
		myPanel.setLayout(new BorderLayout());
		JList myCommands = new JList();
		JTextArea myOutput = new JTextArea(300, 100);
		myGame = new TurtleViewer(myTurtle, TURTLE_SIZE, this);
		textView = new TopLeftView(myCommands, myOutput);
		myTextInput = new TextInputArea(myController);
		LeftView myUpperView = new LeftView(textView, myTextInput);
		myPanel = new FullView(myUpperView, myGame);

		setSize(1200, 800);
		add(myPanel);
		setVisible(true);
	}
	
	public void createTurtleState(TurtleState st){
		myTurtleState = st;
	}
	
	public void update () {
        Random rand = new Random();
        myPanel.setSize(TOTAL_SIZE);
        validate();
        repaint();
    }

	public void setTurtleImage(String str){
		myGame.setImage(str);
	}
	
	public void saveCommandsToFile(){
		myTextInput.save();
	}

	public void loadCommandsToText() {
		myTextInput.load();
	}
	
	public void addCommandToList(String str){
		textView.addCommandToList(str);
	}
	
	public void setPenColor(String string) {
		myGame.setPenColor(string);
		
	}
	
	public String getCurrentTurtleImage(){
		return myGame.getCurrentTurtleImage();
	}
	
	public Color getPenColor(){
		return myGame.getPenColor();
	}

	public void setPenColor(Color color) {
		myGame.setPenColor(color);	
	}

	public void setBackground(String string) {
		myGame.setBackground(string);	
	}
}
