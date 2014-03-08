package viewer;

import java.awt.Dimension;

import javax.swing.*;

/*
 * @author Kat Krieger
 * @author David Chou
 */

public class TopLeftView extends JSplitPane{

	protected JTextArea myOutput;
	protected JList myCommands;
	protected DefaultListModel listModel; 
	
	public TopLeftView(JList commands, JTextArea output){
		
		listModel = new DefaultListModel();
		myOutput = output;
		myCommands = new JList(listModel);
		JScrollPane top = new JScrollPane(myCommands);
		top.setPreferredSize(new Dimension(450,100));
		JScrollPane bottom = new JScrollPane(myOutput);
		bottom.setPreferredSize(new Dimension(450,100));
		setOrientation(VERTICAL_SPLIT);
		setTopComponent(top);
		setBottomComponent(bottom);
		
	}
	
	public void addCommandToList(String str){
		listModel.addElement(str);
	}
	
}
