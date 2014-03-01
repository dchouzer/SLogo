package commandcontrol;

import java.util.List;

import controller.Controller;

public class RotateLeftCommand extends OneParamCommands{

	public RotateLeftCommand(Command c){
		super(c);
	}

	@Override
	public double execute() {
		myAmount = myInput.execute();
		return Controller.rotate(myAmount);
	}
	
}
