package viewer;

import javax.swing.*;

public class UpperView extends JSplitPane{

	public UpperView(TextViewerArea textview , VisualizerArea slogo){

		setOrientation(HORIZONTAL_SPLIT);
		setLeftComponent(textview);
		setRightComponent(slogo);
		
	}
	

}
