import becker.robots.*;
public class betterRobot extends Robot
{
    //Constructor
    public betterRobot(City c, int s, int a, Direction d, int n)
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
    } 
    
    public void moveSouth()
    {
        for (int i = 0; i < 2; i++) {
            super.turnLeft();
        }
        super.move();
    }   
    
    public void moveWest()
    {
        super.turnLeft();
        super.move();
    }
    
}    
 