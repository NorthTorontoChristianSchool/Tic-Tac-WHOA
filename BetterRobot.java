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

    //robots face certain directions
    public void faceNorth(){
        Direction dFacing = getDirection();
        if (dFacing.equals(Direction.EAST)){
            super.turnLeft();
        }
        if (dFacing.equals(Direction.SOUTH)){
            for (int i = 0; i < 2; i++) { //face north again
                super.turnLeft();
            }
        }
        if (dFacing.equals(Direction.WEST)){
            for (int i = 0; i < 3; i++) { //face north again
                super.turnLeft();
            }
        }
    }

    public void faceEast()
    {
        if(super.getDirection() != Direction.EAST){
            faceNorth();
            for(int i=0; i<3;i++){
                super.turnLeft();
            }
        }
    }

    public void faceSouth()
    {
        if(super.getDirection() != Direction.SOUTH){
            faceNorth();
            for(int i=0; i<2;i++){
                super.turnLeft();
            }
        }
    }

    public void faceWest()
    {
        if(super.getDirection() != Direction.WEST){
            faceNorth();
            super.turnLeft();
        }
    }

    //methods to make robots move in certain directions
    //overloads the move() method so that you can specify the direction you move
    public boolean move(String d)
    {
        if (d.equals("N")){
            faceNorth();
        }
        else if(d.equals("E")){
            faceEast();
        }
        else if(d.equals("S")){
            faceSouth();
        }
        else if(d.equals("W")){
            faceWest();
        }

        if (super.frontIsClear()){
            super.move(); //move
            return true;
        }
        return false;     
    }

    //victory dance... I really like it
    public void victoryDance()
    {
        super.setSpeed(10);
        Color[] colourList = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.PINK, Color.YELLOW,};
        faceNorth();
        super.setLabel("WINNER!");
        for (int i = 0; i < 12; i++) { 
            super.turnLeft();
            super.setColor(colourList[i]);
        }

    }

    //loser dance :(
    //overrides the breakRobot() method for something much more useful... 
    //the robots spin around and break 
    public void breakRobot()
    {
        super.setSpeed(10);
        Color[] colourList = {Color.RED, Color.BLACK};
        faceSouth();
        for (int a = 0; a < 6; a++){
            for (int i = 0; i < 2; i++) { 
                super.turnLeft();
                super.setColor(colourList[i]);
            }
        }
    }
}      
