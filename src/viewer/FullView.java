package viewer;

import javax.swing.*;

public class FullView extends JSplitPane{

	public FullView(TextInput textInput, UpperView upper){

		setOrientation(VERTICAL_SPLIT);
		setTopComponent(upper);
		setBottomComponent(textInput);
		
	}
	

}
