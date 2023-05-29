package q4proj.Model;
public class PlayerCircle extends Player{
  public PlayerCircle(String n, int CM){
    super( n,"circle", 4);
  }

  @Override
  public void disperse(int x, int y) {
    if (Tile.grid[x][y].getNumberStatus() == Tile.grid[x][y].getCriticalMass()||Tile.grid[x][y].getNumberStatus() == criticalMass) { 

        Tile.grid[x][y].setPlayerStatus("empty");
        Tile.grid[x][y].setNumberStatus(0); 
        updateTileView(x,y);
        
        updateIfTileExists((x+1),(y), "circle");
        updateIfTileExists((x-1),(y), "circle");
        updateIfTileExists((x),(y+1), "circle");
        updateIfTileExists((x),(y-1), "circle");
    } 

//    Tile.nextTurn();
    
  }

}

