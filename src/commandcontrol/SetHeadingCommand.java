package commandcontrol;

import java.util.List;

import controller.Controller;

public class SetHeadingCommand extends OneParamCommands {

	public SetHeadingCommand(Command c) {
		super(c);
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return Controller.setHeading(myAmount);
	}

}
