package viewer;

import javax.swing.*;

public class FullView extends JSplitPane{

	public FullView(LeftView leftSide, TurtleViewer turtleViewer){

		setOrientation(HORIZONTAL_SPLIT);
		setLeftComponent(leftSide);
		setRightComponent(turtleViewer);
	}
	

}
