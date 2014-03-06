package command;

import controller.Controller;

public class SetShapeCommand extends OneParamCommand {

	public SetShapeCommand(Command c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return Controller.setShape(myAmount);
	}

}
