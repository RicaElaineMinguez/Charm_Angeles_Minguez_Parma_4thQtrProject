package q4proj.Model;

import javafx.scene.image.Image;

public class PlayerSquare extends Player{
  public PlayerSquare(String n, int CM){
    super( n,"square", 4);
  }

  @Override
  public void disperse(int x, int y) {
    if (Tile.grid[x][y].getNumberStatus() == Tile.grid[x][y].getCriticalMass()||Tile.grid[x][y].getNumberStatus() == criticalMass) {
            
        Tile.grid[x][y].setPlayerStatus("empty");
        Tile.grid[x][y].setNumberStatus(0); 
        updateTileView(x,y);
        
        updateIfTileExists((x+1),(y+1), "square");
        updateIfTileExists((x+1),(y-1), "square");
        updateIfTileExists((x-1),(y+1), "square");
        updateIfTileExists((x-1),(y-1), "square");
    }

//    Tile.nextTurn();
    
  }
  
  
}