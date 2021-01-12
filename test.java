import becker.robots.*;
public class test {
    public static void main(String[] args)
    {
        City toronto = new City(10, 15);
        Robot karel = new Robot(toronto, 8, 0, Direction.EAST, 0);
        Wall w1 = new Wall(toronto, 8, 2, Direction.NORTH);
        Thing t1 = new Thing(toronto, 7, 0);
    }
}