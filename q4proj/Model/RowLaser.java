package q4proj.Model;
import java.util.Random;
import java.util.ArrayList;

public class RowLaser extends Laser{

  public RowLaser(){
    location = random.nextInt(7);
    laserList.add(this);
  }
  
  //to be called when the laser is clicked
  public void erase(){
    System.out.println(location);
    for (int i: trajectory) {
      Tile.erase(location, i);
    }
    Tile.nextTurn();
  }
}

//helpful resources:
//https://www.tutorialspoint.com/what-are-the-different-ways-to-iterate-over-an-array-in-java
//https://www.geeksforgeeks.org/java-util-arraylist-add-method-java/