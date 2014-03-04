package commandcontrol;

import java.util.List;

public class EqualCommand extends MoreThanOneParamCommands {

	public EqualCommand(List<Command> l) {
		super(l);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double execute() {
		return (mySubCommands.get(0).execute() == mySubCommands.get(1).execute())? 1 : 0;
	}

}
