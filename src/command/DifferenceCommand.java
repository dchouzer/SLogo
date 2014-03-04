package command;

import java.util.List;

import controller.Controller;

public class DifferenceCommand extends MoreThanOneParamCommand {

	public DifferenceCommand(List<Command> l) {
		super(l);
	}

	@Override
	public double execute() {
		return Controller.sum(mySubCommands.get(0).execute(), -(mySubCommands.get(1).execute()));
	}

}
