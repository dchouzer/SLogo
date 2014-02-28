package viewer;

import javax.swing.*;

public class UpperView extends JSplitPane{

	public UpperView(TextView textview , SLogoView slogo){

		setOrientation(HORIZONTAL_SPLIT);
		setLeftComponent(textview);
		setRightComponent(slogo);
		
	}
	

}
