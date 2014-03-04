package commandcontrol;

import java.util.List;

public class NotEqualCommand extends MoreThanOneParamCommands {

	public NotEqualCommand(List<Command> l) {
		super(l);
	}

	@Override
	public double execute() {
		return (mySubCommands.get(0).execute() != mySubCommands.get(1).execute())? 1 : 0;
	}

}
