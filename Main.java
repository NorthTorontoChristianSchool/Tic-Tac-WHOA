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
        //int numsList[][] = { {2,0,0,1},{1,0,0,2},{2,0,0,1},{1,0,0,2} };
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

        String boardList[][] = {{"E", "", "", "C"},{"A", "", "", "G"},{"F", "", "", "D"},{"B", "", "", "H"}}; //1st [] is for group, 2nd [] is for spot in group
        //Get and validate the user's choice of where to move
        String robot, direction;
        Direction directionMoving;

        BetterRobot robotMoving = A;
        int robotsAround, robotName = 0, upOrDown = 0, rightOrLeft = 0, winningNum=10;
        int rowMoved = 0, columnMoved = 0, rowSum=0, columnSum=0;
        boolean loop = true, win = false;

        for(int rounds = 1; rounds < 1000; rounds++){ //note for Gelila: if nothing happens in the rounds loop, we can just use the moves loop and use modulus
            for(int moves = 1; moves < 3; moves++){ //move 1 by player 1, move 2 by player 2
                do{
                    //player one
                    if(moves == 1){
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

                    if (direction.equals("N")){
                        //directionMoving = Direction.NORTH;
                        robotsAround = robotMoving.getIntersection().getNeighbor(Direction.NORTH).countSims(IPredicate.anyRobot);
                        if (robotsAround>0 ||robotMoving.moveNorth()==false) { //if robots/wall is blocking the way
                            System.out.println("You cannot make that move, please pick again"); //make the move start again from here
                            loop = false;
                        }
                        else {
                            //robotMoving.moveNorth();
                            loop = true;
                            upOrDown = -1;
                            rightOrLeft = 0;
                        }
                    }
                    else if (direction.equals("S")){
                        //directionMoving = Direction.SOUTH;
                        robotsAround = robotMoving.getIntersection().getNeighbor(Direction.SOUTH).countSims(IPredicate.anyRobot);
                        if (robotsAround>0 ||robotMoving.moveSouth()==false) { //if robots/wall is blocking the way
                            System.out.println("You cannot make that move, please pick again"); //make the move start again from here
                            loop = false;
                        }
                        else {
                            //robotMoving.moveSouth();
                            loop = true;
                            upOrDown = 1;
                            rightOrLeft = 0;
                        }
                    }
                    else if (direction.equals("E")){
                        //directionMoving = Direction.EAST;
                        robotsAround = robotMoving.getIntersection().getNeighbor(Direction.EAST).countSims(IPredicate.anyRobot);
                        if (robotsAround>0 || robotMoving.moveEast()==false) { //if robots/wall is blocking the way
                            System.out.println("You cannot make that move, please pick again"); //make the move start again from here
                            loop = false;
                        }
                        else {
                            //robotMoving.moveEast();
                            loop = true;
                            upOrDown = 0;
                            rightOrLeft = 1;
                        }
                    }
                    else { //when choice is west
                        //directionMoving = Direction.WEST;
                        robotsAround = robotMoving.getIntersection().getNeighbor(Direction.WEST).countSims(IPredicate.anyRobot);
                        if (robotsAround>0 || robotMoving.moveWest() == false) { //if robots/wall is blocking the way
                            System.out.println("You cannot make that move, please pick again"); //make the move start again from here
                            loop = false;
                        }
                        else {
                            //robotMoving.moveWest();
                            loop = true;
                            upOrDown = 0;
                            rightOrLeft = -1;
                        }
                    }   
                } while (loop == false);

                //make the moves within the list
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

                            //to test if it's working right
                            System.out.println("left spot " + boardList[j][k]); 
                            System.out.println("in spot " + boardList[j+upOrDown][k+rightOrLeft]);

                            //end both loops
                            k = 4;
                            j = 4;//can you use break?
                        }
                    }
                }

                //check for row/column win
                rowSum=0; 
                columnSum=0;
                for(int j=0; j<4; j++){
                    columnSum += numsList[j][columnMoved];
                }
                for(int k=0; k<4; k++){
                    rowSum += numsList[rowMoved][k];
                }
                System.out.println("row sum is " + rowSum);
                System.out.println("column sum is " + columnSum);

                if(columnSum==13 || columnSum == 3){
                    if(((numsList[0][columnMoved] == numsList[1][columnMoved]) && (numsList[2][columnMoved]==1))  || ((numsList[3][columnMoved] == numsList[1][columnMoved]) && (numsList[2][columnMoved]==1))){
                        winningNum = 1;
                        System.out.println("column win");
                    }
                }
                else if(columnSum ==10 || columnSum == 1){
                    if(((numsList[0][columnMoved] == numsList[1][columnMoved]) && (numsList[2][columnMoved]==0))  || ((numsList[3][columnMoved] == numsList[1][columnMoved]) && (numsList[2][columnMoved]==0))){
                        winningNum = 0;
                        System.out.println("column win");
                    }
                }
                else if(rowSum==13 || rowSum==3){
                    if(((numsList[rowMoved][0] == numsList[rowMoved][1]) && (numsList[rowMoved][2]==1))  || ((numsList[rowMoved][3] == numsList[rowMoved][1]) && (numsList[rowMoved][2]==1))){
                        winningNum = 1;
                        System.out.println("row win");
                    }
                }
                else if(rowSum ==10 || rowSum == 1){ 
                    if(((numsList[rowMoved][0] == numsList[rowMoved][1]) && (numsList[rowMoved][2]==0))  || ((numsList[rowMoved][3] == numsList[rowMoved][1]) && (numsList[rowMoved][2]==0))){
                        winningNum = 0;
                        System.out.println("row win");
                    }
                }

                //diagonal win
                else if(rowMoved==columnMoved || java.lang.Math.abs(rowMoved-columnMoved) == 2){ 
                    if((numsList[0][0]==numsList[1][1] && numsList[1][1] == numsList[2][2]) || (numsList[3][3]==numsList[1][1] && numsList[1][1] == numsList[2][2])) {
                        winningNum = numsList[1][1];
                        System.out.println("middle diagonal left win");
                    }
                    else if ((numsList[2][0]==numsList[1][1] && numsList[1][1] == numsList[0][2] && numsList[1][1] != 10) || (numsList[3][1]==numsList[2][2] && numsList[2][2] == numsList[1][3] && numsList[1][1] != 10)){
                        winningNum = numsList[rowMoved][columnMoved];
                        System.out.println("side diagonal right win");
                    }    
                }
                else if (rowMoved+columnMoved == 3){
                    if((numsList[3][0]==numsList[2][1] && numsList[2][1] == numsList[1][2])  || (numsList[0][3]==numsList[2][1] && numsList[2][1] == numsList[1][2])){
                        winningNum = numsList[2][1];
                        System.out.println("middle diagonal right win");
                    }
                }
                else if (java.lang.Math.abs(rowMoved-columnMoved) == 1){
                    if((numsList[1][0]==numsList[2][1] && numsList[2][1] == numsList[3][2] && numsList[2][1] != 10) || (numsList[0][1]==numsList[1][2] && numsList[1][2] == numsList[2][3] && numsList[1][2] != 10)){
                        winningNum = numsList[2][1];
                        System.out.println("side diagonal left win");
                    }
                }

                //congratulate winner
                if (winningNum==1){
                    System.out.println("Player 1 Wins!!");
                }
                else if (winningNum==0){
                    System.out.println("Player 2 Wins!!");
                }
                System.out.println(winningNum);

                //checks for wins.
                //10 ways to win; 4 hor, 4 ver, 2 diag

                // if(robotName < 4){//player 1
                // winningNum = 1;
                // }
                // else{//player 2
                // winningNum = 2;
                // }

                //winning algorithm

                // //checks diagonals
                // if (numsList[0][0]==winningNum && numsList[1][1]==winningNum && numsList[2][2]==winningNum && numsList[3][3]==winningNum){
                // System.out.println("Player "+winningNum+" Wins Diagonally Down!");
                // win = true;
                // break;
                // }
                // else if (numsList[3][0]==winningNum && numsList[2][1]==winningNum && numsList[1][2]==winningNum && numsList[0][3]==winningNum){
                // System.out.println("Player "+winningNum+" Wins Diagonally Up!");
                // win = true;
                // break;
                // }
                // else {
                // for(int i=0; i<4; i++){
                // //checks rows
                // if (numsList[i][0]==winningNum && numsList[i][1]==winningNum && numsList[i][2]==winningNum && numsList[i][3]==winningNum){
                // System.out.println("Player "+winningNum+" Wins in Row " + (i+1) + "!");
                // win = true;
                // break;
                // }
                // //checks columns
                // else if (numsList[0][i]==winningNum && numsList[1][i]==winningNum && numsList[2][i]==winningNum && numsList[3][i]==winningNum){
                // System.out.println("Player "+winningNum+" Wins in Column " + (i+1) + "!");
                // win = true;
                // break;
                // }

                // }
                // }
                //if (win = true){break;}

            }
        }
    }
}