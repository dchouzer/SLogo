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
		createTab("Slogo Workspace", "");
		createTab("Slogo Workspace", "");
		setJMenuBar(new MenuBar(myController));
		setSize(1200, 800);
		pack();
		setVisible(true);
	}
	
	private void createTab(String str, String str2){
		AggregateViewer panel = new AggregateViewer(myController);
		tabbedPane.addTab(str, null, panel, str2);
		tabs.put(tabIndex, panel);
		tabIndex++;
		add(tabbedPane);
	}
	
	public void setTurtleImage(String str){
		tabs.get(tabbedPane.getSelectedIndex()).setTurtleImage(str);
	}
	
}



/*
 * 
 * 
 * */
