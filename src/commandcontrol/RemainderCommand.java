package commandcontrol;

import java.util.List;

import controller.TurtleController;

public class RemainderCommand extends MoreThanOneParamCommand {

	public RemainderCommand(List<Command> l) {
		super(l);
	}

	@Override
	public double execute() {
		return TurtleController.remainder(mySubCommands.get(0).execute(), mySubCommands.get(1).execute());
	}

}
