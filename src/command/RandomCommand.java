package command;

import java.util.List;

import controller.Controller;

public class RandomCommand extends OneParamCommand {

	public RandomCommand(Command c) {
		super(c);
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return Math.random() * myAmount;
	}

}
