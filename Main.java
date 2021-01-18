import becker.robots.*;
import java.awt.Color;
public class Main
{
    public static void main(String[] args)
    {
        //creating the walls of the board game
        City board = new City(7,7);
        board.setFrameTitle("Game");
        for (int i=1; i<=4; i++){
            Wall topWalls = new Wall (board,1,i,Direction.NORTH);
        }
        for (int i=1; i<=4; i++){
            Wall btmWalls = new Wall (board,4,i,Direction.SOUTH);
        }
        for (int i=1; i<=4; i++){
            Wall leftWalls = new Wall (board,i,1,Direction.WEST);
        }
        for (int i=1; i<=4; i++){
            Wall rightWalls = new Wall (board,i,4,Direction.EAST);
        }

        //putting robots on the board
        //p1
        Robot a = new Robot(board, 1, 1, Direction.EAST, 0);
        Robot b = new Robot(board, 3, 1, Direction.EAST, 0);
        Robot c = new Robot(board, 2, 4, Direction.WEST, 0);
        Robot d = new Robot(board, 4, 4, Direction.WEST, 0);
        //p2
        Robot A = new Robot(board, 2, 1, Direction.EAST, 0);
        Robot B = new Robot(board, 4, 1, Direction.EAST, 0);
        Robot C = new Robot(board, 1, 4, Direction.WEST, 0);
        Robot D = new Robot(board, 3, 4, Direction.WEST, 0);

        String[] names = {"A","B","C","D"};
        for (int i=0; i<=3; i++){
            names[i].setColor(Color.BLUE);
        }//poo

        //adfjkfdsjnsdfnkfs

    }
}
