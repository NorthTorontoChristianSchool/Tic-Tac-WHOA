import becker.robots.*;
import java.util.*; 
import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class Main
{
    public static void main(String[] args)
    {

        //SETTING UP THE BOARD

        for (int i=0;i<=25;i++){//clearing the screen
            System.out.println("");
        }
        System.out.println("Welcome to Epic Board Game! Please press start.");
        System.out.println("The first player who lines up three of their pieces wins!");
        Colours board = new Colours(6,6);
        Scanner in = new Scanner(System.in);
        board.setFrameTitle("Game");

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
        int numsList[][] = { {0,10,10,1},{1,10,10,0},{0,10,10,1},{1,10,10,0} };

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
        //setting speed
        for(int i=0; i<8; i++){
            roboNames[i].setSpeed(20);
        }
        String boardList[][] = {{"E", "", "", "C"},{"A", "", "", "G"},{"F", "", "", "D"},{"B", "", "", "H"}}; //1st [] is for group, 2nd [] is for spot in group
        //Get and validate the user's choice of where to move
        String robot, direction;
        Direction directionMoving, roboDir;

        BetterRobot robotMoving = A;
        int robotsAround, robotName = 0, upOrDown = 0, rightOrLeft = 0, winningNum=10;
        int rowMoved = 0, columnMoved = 0, rowSum=0, columnSum=0;
        boolean loop = true, win = false;

        //for(int rounds = 1; rounds < 1000; rounds++){ //note for Gelila: if nothing happens in the rounds loop, we can just use the moves loop and use modulus
        for(int moves = 0; moves < 1000; moves++){ //move 1 by player 1, move 2 by player 2
            do{
                //player one
                if(moves % 2 == 0){
                    do {
                        System.out.println("Player 1 (green), which piece would you like to move? (A, B, C, or D)");
                        robot = in.nextLine();
                    } while (!robot.equals("A") && !robot.equals("B") && !robot.equals("C") && !robot.equals("D"));

                    do {
                        System.out.println("Player 1, would you like to move north(N), south(S), east(E) or west(W)?");
                        direction = in.nextLine();

                    } while (!direction.equals("N") && !direction.equals("S") && !direction.equals("E") && !direction.equals("W"));
                }

                //player two
                else{
                    do {
                        System.out.println("Player 2 (orange), which piece would you like to move? (E, F, G, or H)");
                        robot = in.nextLine();
                    } while (!robot.equals("E") && !robot.equals("F") && !robot.equals("G") && !robot.equals("H"));

                    do {
                        System.out.println("Player 2, would you like to move north(N), south(S), east(E) or west(W)?");
                        direction = in.nextLine();

                    } while (!direction.equals("N") && !direction.equals("S") && !direction.equals("E") && !direction.equals("W"));
                }

                //figure out which robot was chosen
                for (int i = 0; i<8; i++){
                    if (strNames[i].equals(robot)){
                        robotMoving = roboNames[i];
                        robotName = i;
                        break;
                    }
                }
                
                //translates inputted direction (String) into a Direction
                if(direction.equals("N")){
                    roboDir = Direction.NORTH;
                }
                else if(direction.equals("E")){
                    roboDir = Direction.EAST;
                }
                else if(direction.equals("S")){
                    roboDir = Direction.SOUTH;
                }
                else {roboDir = Direction.WEST;}
                
                //checks if the desired direction is clear
                robotsAround = robotMoving.getIntersection().getNeighbor(roboDir).countSims(IPredicate.anyRobot);
                if (robotsAround>0 ||robotMoving.move(direction)==false) { //if robots/wall is blocking the way
                        System.out.println("You cannot make that move, please pick again"); //make the move start again from here
                        loop = false;
                    }
                
                else if (direction.equals("N")){
                        loop = true;
                        upOrDown = -1;
                        rightOrLeft = 0;
                }
                else if (direction.equals("S")){
                        loop = true;
                        upOrDown = 1;
                        rightOrLeft = 0;
                }
                else if (direction.equals("E")){
                        loop = true;
                        upOrDown = 0;
                        rightOrLeft = 1;
                }
                else { //when choice is west
                        loop = true;
                        upOrDown = 0;
                        rightOrLeft = -1;
                }   
            } while (loop == false);

            //EDITING ARRAYS TO REFLECT MOVES ON THE BOARD
            for (int j = 0; j<boardList.length; j++){ //traverse through board list to locate the robot chosen
                for(int k = 0; k<boardList.length; k++){
                    if (strNames[robotName].equals(boardList[j][k])){

                        //updating the list of plain ints so that we can check for wins
                        if( boardList[j][k] == "A"|| boardList[j][k] =="B"||boardList[j][k] =="C"||boardList[j][k] =="D" ){
                            numsList[j+upOrDown][k+rightOrLeft] = 1;
                        }
                        else if( boardList[j][k] == "E"|| boardList[j][k] =="F"||boardList[j][k] =="G"||boardList[j][k] =="H" ){ 
                            numsList[j+upOrDown][k+rightOrLeft] = 0;
                        }
                        numsList[j][k] = 10;

                        rowMoved = j+upOrDown;
                        columnMoved = k+rightOrLeft;

                        boardList[j+upOrDown][k+rightOrLeft] = boardList[j][k]; //move letter to empty space
                        boardList[j][k] = ""; //replace space where letter was with an empty space
                        //end both loops
                        k = 4;
                        j = 4;
                    }
                }
            }

            //CHECKING WINS ALGORITHM
            //check for row/column win
            rowSum=0; 
            columnSum=0;
            for(int j=0; j<4; j++){
                columnSum += numsList[j][columnMoved];
            }
            for(int k=0; k<4; k++){
                rowSum += numsList[rowMoved][k];
            }

                //column wins
            if(columnSum==13 || columnSum == 3){
                if(((numsList[0][columnMoved] == numsList[1][columnMoved]) && (numsList[2][columnMoved]==1))  || ((numsList[3][columnMoved] == numsList[1][columnMoved]) && (numsList[2][columnMoved]==1))){
                    winningNum = 1;
                }
            }
            else if(columnSum ==10 || columnSum == 1){
                if(((numsList[0][columnMoved] == numsList[1][columnMoved]) && (numsList[2][columnMoved]==0))  || ((numsList[3][columnMoved] == numsList[1][columnMoved]) && (numsList[2][columnMoved]==0))){
                    winningNum = 0;
                }
                //row wins
            }
            else if(rowSum==13 || rowSum==3){
                if(((numsList[rowMoved][0] == numsList[rowMoved][1]) && (numsList[rowMoved][2]==1))  || ((numsList[rowMoved][3] == numsList[rowMoved][1]) && (numsList[rowMoved][2]==1))){
                    winningNum = 1;
                }
            }
            else if(rowSum ==10 || rowSum == 1){ 
                if(((numsList[rowMoved][0] == numsList[rowMoved][1]) && (numsList[rowMoved][2]==0))  || ((numsList[rowMoved][3] == numsList[rowMoved][1]) && (numsList[rowMoved][2]==0))){
                    winningNum = 0;
                }
            }

            //diagonal wins
            else if(rowMoved==columnMoved || java.lang.Math.abs(rowMoved-columnMoved) == 2){ 
                if((numsList[0][0]==numsList[1][1] && numsList[1][1] == numsList[2][2]) || (numsList[3][3]==numsList[1][1] && numsList[1][1] == numsList[2][2])) {
                    winningNum = numsList[1][1];
                }
                else if ((numsList[2][0]==numsList[1][1] && numsList[1][1] == numsList[0][2] && numsList[1][1] != 10) || (numsList[3][1]==numsList[2][2] && numsList[2][2] == numsList[1][3] && numsList[2][2] != 10)){
                    winningNum = numsList[rowMoved][columnMoved];
                }    
            }
            else if (rowMoved+columnMoved == 3){
                if((numsList[3][0]==numsList[2][1] && numsList[2][1] == numsList[1][2])  || (numsList[0][3]==numsList[2][1] && numsList[2][1] == numsList[1][2])){
                    winningNum = numsList[2][1];
                }
            }
            else if (java.lang.Math.abs(rowMoved-columnMoved) == 1){
                if((numsList[1][0]==numsList[2][1] && numsList[2][1] == numsList[3][2] && numsList[2][1] != 10) || (numsList[0][1]==numsList[1][2] && numsList[1][2] == numsList[2][3] && numsList[1][2] != 10)){
                    winningNum = numsList[2][1];
                }
            }

            //congratulate winner
            if (winningNum==1){//if p1 is the winner
                System.out.println("Player 1 Wins!!");
                win = true;
                for (int i=0; i<4; i++)
                {
                    roboNames[i].victoryDance();
                }
                for (int i=4; i<8; i++)
                {
                    roboNames[i].breakRobot();
                }
                System.exit(0);
            }

            else if (winningNum==0){//if p2 is the winner
                System.out.println("Player 2 Wins!!");
                win = true;
                for (int i=4; i<8; i++)
                {
                    roboNames[i].victoryDance();
                }
                for (int i=0; i<4; i++)
                {
                    roboNames[i].breakRobot();
                }
                System.exit(0);
            }
        }
    }
}