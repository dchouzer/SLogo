package command;

import java.util.List;

import controller.Controller;

public class RandomCommand extends OneParamCommands {

	public RandomCommand(Command c) {
		super(c);
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return Controller.random(myAmount);
	}

}
