package commandcontrol;

import java.util.List;

public class LoopCommand implements Command {
	private Command myInput;
	private List<Command> myCommandList;
	
	public LoopCommand(Command c, List<Command> commandList) {
		myInput = c;
		myCommandList = commandList;
	}

	public double execute() {
		int numLoops = (int) myInput.execute();
		double result = 0;
		for(int i = 0; i < numLoops; i++) {
			for(Command c : myCommandList) {
				result = c.execute();
			}
		}
		return result;
	}

}
