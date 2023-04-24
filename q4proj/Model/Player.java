package q4proj.Model;
import java.util.ArrayList;

public class Player {
  protected String name;
  protected String shape;
  protected int locationX, locationY, criticalMass;

  public static ArrayList<Player> playerList = new ArrayList<>();
  
  public Player(){
      name = null;
      shape = null;
      criticalMass = 0;
  }

  public Player(String n, String s, int CM){
    name = n;
    shape = s;
//    locationX = LX;
//    locationY = LY;
    criticalMass = CM;
    playerList.add(this);
  }

  public String getName(){
    return name;
  }

  public String getShape(){
    return shape;
  }

//  public int getLocationX(){
//    return locationX;
//  }
//
//  public int getLocationY(){
//    return locationY;
//  }

  public int getCriticalMass(){
    return criticalMass;
  }

  public void setName(String n){
    this.name = n;
  }

  public void setShape(String s){
    this.shape = s;
  }

//  public int setLocationX(){
//    return locationX;
//  }
//
//  public int setLocationY(){
//    return locationY;
//  }

  public void setCriticalMass(int c){
    this.criticalMass = c;
  }
  
  public void click(int x, int y) {
    Tile.play(x, y, this);
    Tile.nextTurn();
  }
  
  public void disperse(int x, int y){
      
  }
}