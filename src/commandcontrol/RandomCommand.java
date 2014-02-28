package commandcontrol;

import java.util.List;

import controller.TurtleController;

public class RandomCommand extends OneParamCommands {

	public RandomCommand(Command c) {
		super(c);
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return TurtleController.random(myAmount);
	}

}
