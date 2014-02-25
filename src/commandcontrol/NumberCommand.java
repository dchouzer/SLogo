package commandcontrol;

import java.util.List;

public class NumberCommand implements Command{
	
	private int numberToReturn;
	
	public NumberCommand(int value) {
		numberToReturn = value;	
	}

	@Override
	public int execute() {
		return numberToReturn;
	}

}
