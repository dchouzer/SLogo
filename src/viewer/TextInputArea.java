package viewer;

import java.awt.Dimension;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
	
	public void save() {
		String myText = this.textArea.getText();
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory( new File( "./") );
        int actionDialog = chooser.showSaveDialog(this);
        if (actionDialog == JFileChooser.APPROVE_OPTION)
        {
            File fileName = new File(chooser.getSelectedFile( ) + "" );
            if(fileName == null)
                return;
            if(fileName.exists())
            {
                actionDialog = JOptionPane.showConfirmDialog(this,
                                   "Replace existing file?");
                if (actionDialog == JOptionPane.NO_OPTION)
                    return;
            }
            try
            {
                BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

                    out.write(myText);
                    out.close();
            }
            catch(Exception e)
            {
                 System.err.println("Error: " + e.getMessage());
            }
        }
	}
	
}
