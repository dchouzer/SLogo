package viewer;
import java.awt.Component;

import model.Turtle;

public class VisualizerArea extends Component {
	
	private String image;
	
	public VisualizerArea(){
    int height = 480;
    int width = 480;
//    initEngineComponent(width, height);
//	defineMedia("mygame.tbl");
    Turtle firstTurtle = new Turtle(10, 50);
	}
	
	
//	@Override
//	public void initCanvas() {
//		// TODO Auto-generated method stub
//		setCanvasSettings(100,50,4,4, null, null, null);
//		
//	}

//	@Override
//	public void initGame() {
//		setFrameRate(30,1);
//	}
	
	
	
	public String getImage(){
		String image;
		image = "turtle";
		return image;
	}
}