package commandcontrol;

import java.util.List;

public class SetHeadingCommand extends OneParamCommands {

	public SetHeadingCommand(List<Command> l) {
		super(l);
	}

	@Override
	public int execute() {
		return 0;
	}

}
