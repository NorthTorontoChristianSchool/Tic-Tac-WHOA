import becker.robots.*;
import java.util.*; 
import java.awt.Color;
import becker.robots.icons.*;
public class Main
{
    public static void main(String[] args)
    {
        //SETTING UP THE BOARD

        for (int i=0;i<=25;i++){//clearing the screen
        System.out.println("");
        }
        System.out.println("Welcome to Epic Board Game! Please press start.");
        Colours board = new Colours(6,6);
        Scanner in = new Scanner(System.in);
        board.setFrameTitle("Game");
        
        //RobotIcon robo = new RobotIcon(Color.BLUE, 0.8);
        
        //creating the walls of the board game
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
        BetterRobot A = new BetterRobot(board, 2, 1, Direction.NORTH, 0);
        BetterRobot B = new BetterRobot(board, 4, 1, Direction.NORTH, 0);
        BetterRobot C = new BetterRobot(board, 1, 4, Direction.NORTH, 0);
        BetterRobot D = new BetterRobot(board, 3, 4, Direction.NORTH, 0);
        //p2
        BetterRobot E = new BetterRobot(board, 1, 1, Direction.NORTH, 0);
        BetterRobot F = new BetterRobot(board, 3, 1, Direction.NORTH, 0);
        BetterRobot G = new BetterRobot(board, 2, 4, Direction.NORTH, 0);
        BetterRobot H = new BetterRobot(board, 4, 4, Direction.NORTH, 0);

        BetterRobot[] roboNames = {A,B,C,D,E,F,G,H};
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
        Direction directionMoving;
        BetterRobot robotMoving = A; //made it equal A because later it said the variable hadn't been initialized
        int robotsAround; 
        boolean loop = true;

        for(int rounds = 1; rounds < 1000; rounds++){
            for(int moves = 1; moves < 3; moves++){
                //player one
                do{
                    if(moves % 2 != 0){
                        do {
                            System.out.println("Player 1 (green), which piece would you like to move? (A, B, C, or D)");
                            p1robot = in.nextLine();
                        } while (!p1robot.equals("A") && !p1robot.equals("B") && !p1robot.equals("C") && !p1robot.equals("D"));

                        do {
                            System.out.println("Player 1, would you like to move north(n), south(s), east(e) or west(w)?");
                            p1direction = in.nextLine();

                        } while (!p1direction.equals("n") && !p1direction.equals("s") && !p1direction.equals("e") && !p1direction.equals("w"));

                        //figure out which robot was chosen by player 1
                        for (int i = 0; i<4; i++){
                            if (strNames[i].equals(p1robot)){
                                robotMoving = roboNames[i];
                            }
                        }
                    }

                    else{
                        do {
                            System.out.println("Player 2 (orange), which piece would you like to move? (E, F, G, or H)");
                            p1robot = in.nextLine();
                        } while (!p1robot.equals("E") && !p1robot.equals("F") && !p1robot.equals("G") && !p1robot.equals("H"));

                        do {
                            System.out.println("Player 2, would you like to move north(n), south(s), east(e) or west(w)?");
                            p1direction = in.nextLine();

                        } while (!p1direction.equals("n") && !p1direction.equals("s") && !p1direction.equals("e") && !p1direction.equals("w"));

                        //figure out which robot was chosen by player 2
                        for (int i=4; i<8; i++){
                            if (strNames[i].equals(p1robot)){
                                robotMoving = roboNames[i];
                            }
                        }

                    }

                    if (p1direction.equals("n")){
                        //directionMoving = Direction.NORTH;
                        robotsAround = robotMoving.getIntersection().getNeighbor(Direction.NORTH).countSims(IPredicate.anyRobot);
                        if (robotsAround>0 ||robotMoving.moveNorth()==false) { //if robots/wall is blocking the way
                            System.out.println("You cannot make that move, please pick again"); //need to make the move start again from here
                            loop = false;
                        }
                        else {
                            //robotMoving.moveNorth();
                            loop = true;
                        }
                    }
                    else if (p1direction.equals("s")){
                        //directionMoving = Direction.SOUTH;
                        robotsAround = robotMoving.getIntersection().getNeighbor(Direction.SOUTH).countSims(IPredicate.anyRobot);
                        if (robotsAround>0 ||robotMoving.moveSouth()==false) { //if robots/wall is blocking the way
                            System.out.println("You cannot make that move, please pick again"); //need to make the move start again from here
                            loop = false;
                        }
                        else {
                            //robotMoving.moveSouth();
                            loop = true;
                        }
                    }
                    else if (p1direction.equals("e")){
                        //directionMoving = Direction.EAST;
                        robotsAround = robotMoving.getIntersection().getNeighbor(Direction.EAST).countSims(IPredicate.anyRobot);
                        if (robotsAround>0 || robotMoving.moveEast()==false) { //if robots/wall is blocking the way
                            System.out.println("You cannot make that move, please pick again"); //need to make the move start again from here
                            loop = false;
                        }
                        else {
                            //robotMoving.moveEast();
                            loop = true;
                        }
                    }
                    else { //when choice is west
                        //directionMoving = Direction.WEST;
                        robotsAround = robotMoving.getIntersection().getNeighbor(Direction.WEST).countSims(IPredicate.anyRobot);
                        if (robotsAround>0 || robotMoving.moveWest() == false) { //if robots/wall is blocking the way
                            System.out.println("You cannot make that move, please pick again"); //need to make the move start again from here
                            loop = false;
                        }
                        else {
                            //robotMoving.moveWest();
                            loop = true;
                        }
                    }

                    
                } while (loop == false);
            }
        }
    }
}