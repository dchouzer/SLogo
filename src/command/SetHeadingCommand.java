package command;

import java.util.List;

import controller.Controller;

public class SetHeadingCommand extends OneParamCommand {

	public SetHeadingCommand(Command c) {
		super(c);
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return Controller.setHeading(myAmount);
	}

}
