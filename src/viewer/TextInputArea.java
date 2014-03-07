package viewer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import controller.Controller;
import javax.swing.*;

public class TextInputArea extends JPanel {
	JTextArea textArea;
	JPanel myButtonPanel;
	Controller myController;

	public TextInputArea(Controller controller) {
		myButtonPanel = new JPanel();
		myButtonPanel.setPreferredSize(new Dimension(50,100));
		myController = controller;
		setPreferredSize(new Dimension(200, 100));
		textArea = createTextArea();
		add(textArea);
		GridLayout gridLayout = new GridLayout(2,1);
        setLayout(gridLayout);
		myButtonPanel.add(createExecuteButton());
		myButtonPanel.add(createRedoButton());
		myButtonPanel.add(createUndoButton());
		this.add(myButtonPanel);
	}

	public JButton createExecuteButton() {
		JButton button = new JButton("Execute");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					myController.execute(textArea.getText());
				} catch (Exception k) {
					// show error
				}
				textArea.setText("");
			}
		});
		return button;
	}
	
	public JButton createUndoButton() {
		JButton button = new JButton("Undo");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					myController.undo();
				} catch (Exception k) {
					// show error
				}
				textArea.setText("");
			}
		});
		return button;
	}
	
	public JButton createRedoButton() {
		JButton button = new JButton("Redo");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					myController.redo();
				} catch (Exception k) {
					// show error
				}
				textArea.setText("");
			}
		});
		return button;
	}

	public JTextArea createTextArea() {
		JTextArea text = new JTextArea(150, 100);
		return text;
	}

	public void save() {
		String myText = this.textArea.getText();
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("./"));
		int actionDialog = chooser.showSaveDialog(this);
		if (actionDialog == JFileChooser.APPROVE_OPTION) {
			File fileName = new File(chooser.getSelectedFile() + "");
			if (fileName == null)
				return;
			if (fileName.exists()) {
				actionDialog = JOptionPane.showConfirmDialog(this,
						"Replace existing file?");
				if (actionDialog == JOptionPane.NO_OPTION)
					return;
			}
			try {
				BufferedWriter out = new BufferedWriter(
						new FileWriter(fileName));

				out.write(myText);
				out.close();
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}
		}
	}

	public void load() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("./"));
		int actionDialog = chooser.showOpenDialog(this);
		if (actionDialog == JFileChooser.APPROVE_OPTION) {
			File fileName = new File(chooser.getSelectedFile() + "");
			if (fileName == null)
				return;
			try {

				String strLine;
				File f = chooser.getSelectedFile();
				BufferedReader br = new BufferedReader(new FileReader(f));

				while ((strLine = br.readLine()) != null) {
					textArea.append(strLine + "\n");
					System.out.println(strLine);

				}
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}
		}
	}

}
