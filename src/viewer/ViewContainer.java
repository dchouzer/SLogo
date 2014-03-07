package viewer;

import java.awt.BorderLayout;
import java.awt.GridLayout;

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
	public ViewContainer(Controller controller){
		tabbedPane = new JTabbedPane();
		myController = controller;
		createTab("First Tab", "");
		setJMenuBar(new MenuBar(myController));
		setSize(1200, 800);
		pack();
		setVisible(true);
	}
	
	private void createTab(String str, String str2){
		 panel1 = new AggregateViewer(myController);
		tabbedPane.addTab(str, null, panel1, str2);
		add(tabbedPane);
	}
	public void setTurtleImage(String str){
		panel1.setTurtleImage(str);
	}
	
}



/*
 * 
 * 
 * */
