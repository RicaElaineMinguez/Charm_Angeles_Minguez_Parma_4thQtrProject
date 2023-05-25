package q4proj.Model;
import java.util.Random;

public abstract class Obstacle{
  Random random = new Random();
  
  protected int location;
  public abstract void erase();

  public int getLocation(){
    return location;
  }
}