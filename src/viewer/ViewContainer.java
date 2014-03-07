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
	
	public ViewContainer(Controller Controller){
		tabbedPane = new JTabbedPane();
		createTab("First Tab", "");
		createTab("First Tab", "");
		setJMenuBar(new MenuBar(myController));
		setSize(1200, 800);
		pack();
		setVisible(true);
	}
	
	private void createTab(String str, String str2){
		AggregateViewer panel1 = new AggregateViewer(myController);
		tabbedPane.addTab(str, null, panel1, str2);
		add(tabbedPane);
	}
	
}



/*
 * 
 * 
 * */
