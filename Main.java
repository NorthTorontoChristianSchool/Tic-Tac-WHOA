import becker.robots.*;
import java.util.*; 
import java.awt.Color;
public class Main
{
    public static void main(String[] args)
    {
        //SETTING UP THE BOARD
        
        Colours board = new Colours(7,7);
        Intersection road = new Intersection(board,7,7);
        board.setFrameTitle("Game");
        Scanner in = new Scanner(System.in);

        //creating the walls of the board game
<<<<<<< Updated upstream
        City board = new City(6,6);
        board.setFrameTitle("Game");
=======

>>>>>>> Stashed changes
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
        
        //PUTTING ROBOTS ON THE BOARD
        //p1
        Robot A = new Robot(board, 2, 1, Direction.NORTH, 0);
        Robot B = new Robot(board, 4, 1, Direction.NORTH, 0);
        Robot C = new Robot(board, 1, 4, Direction.NORTH, 0);
        Robot D = new Robot(board, 3, 4, Direction.NORTH, 0);
        //p2
        Robot E = new Robot(board, 1, 1, Direction.NORTH, 0);
        Robot F = new Robot(board, 3, 1, Direction.NORTH, 0);
        Robot G = new Robot(board, 2, 4, Direction.NORTH, 0);
        Robot H = new Robot(board, 4, 4, Direction.NORTH, 0);

        Robot[] roboNames = {A,B,C,D,E,F,G,H};
        String[] strNames = {"A","B","C","D","E","F","G","H"};
        //p1
        for (int i=0; i<=3; i++){
            roboNames[i].setColor(Color.GREEN);
            roboNames[i].setLabel(strNames[i]);
        }
        //p2
        for (int i=4; i<=7; i++){
            roboNames[i].setColor(Color.ORANGE);
            roboNames[i].setLabel(strNames[i]);
        }

        int boardList[][] = {{1, 0, 0, 2},{2, 0, 0, 1},{1, 0, 0, 2},{2, 0, 0, 1}}; //1st [] is for group, 2nd [] is for spot in group
        //Get and validate the user's choice of where to move
        String p1direction, p2direction;
        String p1robot, p2robot;
       
        //player one
        do {
            System.out.println("Player 1 (green), which piece would you like to move? (a, b, c, or d)");
            p1robot = in.nextLine();
        } while (!p1robot.equals("a") && !p1robot.equals("b") && !p1robot.equals("c") && !p1robot.equals("d"));
         
        do {
            System.out.println("Player 1, would you like to move north(n), south(s), east(e) or west(w)?");
            p1direction = in.nextLine();

        } while (!p1direction.equals("n") && !p1direction.equals("s") && !p1direction.equals("e") && !p1direction.equals("w")); 

        //player two
        do {
                System.out.println("Player 2, would you like to move north(n), south(s), east(e) or west(w)?");
                p1direction = in.nextLine();

        } while (!p1direction.equals("n") && !p1direction.equals("s") && !p1direction.equals("e") && !p1direction.equals("w"));
        
        do {
            System.out.println("Player 1 (green), which piece would you like to move? (a, b, c, or d)");
            p1robot = in.nextLine();
        } while (!p1robot.equals("a") && !p1robot.equals("b") && !p1robot.equals("c") && !p1robot.equals("d"));

        
        
    }
}


