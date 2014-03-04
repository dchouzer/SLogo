package command;

import java.util.List;

import controller.Controller;

public class RemainderCommand extends MoreThanOneParamCommand {

	public RemainderCommand(List<Command> l) {
		super(l);
	}

	@Override
	public double execute() {
		return Controller.remainder(mySubCommands.get(0).execute(), mySubCommands.get(1).execute());
	}

}
