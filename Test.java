import becker.robots.*;
public class Test {
    public static void main(String[] args)
    {
        City toronto = new City(10, 15);
        BetterRobot karel = new BetterRobot(toronto, 8, 2, Direction.NORTH, 0);
        Wall w1 = new Wall(toronto, 8, 2, Direction.NORTH);
        Thing t1 = new Thing(toronto, 7, 0);
        //karel.victoryDance();
        karel.moveNorth();
        if (karel.moveNorth() == false){
            System.out.print("no");
        }
    }
}