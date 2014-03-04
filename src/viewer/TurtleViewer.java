package viewer;
import java.awt.Component;
import java.awt.Canvas;
import java.awt.Stroke;
import java.awt.Graphics2D;
import java.awt.color.*;
import java.awt.Dimension;
import java.awt.Image;

import model.Turtle;

public class TurtleViewer extends Component {
	
	private String image;
	
	public TurtleViewer(){
		int height = 480;
		int width = 480;
		Turtle firstTurtle = new Turtle(10, 50);
	}
	
	
	public String getImage(){
		String image;
		image = "turtle";
		return image;
	}
}