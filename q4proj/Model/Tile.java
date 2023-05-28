package q4proj.Model;

import q4proj.Screen4Controller;
import javafx.scene.image.*;

public class Tile {
  public String playerStatus;
  public int criticalMass, numberStatus;
  public static int roundNum = 1;
  public ImageView tileView;
  
  //make location a 2d array of ints
  public static Tile[][] grid = new Tile[8][8];

  public String getPlayerStatus(){
    return playerStatus;
  }

  public void setPlayerStatus(String n){
    this.playerStatus = n;
  }

  public int getCriticalMass(){
    return criticalMass;
  }

  public void setCriticalMass(int n){
    this.criticalMass = n;
  }

  public int getNumberStatus(){
    return numberStatus;
  }

  public void setNumberStatus(int n){
    this.numberStatus = n;
  }
  
  public void incNumberSatus() {
      this.numberStatus++;
  }

  public int getRoundNum(){
    return roundNum;
  }
  
  public static void incRoundNum() {
      roundNum++;
  }
  
  
  public static void makeGrid() {
    
    for(int x = 0; x < 8; x++) {
      for(int y = 0; y < 8; y++) {
        
        Tile tile = new Tile();
        grid[x][y] = tile;
        tile.numberStatus = 0;
        tile.playerStatus = "empty";
//        Screen4Controller.board.add(tile.icon,y,x);
        
//        tile.icon.setOnMouseClicked(event -> {
//            ImageView source = (ImageView) event.getTarget();
////            int columnIndex = GridPane.getColumnIndex(source);
////            int rowIndex = GridPane.getRowIndex(source);
//            Image icon = new Image("../q4proj/circle1.png");
//            source.setImage(icon);
//        });
        
        tile.initializeCriticalMass(x, y);
        
      }
    }
  }
  
  public void initializeCriticalMass(int x, int y){
      if((x == 0 || x == 7) && (y > 0 && y < 7)) {
          this.criticalMass = 3;
        }
        else if((y == 0 || y == 7) && (x > 0 && x < 7)) {
          this.criticalMass = 3;
        }
        else if((x == 0 || x == 7) && (y == 0 && y == 7)) {
          this.criticalMass = 2;
        }
        else this.criticalMass = 4;
  }

  public static void erase(int x, int y) {
    grid[x][y].numberStatus = 0;
    grid[x][y].playerStatus = "empty";
  }

  public static void play(int x, int y, Player A){
      
    if(grid[x][y].playerStatus == "empty" || grid[x][y].playerStatus == A.getShape()){
        
      grid[x][y].numberStatus++;
      grid[x][y].playerStatus = A.getShape();
      
      if(grid[x][y].numberStatus < A.getCriticalMass() && grid[x][y].numberStatus < grid[x][y].criticalMass){
      String filename = "q4proj/" + grid[x][y].playerStatus + grid[x][y].numberStatus + ".png";
      Image icon = new Image(filename);
      grid[x][y].tileView.setImage(icon);
      }
      
      else A.disperse(x, y);
    }
  }
  
  public static void nextTurn() {
    roundNum++;
    Laser.laserList.forEach((a) -> a.shift());
    Meteor.meteorList.forEach((a) -> a.erase());
  }

  
}

//list of helpful resources
//https://www.w3schools.com/java/java_arrays_multi.asp
//https://www.geeksforgeeks.org/math-pow-method-in-java-with-example/
//https://stackoverflow.com/questions/29226036/java-storing-objects-in-a-multidimensional-array