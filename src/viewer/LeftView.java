package viewer;

import javax.swing.*;

public class LeftView extends JSplitPane{

	public LeftView(TopLeftView textView, TextInputArea textInput){

		setOrientation(VERTICAL_SPLIT);
		setTopComponent(textView);
		setBottomComponent(textInput);
	}
	

}
