package q4proj.Model;

import javafx.scene.image.Image;

public class PlayerSquare extends Player{
  public PlayerSquare(String n, int CM){
    super( n,"square", 4);
  }

  @Override
  public void disperse(int x, int y) {
    if (Tile.grid[x][y].getNumberStatus() == Tile.grid[x][y].getCriticalMass()||Tile.grid[x][y].getNumberStatus() == criticalMass) {
        
        Tile.grid[x+1][y-1].setPlayerStatus("square");        
        Tile.grid[x+1][y+1].setPlayerStatus("square");
        Tile.grid[x-1][y+1].setPlayerStatus("square");
        Tile.grid[x-1][y-1].setPlayerStatus("square");

        Tile.grid[x+1][y-1].setNumberStatus(Tile.grid[x+1][y-1].getNumberStatus() + 1);
        Tile.grid[x+1][y+1].setNumberStatus(Tile.grid[x+1][y+1].getNumberStatus() + 1);
        Tile.grid[x-1][y+1].setNumberStatus(Tile.grid[x-1][y+1].getNumberStatus() + 1);
        Tile.grid[x-1][y-1].setNumberStatus(Tile.grid[x-1][y-1].getNumberStatus() + 1);

        Tile.grid[x][y].setPlayerStatus("empty");
        Tile.grid[x][y].setNumberStatus(0);
        
        updateTileView(x,y);
        updateTileView((x+1),(y+1));
        updateTileView((x+1),(y-1));
        updateTileView((x-1),(y+1));
        updateTileView((x-1),(y-1));
    }

    Tile.nextTurn();
    
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
}