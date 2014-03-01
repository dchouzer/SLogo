package viewer;

import javax.swing.*;

public class FullView extends JSplitPane{

	public FullView(TextInputArea textInput, UpperView upper){

		setOrientation(VERTICAL_SPLIT);
		setTopComponent(upper);
		setBottomComponent(textInput);
		
	}
	

}
