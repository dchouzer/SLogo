package viewer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controller.Controller;

public class ViewContainer extends JFrame {
	private Controller myController;
	private JTabbedPane tabbedPane;
	private AggregateViewer panel1;
	private AggregateViewer panel2;
	private HashMap<Integer, AggregateViewer> tabs;
	private int tabIndex;
	public ViewContainer(Controller controller){
		tabIndex = 0;
		tabbedPane = new JTabbedPane();
		myController = controller;
		tabs = new HashMap<Integer, AggregateViewer>();
		createTab();
		setJMenuBar(new MenuBar(myController));
		setSize(1200, 800);
		pack();
		setVisible(true);
	}
	
	private void createTab(){
		AggregateViewer panel = new AggregateViewer(myController);
		tabbedPane.addTab("SLogo Workspace", null, panel, "SLogo Workspace");
		tabs.put(tabIndex, panel);
		tabIndex++;
		add(tabbedPane);
	}
	
	private void removeTab(Integer index){
		tabbedPane.remove(index);
		tabs.remove(index);
		for(int i=0; i<=tabs.size(); i++){
			if(i > index){
				if(tabs.containsKey(i)){
					AggregateViewer panel = tabs.get(i);
					tabs.put(i-1, panel);
				}
			}
		}
	}
	
	public void setTurtleImage(String str){
		tabs.get(tabbedPane.getSelectedIndex()).setTurtleImage(str);
	}
	
	public void saveCommandsToFile(){
		tabs.get(tabbedPane.getSelectedIndex()).saveCommandsToFile();
	}

	public void loadCommandsToText() {
		tabs.get(tabbedPane.getSelectedIndex()).loadCommandsToText();
		
	}
	
}



/*
 * 
 * 
 * */
