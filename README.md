slogo
=====

<pre>
interface Command
	execute()
Example classes that would implement the Command interface:
	LoopCommand
	MoveCommand
	RotateCommand
	SetPenStateCommand
	ClearScreenCommand
	DefineMethodCommand
	CallMethodCommand
	
	Description:
	The Command interface defines a contract for all commands with one method to execute
	the command. Implementations of this interface will be specific commands, each
	corresponding to the text commands that the model will recognize. Once the model
	has generated a collection of Command objects, they will be passed to the command 
	evaluator, which will run through all commands in the list. Some commands, such as
	those representing loops and defined methods, will hold a reference to a list of
	other commands, which could itself hold other nested structures as well. Simple 
	commands such as move and rotate will need to be created with only a parameter value. 
	The command evaluator may also store lists of commands as "programs" so the model 
	won't need to re-parse recent programs - they can execute straight from the Command 
	objects. Separating the command implementation from the parsing allows for greater
	flexibility between parsing commands and executing them - so the model doesn't
	need to know how commands are executed.

Parser
    aggregates text inputs into a list of strings to be parsed
	creates command objects
    
    
Error Message Generations
    The error message generator will only have two interactions:
    1) Parser
        The model will send the possible text inputs from the console to the
        error checker. If there are errors in the text, the errors must be codified
        into an error message that the API can understand to show a error dialog
        message box.
        
        Otherwise, if all of the messages are valid, the model is enabled to turn
        the text inputs into commands.
        
Error Methods:
    
    public void storeStrings(List<Strings>)
        takes the strings from model and stores them
    
    private void checkStrings(List<Strings>)
        runs through a list of stringsto see if they are valid strings
    
    private void setValidityFalse()
        changes the status of a boolean "valid" that determines whether model can
        proceed with command generation
        
    private void setValidityTrue()
        changes the status of a boolean "valid" that determines whether model can
        proceed with command generation 
        
    private void generateError() - will maybe need to split this into different types of errors
        creates a specific error based on the type of problem within the code
    
    private void sendErrorToConsole()
        tells the API to make the console show an error message
    


CommandControl
	The command control should have some collection data structure that stores
	all of the commands and grabs them from the Parser.
	It will proceed through these commands and then send them to the objects.
ConmmandHistory
	addCommand()
	getCommand()
	delete()

Object
	Turtle
		move()
		rotate()

	Pen ( within jgame )
		move()
		color()
		thickness()
		changeState()

Console
	Swing Component
		clear()
		load()
		run()
		setSpeed()	

VisualOutput (extends Jgame)
	resetScreen()
	all built in jgame methods?

API:

void runProgram(String main)
	Sends all text to the model, and executes the main.

void resetScreen()
	Erases current drawing and resets the turtle to its default position/orientation in the display area.

void restoreProgram(int index)
	Restores a main from the saved input history into the console. 
	An index of zero restores the most recent main, and earlier items have a greater index.

void stop()
	Aborts execution of the drawing and current main. Does not reset the state of the turtle.
	If any user programs are run again, the turtle starts from its current position.
	
void initiate()
	Starts the GUI and creates a turtle object.

void move(double distance)
	Moves the turtle forward by an amount of distance default units.
	
void setDrawing(boolean drawing)
	Sets whether the tutrle is drawing a line. 
	A value of true passed in causes the turtle to leave a line behind it when moving.
	
void rotate(double angle)
	Rotates the turtle by angle number of degrees.

void moveTo(double x, double y)
	Sets the position of the turtle on the display.
    
=====
Example Code:

repeat 180 [fd 1 rt 2] - the turtle will have 180 iterations;
    for each iteration:
        it moves forward one step
        it rotates by 2 degrees
        
repeat 10 [pd fd 4 pu fd 4] - the turtle will have 10 iterations;
    for each iteration:
        the pen goes down
        the turtle goes forward 4 steps
        the pen goes up
        the turtle goes forward 4 steps
        
The main will need to be able to parse the following:
    fd
    pu, pd
    rt
    loops
    methods - calling and recognition
    fd, forward
    pu, penup
    pd, pendown
    rt, right
    lt, left
    to (for methods)
    setxy
    :____ (for variables - variable name goes in blank)
        everytime we see this, we should automatically note
        that we have a variable being taken in for our command
        note also that we should be able to take multiple paremeters in methods
    need to figure out how the model can go back and grab the method...
        this means that we need to have a log of all strings within the text input


=====

Division of Labor:
Front-End:
    Kat (Console, VisualOutput, VisualObjects)
Back-End:
    David and Richard (Parser, Error Checker)
    Jeremiah(Command/Command Execution)
</pre>    
