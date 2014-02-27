package commandcontrol;

import java.util.List;

public class NumberCommand implements Command{
	
	private double numberToReturn;
	
	public NumberCommand(double d) {
		numberToReturn = d;	
	}

	@Override
	public double execute() {
		return numberToReturn;
	}

}
