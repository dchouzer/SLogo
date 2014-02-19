slogo
=====

Empty repository for SLogo project


interface Command
	execute()
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
	