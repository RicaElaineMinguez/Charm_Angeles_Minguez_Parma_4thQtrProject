package q4proj.Model;
import java.util.ArrayList;

public class Meteor extends Obstacle{
  
  private int[][] trajectory = new int[3][2];
  private int activationRound;
  public static ArrayList<Meteor> meteorList = new ArrayList<>();

  public Meteor(){
    activationRound = random.nextInt(20) + 1;
    
    int x1 = 0, y1 = 0, x2 = 0, y2 = 0, x3 = 0, y3 = 0;
    x1 = (random.nextInt(2))*7;
    y1 = (random.nextInt(2))*7;

    if(x1==0) {
      x2 = 1;
      x3 = 2;
    }
    else if(x1==7) {
      x2 = 6;
      x3 = 5;
    }
    if(y1==0) {
      y2 = 1;
      y3 = 2;
    }
    else if(y1==7) {
      y2 = 6;
      y3 = 5;
    }
    
    trajectory[0][0] = x1;
    trajectory[0][1] = y1;
    trajectory[1][0] = x2;
    trajectory[1][1] = y2;
    trajectory[2][0] = x3;
    trajectory[2][1] = y3;

    meteorList.add(this);
  }

  public int getActivationRound(){
    return activationRound;
  }
  
  public void erase(){
    if(this.activationRound == Tile.roundNum) {
      Tile.erase(this.trajectory[0][0], this.trajectory[0][1]);
      Tile.erase(this.trajectory[1][0], this.trajectory[1][1]);
      Tile.erase(this.trajectory[2][0], this.trajectory[2][1]);
    }
  }

}