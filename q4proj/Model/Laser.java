package q4proj.Model;
import java.util.ArrayList;
import javafx.scene.image.ImageView;

public abstract class Laser extends Obstacle{
  
  protected static int[] trajectory = {0, 1, 2, 3, 4, 5, 6, 7};
  public static ArrayList<Laser> laserList = new ArrayList<>();
  public String status;
  public ImageView space;
  
  public abstract void erase(); //to be called when the laser is clicked
  
  public void shift(){
    this.location++;
    this.location %= 7;
  }
  
  public void activate(){
      this.status = "active";
  }
  public void deactivate(){
      this.status = "inactive";
  }
  
}

//helpful resources:
//https://docs.oracle.com/javase/7/docs/api/java/util/Random.html
//https://www.geeksforgeeks.org/generating-random-numbers-in-java/
//https://www.javatpoint.com/how-to-generate-random-number-in-java