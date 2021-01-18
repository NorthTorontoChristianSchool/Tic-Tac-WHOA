import becker.robots.*;
import java.awt.Color;
public class BetterRobot extends Robot
{
    //Constructor
    public BetterRobot(City c, int s, int a, Direction d, int n)
    {
        super(c, s, a, d, n);
    }   

    //public methods
    //robots moves - robot originally facing north
    public void moveNorth()
    {
        super.move();
    }

    public void moveEast()
    {
        for (int i = 0; i < 3; i++) {
            super.turnLeft();
        }
        super.move();
        super.turnLeft(); //face north again
    } 

    public void moveSouth()
    {
        for (int i = 0; i < 2; i++) {
            super.turnLeft();
        }
        super.move();
        for (int i = 0; i < 2; i++) { //face north again
            super.turnLeft();
        }
    }   

    public void moveWest()
    {
        super.turnLeft();
        super.move();
        for (int i = 0; i < 3; i++) { //face north again
            super.turnLeft();
        }
        
    }

    public void victoryDance()
    {
        super.setSpeed(5);
        Color[] colourList = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK,};
        for (int i = 0; i < 12; i++) { 
            super.turnLeft();
            super.setColor(colourList[i]);
        }
    }
}    
 