slogo
=====


interface Command
	execute()
    Example classes that would implement the Command interface:
    LoopCommand
    MoveCommand
    RotateCommand
    SetPenStateCommand
    ClearScreenCommand
	
Parser
	creates command objects
Error Message Generations
    


ConmmandHistory
	addCommand()
	getCommand()
	delete()

Object
	Tutle
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

void runProgram(String program)
>	Sends all text to the parser, and executes the program.

void resetScreen()
>	Erases current drawing and resets the turtle to its default position/orientation in the display area.

void restoreProgram(int index)
>	Restores a program from the saved input history into the console. 
>	An index of zero restores the most recent program, and earlier items have a greater index.

void stop()
>	Aborts execution of the drawing and current program. Does not reset the state of the turtle.
>	If any user programs are run again, the turtle starts from its current position.
	
void initiate()
>	Starts the GUI and creates a turtle object.

void move(double distance)
>	Moves the turtle forward by an amount of distance default units.
	
void setDrawing(boolean drawing)
>	Sets whether the tutrle is drawing a line. A value of true passed in causes the turtle to leave a line behind it when moving.
	
void rotate(double angle)
>	Rotates the turtle by angle number of degrees.

void moveTo(double x, double y)
>	Sets the position of the turtle on the display.
    
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
        
The program will need to be able to parse the following:
    fd
    pu, pd
    rt
    methods - calling and recognition
    setxy
    setting of global variables


=====

Division of Labor:
Front-End:
    Kat (Console, VisualOutput, VisualObjects)
Back-End:
    David and Richard (Parser, Error Checker)
    Jeremiah(Command/Command Execution)
