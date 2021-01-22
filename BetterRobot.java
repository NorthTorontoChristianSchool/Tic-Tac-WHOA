import becker.robots.*;
import java.awt.Color;
public class BetterRobot extends Robot
{
    //if karel.getIntersection().countSims() > 1 //move back

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
        faceNorth();
        for(int i=0; i<3;i++){
            super.turnLeft();
        }
    }

    public void faceSouth()
    {
        faceNorth();
        for(int i=0; i<2;i++){
            super.turnLeft();
        }
    }

    public void faceWest()
    {
        faceNorth();
        super.turnLeft();
    }

    //methods to make robots move in certain directions

    public boolean move(String d)
    {
        if (d=="N"){
            faceNorth();
        }
        else if(d=="E"){
            faceEast();
        }
        else if(d=="S"){
            faceSouth();
        }
        else if(d=="W"){
            faceWest();
        }
        if (super.frontIsClear()){
            super.move(); //move
            return true;
        }
        return false;     
    }

    public boolean moveNorth()
    {
        faceNorth();
        if (super.frontIsClear()){
            super.move();
            return true;
        }

        else{
            return false;
        }
    }

    public boolean moveEast()
    {
        faceEast();
        if (super.frontIsClear()){
            super.move();
            return true;
        }

        else{
            return false;
        }
    } 

    public boolean moveSouth()
    {
        faceSouth();
        if (super.frontIsClear()){
            super.move();
            return true;
        }

        else{
            return false;
        }
    }   

    public boolean moveWest()
    {
        faceWest();
        if (super.frontIsClear()){
            super.move();
            return true;
        }
        else{
            return false;
        }
    }

    //dances

    public void victoryDance()
    {
        super.setSpeed(10);
        Color[] colourList = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.PINK, Color.BLUE,};
        for (int i = 0; i < 12; i++) { 
            super.turnLeft();
            super.setColor(colourList[i]);
        }

    }

    public void breakRobot()
    {
        super.setSpeed(10);
        Color[] colourList = {Color.RED, Color.BLACK};
        for (int a = 0; a < 6; a++){
            for (int i = 0; i < 2; i++) { 
                super.turnLeft();
                super.setColor(colourList[i]);
            }
        }
    }

}      
