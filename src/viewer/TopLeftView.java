package viewer;

import java.awt.Dimension;

import javax.swing.*;

/*
 * @author Kat Krieger
 * @author David Chou
 */

public class TopLeftView extends JSplitPane{

	protected JTextArea myOutput;
	protected JTextArea myCommands;
	public TopLeftView(JTextArea commands, JTextArea output){
		myCommands = commands;
		myOutput = output;
		JScrollPane top = new JScrollPane(myCommands);
		top.setPreferredSize(new Dimension(450,100));
		JScrollPane bottom = new JScrollPane(myOutput);
		bottom.setPreferredSize(new Dimension(450,100));
		setOrientation(VERTICAL_SPLIT);
		setTopComponent(top);
		setBottomComponent(bottom);
		
	}
	
	public void addText(String str){
		myCommands.append(str + "\n");
	}
	
}
