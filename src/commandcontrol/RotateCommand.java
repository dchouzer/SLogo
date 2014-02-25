package commandcontrol;

import java.util.List;

public class RotateCommand extends OneParamCommands{

	public RotateCommand(List<Command> l) {
		super(l);
	}

	@Override
	public int execute() {
		return 0;
	}
	
}
