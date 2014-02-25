package commandcontrol;

import java.util.List;

public class RotateLeftCommand extends OneParamCommands{

	public RotateLeftCommand(List<Command> l) {
		super(l);
	}

	@Override
	public int execute() {
		return 0;
	}
	
}
