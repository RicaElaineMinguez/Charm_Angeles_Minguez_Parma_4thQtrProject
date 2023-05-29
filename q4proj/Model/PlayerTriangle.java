package q4proj.Model;
public class PlayerTriangle extends Player{
  public PlayerTriangle(String n, int CM){
    super( n,"triangle", 3);
  }

  @Override
public void disperse(int x, int y) {
    if (Tile.grid[x][y].getNumberStatus() == Tile.grid[x][y].getCriticalMass()||Tile.grid[x][y].getNumberStatus() == criticalMass) { 

        Tile.grid[x][y].setPlayerStatus("empty");
        Tile.grid[x][y].setNumberStatus(0); 
        updateTileView(x,y);
        
        updateIfTileExists((x+1),(y), "triangle");
        updateIfTileExists((x-1),(y-1), "triangle");
        updateIfTileExists((x-1),(y+1), "triangle");
    } 

//  Tile.nextTurn();
}
}