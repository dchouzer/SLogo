package model;
import java.util.List;

import commandcontrol.*;



/*
 * @author David Chou
 */

public class Evaluator {

	List<Command> commandListToEvaluate;
	
	public void execute(List<Command> list) {
		for (Command c : list) {
			//Store this value and send it to the view
			//Display an operation to show up
			c.execute();
		}
	}

}
