package command;

import java.util.List;

public class OrCommand extends MoreThanOneParamCommand {

	public OrCommand(List<Command> l) {
		super(l);
	}

	@Override
	public double execute() {
		return ((mySubCommands.get(0).execute() != 0) || (mySubCommands.get(1).execute() != 0))? 1 : 0;
	}

}
