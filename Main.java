import becker.robots.*;
public class Main
{
    public static void main(String[] args)
    {
        City board = new City(7,7);
        board.setFrameTitle("Game");
        for (int i=1; i<=5; i++){
        Wall topWalls = new Wall (board,1,i,Direction.NORTH);
        }
        for (int i=1; i<=5; i++){
        Wall btmWalls = new Wall (board,5,i,Direction.SOUTH);
        }
        for (int i=1; i<=5; i++){
        Wall leftWalls = new Wall (board,i,1,Direction.WEST);
        }
        for (int i=1; i<=5; i++){
        Wall rightWalls = new Wall (board,i,5,Direction.EAST);
        }
    }
}
