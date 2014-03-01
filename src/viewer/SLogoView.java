package viewer;
import model.Turtle;
import jgame.platform.JGEngine;

public class SLogoView extends JGEngine {
	
	private String image;
	
	public SLogoView(){
    int height = 480;
    int width = 480;
    initEngineComponent(width, height);
	defineMedia("mygame.tbl");
    Turtle firstTurtle = new Turtle(10, 50 ,0);
	}
	
	
	@Override
	public void initCanvas() {
		// TODO Auto-generated method stub
		setCanvasSettings(100,50,4,4, null, null, null);
		
	}

	@Override
	public void initGame() {
		setFrameRate(30,1);
	}
	
	
	
	public String getImage(){
		String image;
		image = "turtle";
		return image;
	}
}