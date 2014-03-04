package program;

public class ErrorChecker {
	
	//Can use this to see if the number of left and right brackets are balanced.
	
	public boolean bracketCountChecker(String textProgram) {
		int [] brackets = new int[2];
		for (int c = 0; c < textProgram.length(); c++) {
			if (textProgram.charAt(c) == '[')
				brackets[0]++;
			if (textProgram.charAt(c) == ']')
				brackets[1]++;
		}
		if (brackets[0] != brackets[1])
			return false;
		
		
		return true;
	}
	
	public boolean bracketLeftBeforeRight(String textProgram) {
		int []brackets = new int[2];
		
		for (int c = 0; c < textProgram.length(); c++) {
			if (textProgram.charAt(c) == '[')
				brackets[0]++;
			if (textProgram.charAt(c) == ']')
				brackets[1]++;
			if (brackets[0] < brackets[1]) {
				return false;
			}
		}
		
		return true;
	}
}
