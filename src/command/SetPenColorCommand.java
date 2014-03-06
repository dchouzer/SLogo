package command;

import controller.Controller;
public class SetPenColorCommand extends OneParamCommand {

	public SetPenColorCommand(Command c) {
		super(c);
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return Controller.setPenColor(myAmount);
	}

}
