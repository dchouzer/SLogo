package viewer;

import javax.swing.JButton;

public class ViewFactory {

	public ViewFactory(){
		
	}
	
	public JButton createJButton(String str){
		JButton button = new JButton(str);
		return button;
	}
}
