package q4proj.Model;
import java.util.ArrayList;
import javafx.scene.image.Image;

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
  
//  public void click(int x, int y) {
//    Tile.play(x, y, this);
//    Tile.nextTurn();
//  }
//  
  public void disperse(int x, int y){
      
  }
  
  public void updateTileView(int x, int y){
    if(Tile.grid[x][y].numberStatus>0 && !(Tile.grid[x][y].playerStatus.equals("empty"))){
        String filename = "q4proj/" + Tile.grid[x][y].playerStatus + Tile.grid[x][y].numberStatus + ".png";
        Image icon = new Image(filename);
        Tile.grid[x][y].tileView.setImage(icon);
    }
    else{
        String filename = "q4proj/emptytile.png";
        Image icon = new Image(filename);
        Tile.grid[x][y].tileView.setImage(icon);
    } 
  }
  
  public void updateIfTileExists(int x, int y, String shape){
      if((x>=0 && x<8) && (y>=0 && y<8)){
          Tile.grid[x][y].setPlayerStatus(shape);
          Tile.grid[x][y].setNumberStatus(Tile.grid[x][y].getNumberStatus() + 1);
          updateTileView(x,y);
      }
  }
}