package command;

import java.util.List;

import controller.Controller;

public class SumCommand extends MoreThanOneParamCommand {

	public SumCommand(List<Command> l) {
		super(l);
	}

	@Override
	public double execute() {
		return mySubCommands.get(0).execute() + mySubCommands.get(1).execute();
	}

}
