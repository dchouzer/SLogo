slogo
=====


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


API - 
    runProgram(text)
        sends all text to the parser, and executes the program.
    resetScreen()
    restoreCommand( )
        put the old text back into the console
    stop()
    initiate()
    move()
    rotate()
    
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
	