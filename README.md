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

runProgram(text)
	sends all text to the parser, and executes the program.

resetScreen()

restoreCommand( )
	put the old text back into the console

stop()

initiate()

move()
	
rotate()
	