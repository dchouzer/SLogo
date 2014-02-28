package viewer;
import jgame.platform.JGEngine;

public class SLogoView extends JGEngine {
	
	public SLogoView(){
    int height = 480;
    double aspect = 16.0 / 9.0;
    initEngineComponent((int) (height * aspect), height);
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

}