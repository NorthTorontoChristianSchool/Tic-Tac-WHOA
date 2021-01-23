*-*-*-*-*-*-*-*-*-*-*-*-*
 --- EPIC BOARD GAME ---
*-*-*-*-*-*-*-*-*-*-*-*-*

INHERITANCE, OVERLOADING, AND OVERRIDING

Inheritance was used in the BetterRobots class. It extends the Robots class. We added the
methods of faceNorth(), faceEast(), faceSouth(), and faceWest(). Overloading was used in 
this class with the redefinition of the move() method. Now, you can enter a direction to 
specify where you want the robot to move. Overriding was used in the method breakRobot(). 
Originally, it was a protected method which "broke" the robot if it tried to run into a
wall, for example. We changed it to a "loser dance" that is used on the robots of the 
player who lost.

HOW THE CHECKING ALGORITHM WORKS

