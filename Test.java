import becker.robots.*;
public class Test {
    public static void main(String[] args)
    {
        City toronto = new City(10, 15);
        BetterRobot karel = new BetterRobot(toronto, 8, 2, Direction.SOUTH, 0);
        BetterRobot steve = new BetterRobot(toronto, 8, 1, Direction.SOUTH, 0);
        Wall w1 = new Wall(toronto, 8, 2, Direction.NORTH);
        Thing t1 = new Thing(toronto, 8, 1);
        //karel.victoryDance();
        int numOfRobots = karel.getIntersection().getNeighbor(Direction.NORTH).getNeighbor(Direction.EAST).countSims(IPredicate.anyRobot);
        int numOfRobotss = karel.getIntersection().getNeighbor(Direction.WEST).countSims(IPredicate.anyRobot);
        if (numOfRobotss < 1) {karel.moveWest();}
        else {karel.moveEast();}
        
    }
}