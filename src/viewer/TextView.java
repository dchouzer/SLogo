package viewer;

import javax.swing.*;

public class TextView extends JSplitPane{

	protected JTextArea myOutput;
	protected JTextArea myCommands;
	public TextView(JTextArea commands, JTextArea output){
		myCommands = commands;
		myOutput = output;
		JScrollPane top = new JScrollPane(myCommands);
		JScrollPane bottom = new JScrollPane(myOutput);
		setOrientation(VERTICAL_SPLIT);
		setTopComponent(top);
		setBottomComponent(bottom);
	}
	
	public void addText(String str){
		myCommands.append(str + "\n");
	}
	
}
