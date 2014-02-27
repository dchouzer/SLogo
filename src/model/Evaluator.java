package model;
import java.util.List;

import commandcontrol.*;


public class Evaluator {

	List<Command> commandListToEvaluate;
	
	public void execute(List<Command> list) {
		for (Command c : list) {
			c.execute();
		}
	}

}
