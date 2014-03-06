package viewer;

import java.awt.Dimension;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;

public class TextInputArea extends JPanel {
	JTextArea textArea;

	public TextInputArea() {
		setPreferredSize(new Dimension(200,100));
		textArea = createTextArea();
		add(textArea);
		add(createButton("Execute"));
	}

	public JButton createButton(String str) {
		JButton button = new JButton(str);
		button.addActionListener(new AbstractAction("executeCommand") {
			public void actionPerformed(ActionEvent e) {
				textArea.append("sample");
			}
		});
		return button;
	}

	public JTextArea createTextArea() {
		JTextArea text = new JTextArea(20, 25);
		return text;
	}
	
}
