
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
    
    //robots face certain directions

    public boolean faceNorth(){
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
        if (super.frontIsClear()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean faceEast()
    {
        faceNorth();
        for(int i=0; i<3;i++){
            super.turnLeft();
        }
        if (super.frontIsClear()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean faceSouth()
    {
        faceNorth();
        for(int i=0; i<2;i++){
            super.turnLeft();
        }
        if (super.frontIsClear()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean faceWest()
    {
        faceNorth();
        super.turnLeft();
        if (super.frontIsClear()){
            return true;
        }
        else{
            return false;
        }
    }
    
    //methods to make robots move in certain directions
    
    public boolean moveNorth()
    {
        faceNorth();
        //super.move();
        if (super.frontIsClear()){
            super.move(); //move
            return true;
        }

        else{
            return false;
        }
    }

    public boolean moveEast()
    {
        faceEast();
        //super.move();
        if (super.frontIsClear()){
            super.move(); //move
            return true;
        }

        else{
            return false;
        }
    } 

    public boolean moveSouth()
    {
        faceSouth();
        //super.move();
        if (super.frontIsClear()){
            super.move(); //move
            return true;
        }

        else{
            return false;
        }
    }   

    public boolean moveWest()
    {
        faceWest();
        //super.move();
        if (super.frontIsClear()){
            super.move(); //move
            return true;
        }
        else{
            return false;
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
 