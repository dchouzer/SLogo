package viewer;

import javax.swing.*;

public class TextInput extends JPanel{
	
	public TextInput(){
		add(new JTextArea(20,80));
		add(new JButton("Execute"));
	}
	
}
