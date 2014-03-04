package command;

import java.util.List;

import controller.Controller;

public class PowCommand extends MoreThanOneParamCommand {

	public PowCommand(List<Command> l) {
		super(null);
	}

	@Override
	public double execute() {
		return Controller.pow(mySubCommands.get(0).execute(), mySubCommands.get(1).execute());
	}

}
