package viewer;

/*
 * @author David Chou
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Canvas;
import java.awt.Stroke;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import model.Turtle;

public class TurtleViewer extends Component {
	
	private String image;
	private boolean isToggled = true;
	private boolean penDown = true;
	private List<Point2D> myPointHistory;
	private int myPenWidth;
	private Turtle myTurtle;
	private Dimension mySize;
	private static final Color DEFAULT_BACKGROUND_COLOR = Color.BLACK;
	private static final Color DEFAULT_PEN_COLOR = Color.WHITE;
	private Graphics2D myTurtleImage = null;
	private List<Point2D> myPoints;
	private List<Line2D.Double> myLines;
	//Need to transform the location of the image also
	private double myXTransform;
	private double myYTransform;
	
	//Need to determine how to drawLines
	public TurtleViewer(Turtle turtle, Dimension size){	
		mySize = size;
		myTurtle = turtle;
		createImage();
		myPoints = myTurtle.getPen().getHistory();
		myLines = createLines();
		myXTransform = size.getWidth();
		myYTransform = size.getHeight();
	}
	
	/*
	 * Allows for:
	 * -rotations
	 * -moves
	 * -trail drawing
	 */
	public void update() {
		
	}
	
	/*
	 * Instantiates the turtle image based on what is located
	 * within the gif.
	 */
	public void createImage() {
		BufferedImage turtle;
		try {
			turtle = ImageIO.read(new File("turtle.gif"));
			myTurtleImage = (Graphics2D) turtle.getGraphics();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Creates the lines based upon the current list of points
	 * inside the turtle
	 */
	public List<Line2D.Double> createLines() {
		List<Line2D.Double> list = new ArrayList<Line2D.Double>();
		if (myPoints.size() >= 2) {
			for (int i = 0; i < myPoints.size() - 1; i++) {
				list.add(new Line2D.Double(myPoints.get(i), myPoints.get(i+1)));
			}
		}
		return list;
	}
	
	public String getImage(){
		String image;
		image = "turtle";
		return image;
	}
}