*-*-*-*-*-*-*-*-*-*-*-*-*
 --- EPIC BOARD GAME ---
*-*-*-*-*-*-*-*-*-*-*-*-*

INHERITANCE, OVERLOADING, AND OVERRIDING

Inheritance was used in the BetterRobots class. It extends the Robots class. We added the
methods of faceNorth(), faceEast(), faceSouth(), and faceWest() and used them when moving the game pieces. We also added a method called victoryDance(), which made the robot spin, change colours, and display the label "WINNER" as a celebration for the person who won.

Overloading was used in this class with the redefinition of the move() method. It now takes a string argument, allowing the user to enter a direction to specify where you want the robot to move. 

Overriding was used in the method breakRobot(). Originally, it was a protected method which "broke" the robot if it tried to run into a wall, for example. We changed it to a "loser dance" that is used on the robots of the player who lost.

HOW THE CHECKING ALGORITHM WORKS

To check for a win across a row or down a column, we used the sum of the numbers in that row/column. 1 represented player one, 0 represented player two, and 10 represented a blank space. We realized that for a row/column win, if the sum was 3 or 13 then there must be three ones and if the sum was 1 or 10 then there must be three zeros. From there we checked if there were three consecutive instances of 1 or 0 in order to check if there was a win and who won. We also noticed a pattern of increasing row and column numbers when going up a diagonal tilted to the right, and other similar patterns for the other diagonals that allowed us to check if there was a diagonal win. 