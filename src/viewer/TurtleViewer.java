package viewer;

/*
 * @author David Chou
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Stroke;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controller.Controller;

import model.Turtle;

public class TurtleViewer extends JPanel {

	private String image;
	private boolean isToggled = true;
	private boolean penDown = true;
	private Turtle myTurtle;
	private Dimension mySize;
	private static final Color DEFAULT_BACKGROUND_COLOR = Color.BLACK;
	private static final Color DEFAULT_PEN_COLOR = Color.WHITE;
	private List<Point2D> myPoints;
	private List<Line2D.Double> myLines;
	// Need to transform the location of the image also
	private int myXTranslation;
	private int myYTranslation;
	private int myAngle;
	private AggregateViewer myCanvas;
	private BufferedImage turtleImageBuffer;
	private Graphics2D myTurtleImage;
	private int myImageWidth;
	private int myImageHeight;
	private String TurtleImage;

	// Need to determine how to drawLines
	public TurtleViewer(Turtle turtle, Dimension size, AggregateViewer canvas) {

		myCanvas = canvas;
		mySize = size;
		setPreferredSize(size);
		setBackground(DEFAULT_BACKGROUND_COLOR);
		myTurtle = turtle;
		TurtleImage = "turtle.gif";
		createImage();
		myPoints = myTurtle.getPen().getHistory();
		myLines = createLines();
		myXTranslation = (int) size.getWidth() / 2;
		myYTranslation = (int) size.getHeight() / 2;
		myAngle = (int) myTurtle.getAngle();


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
		AffineTransform temp = new AffineTransform(myTurtleImage.getTransform());
		myTurtleImage.translate(myXTranslation, myYTranslation);
		myTurtleImage.rotate(-myAngle);
		myTurtleImage.drawImage(turtleImageBuffer, -myImageWidth,
				-myImageHeight / 2, myImageWidth, myImageHeight, null);
		myTurtleImage.setTransform(temp);
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
//			myTurtleImage = (Graphics2D) turtleImageBuffer.getGraphics();

		} catch (IOException e) {
			e.printStackTrace();
		}
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
		
	}
	
	public void setImage(String str){
		TurtleImage = str;
		System.out.println("made it");
		createImage();
	}

}