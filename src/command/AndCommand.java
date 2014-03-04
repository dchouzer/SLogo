package command;

import java.util.List;

public class AndCommand extends MoreThanOneParamCommand {

	public AndCommand(List<Command> l) {
		super(l);
	}

	@Override
	public double execute() {
		return ((mySubCommands.get(0).execute() != 0) && (mySubCommands.get(1).execute() != 0))? 1 : 0;
	}

}
