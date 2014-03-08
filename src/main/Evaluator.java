package main;
import java.util.ArrayList;
import java.util.List;

import command.Command;


/*
 * @author David Chou
 */

public class Evaluator {

	List<Command> commandListToEvaluate;
	
	public List<Double> execute(List<Command> list) {
		List<Double> results = new ArrayList<Double>();
		for (Command c : list) {
			results.add(c.execute());
		}
		
		return results;
	}

}
