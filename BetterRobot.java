import becker.robots.*;
import java.awt.Color;
public class BetterRobot extends Robot
{


    protected void customizeIntersection(Intersection intersection){
        //IntersectionIcon(Color.WHITE, Color.PINK);
    }

    //if karel.getIntersection().countSims() > 1 //move back
    //Constructor
    public BetterRobot(City c, int s, int a, Direction d, int n)
    {
        super(c, s, a, d, n);
    }   

    //public methods
    //robots moves - robot originally facing north
    //public boolean frontIsClear(){
    // if 
    // }

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
        if (dFacing.equals(Direction.EAST)){
            for (int i = 0; i < 3; i++) { //face north again
                super.turnLeft();
            }
        }
    }

    public void moveNorth()
    {
        faceNorth();
        //if (super.frontIsClear()){
        super.move(); //move
        // return true;
        // //}
        // //else{
        // return false;
        // //}
    }

    public void moveEast()
    {
        faceNorth();
        for (int i = 0; i < 3; i++) {
            super.turnLeft(); //face East by turning right
        }
        // if (super.frontIsClear()){
        super.move(); //move
        // return true;
        // }
        // else{
        // return false;
        // }

    } 

    public void moveSouth()
    {
        faceNorth();
        for (int i = 0; i < 2; i++) { //face south
            super.turnLeft();
        }
        // if (super.frontIsClear()){
        super.move(); //move
        // return true;
        // }
        // else{
        // return false;
        // }

    }   

    public void moveWest()
    {
        faceNorth();
        super.turnLeft(); //face west
        // if (super.frontIsClear()){
        super.move(); //move
        // return true;
        // }
        // else{
        // return false;
        // }
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
 