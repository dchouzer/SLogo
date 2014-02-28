package model;

import jgame.JGImage;
import jgame.JGObject;

public class Turtle extends JGObject{

		public Turtle(double x, double y, double speed, String image) {
			super("turtle", true, x, y, 1, image, 0,0,speed,speed,-1);
		}
		public void move() {
			

		}
}
