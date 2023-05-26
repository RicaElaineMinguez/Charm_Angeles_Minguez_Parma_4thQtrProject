package q4proj.Model;
public class PlayerCircle extends Player{
  public PlayerCircle(String n, int CM){
    super( n,"circle", 4);
  }

  @Override
  public void disperse(int x, int y) {
    if (Tile.grid[x][y].getNumberStatus() == Tile.grid[x][y].getCriticalMass()||Tile.grid[x][y].getNumberStatus() == criticalMass) { 
      Tile.grid[x+1][y].setPlayerStatus("circle");
       Tile.grid[x-1][y].setPlayerStatus("circle");
      Tile.grid[x][y+1].setPlayerStatus("circle");
       Tile.grid[x][y-1].setPlayerStatus("circle");

      Tile.grid[x+1][y].setNumberStatus(Tile.grid[x+1][y].getNumberStatus() + 1);
       Tile.grid[x-1][y].setNumberStatus(Tile.grid[x-1][y].getNumberStatus() + 1);
       Tile.grid[x][y+1].setNumberStatus(Tile.grid[x][y+1].getNumberStatus() + 1);
       Tile.grid[x][y-1].setNumberStatus(Tile.grid[x][y-1].getNumberStatus() + 1);

      Tile.grid[x][y].setPlayerStatus("empty");
      Tile.grid[x][y].setNumberStatus(0);
    } 

    Tile.nextTurn();
    
  }

}

