package viewer;

/*
 * @author David Chou
 * @author katharinekrieger
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import model.Turtle;

public class TurtleViewer extends JPanel {

	private Turtle myTurtle;
	private Dimension mySize;
	private static final Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;
	private static final Color DEFAULT_PEN_COLOR = Color.WHITE;
	private static final String DEFAULT_COLORS = "resources/colors";
	private static final String DEFAULT_BACKGROUNDS = "resources/backgrounds";
	private List<Point2D> myPoints;
	private List<Line2D.Double> myLines;
	private int myXTranslation;
	private int myYTranslation;
	private int myAngle;
	private AggregateViewer myCanvas;
	private BufferedImage turtleImageBuffer;
	private Graphics2D myPen;
	private int myImageWidth;
	private int myImageHeight;
	private String TurtleImage;
	private HashMap<String, Color> myPenColors;
	private HashMap<String, Color> myBackgroundColors;
	private Color myPenColor;

	// Need to determine how to drawLines
	public TurtleViewer(Turtle turtle, Dimension size, AggregateViewer canvas) {

		myCanvas = canvas;
		mySize = size;
		setPreferredSize(size);
		setBackground(DEFAULT_BACKGROUND_COLOR);
		myBackgroundColors = createBackgroundMap();
		myTurtle = turtle;
		TurtleImage = "turtle.gif";
		createImage();
		myPoints = myTurtle.getPen().getHistory();
		myLines = createLines();
		myXTranslation = (int) size.getWidth() / 2;
		myYTranslation = (int) size.getHeight() / 2;
		myAngle = (int) myTurtle.getAngle();
		myPen.setColor(DEFAULT_PEN_COLOR);
		myPenColors = createPenColorMap();
		myPenColor = DEFAULT_PEN_COLOR;
		setVisible(true);
		update();
	}

	/*
	 * Allows for: -rotations -moves -trail drawing
	 */
	public void update() {
		repaint();
		revalidate();
		myCanvas.update();
	}

	/*
	 * Rotates the image of the turtle
	 */
	public void rotate() {
		AffineTransform temp = new AffineTransform(myPen.getTransform());
		myPen.translate(myXTranslation, myYTranslation);
		myPen.rotate(-myAngle);
		myPen.drawImage(turtleImageBuffer, -myImageWidth, -myImageHeight / 2,
				myImageWidth, myImageHeight, null);
		myPen.setTransform(temp);
		revalidate();
		repaint();
	}

	/*
	 * Instantiates the turtle image based on what is located within the gif.
	 * Allows for updates of the turtle image.
	 */
	public void createImage() {
		try {
			turtleImageBuffer = ImageIO.read(new File(TurtleImage));
			myImageWidth = turtleImageBuffer.getWidth();
			myImageHeight = turtleImageBuffer.getHeight();
			myPen = (Graphics2D) turtleImageBuffer.getGraphics();
			revalidate();

		} catch (IOException e) {
			e.printStackTrace();
		}
		revalidate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */

	// Also need to make it so that we can paint strokes
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(turtleImageBuffer, (int) myTurtle.getX() + myXTranslation,
				(int) myTurtle.getY() + myYTranslation, this);
	}

	/*
	 * Adds a list of lines to be drawn
	 */
	public List<Line2D.Double> createLines() {
		List<Line2D.Double> list = new ArrayList<Line2D.Double>();
		if (myPoints.size() >= 2) {
			for (int i = 0; i < myPoints.size() - 1; i++) {
				list.add(new Line2D.Double(myPoints.get(i), myPoints.get(i + 1)));
			}
		}
		return list;
	}

	/*
	 * Turns lines from the Line2D list into visuals
	 */
	public void drawLines() {
		for (Line2D.Double l : myLines) {
			myPen.drawLine((int) l.getX1(), (int) l.getY1(), (int) l.getX2(),
					(int) l.getY2());
		}
	}

	public void setImage(String str) {
		TurtleImage = str;
		createImage();
		revalidate();
		repaint();
	}

	public HashMap<String, Color> createPenColorMap() {
		HashMap<String, Color> colors = new HashMap<String, Color>();
		ResourceBundle resources = ResourceBundle.getBundle(DEFAULT_COLORS);
		Enumeration<String> iter = resources.getKeys();
		while (iter.hasMoreElements()) {
			try {
				String key = iter.nextElement();
				java.lang.reflect.Field field = Class.forName("java.awt.Color")
						.getField(resources.getString(key).toLowerCase());
				colors.put(key, (Color) field.get(null));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return colors;
	}
	
	public HashMap<String, Color> createBackgroundMap() {
		HashMap<String, Color> colors = new HashMap<String, Color>();
		ResourceBundle resources = ResourceBundle.getBundle(DEFAULT_BACKGROUNDS);
		Enumeration<String> iter = resources.getKeys();
		while (iter.hasMoreElements()) {
			try {
				String key = iter.nextElement();
				java.lang.reflect.Field field = Class.forName("java.awt.Color")
						.getField(resources.getString(key).toLowerCase());
				colors.put(key, (Color) field.get(null));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return colors;
	}

	public void setPenColor(String s) {
		myPen.setColor(myPenColors.get(s));
		myPenColor = (myPenColors.get(s)); 
	}

	public String getCurrentTurtleImage(){
		return TurtleImage;
	}
	
	public Color getPenColor(){
		return myPenColor;
	}

	public void setPenColor(Color color) {
		myPen.setColor(color);
		myPenColor = color;
		
	}
	
	public void setBackground(String s) {
		setBackground(myBackgroundColors.get(s));
	}
}
