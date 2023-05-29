package q4proj.Model;
import java.util.Random;

public abstract class Obstacle{
  Random random = new Random();
  
  public int location; //changed protected to public
  public abstract void erase();

  public int getLocation(){
    return location;
  }
}