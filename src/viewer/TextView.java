package viewer;

import javax.swing.*;

public class TextView extends JSplitPane{

	protected JTextArea myOutput;
	protected JTextArea myCommands;
	public TextView(JScrollPane top, JScrollPane bottom, JTextArea commands, JTextArea output){
		myCommands = commands;
		myOutput = output;
		setOrientation(VERTICAL_SPLIT);
		setTopComponent(myCommands);
		setBottomComponent(myOutput);
	}
	
	public void addText(String str){
		myCommands.append(str + "\n");
	}
	
}
