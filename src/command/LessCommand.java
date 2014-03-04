package command;

import java.util.List;

public class LessCommand extends MoreThanOneParamCommand {

	public LessCommand(List<Command> l)  {
		super(l);
	}

	@Override
	public double execute() {
		return (mySubCommands.get(0).execute() < mySubCommands.get(1).execute())? 1 : 0;
	}

}
