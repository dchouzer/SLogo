package viewer;

import java.awt.Dimension;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import controller.Controller;
import javax.swing.*;

public class TextInputArea extends JPanel {
	JTextArea textArea;
	Controller myController;

	public TextInputArea(Controller controller) {
		myController = controller;
		setPreferredSize(new Dimension(200,100));
		textArea = createTextArea();
		add(textArea);
		add(createButton("Execute"));
	}

	public JButton createButton(String str) {
		JButton button = new JButton(str);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				try{
					myController.execute(textArea.getText());
				}
				catch (Exception k) {
					//show error
				}
				textArea.setText("");
			}
		});
		return button;
	}

	public JTextArea createTextArea() {
		JTextArea text = new JTextArea(20, 25);
		return text;
	}
	
}
