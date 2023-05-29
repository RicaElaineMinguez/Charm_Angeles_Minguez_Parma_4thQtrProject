/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package q4proj;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.*;
import java.util.ArrayList;
import q4proj.Model.*;
import java.util.Random;   


/**
 *
 * @author briep
 */
public class Screen4Controller implements Initializable {

    @FXML private Button back;
    @FXML public GridPane board;
    @FXML public GridPane laserCol1;
    @FXML public GridPane laserCol2;
    @FXML public GridPane laserRow1;
    @FXML public GridPane laserRow2;
    private ArrayList<ImageView> LCimgs1 = new ArrayList(8);
    private ArrayList<ImageView> LCimgs2 = new ArrayList(8);
    private ArrayList<ImageView> LR1imgs = new ArrayList(8);
    private ArrayList<ImageView> LR2imgs = new ArrayList(8);
    private ArrayList<ImageView> realBoard = new ArrayList(64);
    
    Random randomizer = new Random();
    int laserLocation = randomizer.nextInt(32);
    int line = laserLocation/8;
    int spot = laserLocation%8;
    
    static String win = null;
        
    @FXML
    private void backWindow(ActionEvent event)throws IOException{
        Node node = (Node) event.getSource();
        Scene currentScene = node.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Screen1.fxml"));
        Scene playScene = new Scene(root);
        currentStage.hide();
        currentStage.setScene(playScene);
        currentStage.show();   
    }

    @FXML
    private void Screen5Window(ActionEvent event)throws IOException{
        Node node = (Node) event.getSource();
        Scene currentScene = node.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Screen5.fxml"));
        Scene playScene = new Scene(root);
        currentStage.hide();
        currentStage.setScene(playScene);
        currentStage.show();   
    }

    @FXML
    public void makeBoard() {
        
        
        
        Tile.makeGrid();

        for(int i=0; i<64; i++){
            ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("emptytile.png")));
            icon.setFitHeight(30);
            icon.setFitWidth(30);
            realBoard.add(icon);
            int row = i/8;
            int col = i%8;
            board.add(icon,col,row);
            System.out.println("create");
            
            //new addition: integrate board gridpane w/ grid of Tiles
            Tile.grid[row][col].tileView = icon;

            icon.setOnMouseClicked(event -> {
                System.out.println("click");
                ImageView source = (ImageView) event.getTarget();
                int imageNum = realBoard.indexOf(source);
                int x = imageNum/8;
                int y = imageNum%8;
                Player playerturn;
                
                if(Tile.roundNum%2 == 1) {
                    playerturn = Player.playerList.get(0);   
                }
                else {
                    playerturn = Player.playerList.get(1);   
                }
                
                
                Tile.play(x, y, playerturn);
                                
                Tile.incRoundNum();
                shiftLaser(line, spot);
                int newLocation = ((line*8)+spot+1)%32;
                line = newLocation/8;
                spot = newLocation%8;
                
                if(Tile.roundNum==20) checkWin(win);
            });
        }
  }
    
    
     @FXML 
    private void laserCol1(){ 
        
            for(int i=0; i<8; i++){
                ColLaser laserY = new ColLaser();
                laserY.deactivate();
                ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("emptytile.png")));
                laserY.space = icon;
                laserY.location = i;
                icon.setFitHeight(30);
                icon.setFitWidth(30);
                LCimgs1.add(icon);
                int row = i;
                int col = 0;
                laserCol1.add(icon,col,row);
                System.out.println("col");
                
                icon.setOnMouseClicked(event -> {
                    ImageView source = (ImageView) event.getTarget();
                    for (Laser L : Laser.laserList){
                        if(L.space==source && L.status.equals("active")) {
                            System.out.println("laser");
                            for(int y=0; y<8; y++){
                                int x = L.getLocation();
                                Tile target = Tile.grid[x][y];
                                System.out.println(target.getPlayerStatus());
                
                                target.numberStatus = 0;
                                target.playerStatus = "empty";
                                                                
                                Image tileicon = new Image("q4proj/emptytile.png");
                                target.tileView.setImage(tileicon);
                            }
                        }
                    }
                });
            }
    }
    
             @FXML 
    private void laserCol2(){ 
        
            for(int i=0; i<8; i++){
                ColLaser laserY = new ColLaser();
                laserY.deactivate();
                ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("emptytile.png")));
                laserY.space = icon;
                laserY.location = i;
                icon.setFitHeight(30);
                icon.setFitWidth(30);
                LCimgs2.add(icon);
                int row = i;
                int col = 0;
                laserCol2.add(icon,col,row);
                System.out.println("col"); 
                
                icon.setOnMouseClicked(event -> {
                    ImageView source = (ImageView) event.getTarget();
                    for (Laser L : Laser.laserList){
                        if(L.space==source && L.status.equals("active")) {
                            System.out.println("laser");
                            for(int y=0; y<8; y++){
                                int x = L.getLocation();
                                System.out.println(y);
                                Tile target = Tile.grid[x][y];
                                System.out.println(target.getPlayerStatus());
                
                                target.numberStatus = 0;
                                target.playerStatus = "empty";
                                                                
                                Image tileicon = new Image("q4proj/emptytile.png");
                                target.tileView.setImage(tileicon);
                            }
                        }
                    }
                });
            }
    }
    
             @FXML 
    private void laserRow1(){ 
        
            for(int i=0; i<8; i++){
                RowLaser laserX = new RowLaser();
                laserX.deactivate();
                ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("emptytile.png")));
                laserX.space = icon;
                laserX.location = i;
                icon.setFitHeight(30);
                icon.setFitWidth(30);
                LR1imgs.add(icon);
                int row = 0;
                int col = i;
                laserRow1.add(icon,col,row);
                System.out.println("row"); 
                
                icon.setOnMouseClicked(event -> {
                    ImageView source = (ImageView) event.getTarget();
                    for (Laser L : Laser.laserList){
                        if(L.space==source && L.status.equals("active")) {
                            System.out.println("laser");
                            for(int x=0; x<8; x++){
                                int y = L.getLocation();
                                Tile target = Tile.grid[x][y];
                                System.out.println(target.getPlayerStatus());
                
                                target.numberStatus = 0;
                                target.playerStatus = "empty";
                                                                
                                Image tileicon = new Image("q4proj/emptytile.png");
                                target.tileView.setImage(tileicon);
                            }
                        }
                    }
                });
            }
    }
    
             @FXML 
    private void laserRow2(){ 
        
            for(int i=0; i<8; i++){
                RowLaser laserX = new RowLaser();
                laserX.deactivate();
                ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("emptytile.png")));
                laserX.space = icon;
                laserX.location = i;
                icon.setFitHeight(30);
                icon.setFitWidth(30);
                LR2imgs.add(icon);
                int row = 0;
                int col = i;
                laserRow2.add(icon,col,row);
                System.out.println("row"); 
                
                icon.setOnMouseClicked(event -> {
                    ImageView source = (ImageView) event.getTarget();
                    for (Laser L : Laser.laserList){
                        if(L.space==source && L.status.equals("active")) {
                            System.out.println("laser");
                            for(int x=0; x<8; x++){
                                int y = L.getLocation();
                                Tile target = Tile.grid[x][y];
                                System.out.println(target.getPlayerStatus());
                
                                target.numberStatus = 0;
                                target.playerStatus = "empty";
                                                                
                                Image tileicon = new Image("q4proj/emptytile.png");
                                target.tileView.setImage(tileicon);
                            }
                        }
                    }
                });
            }
    }
    
    private void initializeLaser(int line, int spot){
        laserRow1();
        laserRow2();
        laserCol1();
        laserCol2();

        
        System.out.println("Line: " + line + "; Spot: " + spot);
        
        ImageView location;
        
        
        switch (line) {
            case 0:
                {
                    Image laser = new Image("q4proj/lasertop.png");
                    location = LR1imgs.get(spot);
                    location.setImage(laser);
                    for (Laser L : Laser.laserList){
                        if(L.space==location) L.activate();
                    }
                    break;
                }
            case 1:
                {
                    Image laser = new Image("q4proj/laserleft.png");
                    location = LCimgs1.get(spot);
                    location.setImage(laser);
                    for (Laser L : Laser.laserList){
                        if(L.space==location) L.activate();
                    }
                    break;
                }
            case 2:
                {
                    Image laser = new Image("q4proj/laserbottom.png");
                    location = LR2imgs.get(spot);
                    location.setImage(laser);
                    for (Laser L : Laser.laserList){
                        if(L.space==location) L.activate();
                    }
                    break;
                }
            case 3:
                {
                    Image laser = new Image("q4proj/laserright.png");
                    location = LCimgs2.get(spot);
                    location.setImage(laser);
                    for (Laser L : Laser.laserList){
                        if(L.space==location) L.activate();
                    }
                    break;
                }
        }
    }
    
    public void shiftLaser(int line, int spot){
        ImageView location;
        Image blankTile = new Image("q4proj/emptytile.png");
        switch (line) {
            case 0:
                {
                    location = LR1imgs.get(spot);
                    location.setImage(blankTile);
                    for (Laser L : Laser.laserList){
                        if(L.space==location) L.deactivate();
                    }
                    break;
                }
            case 1:
                {
                    location = LCimgs1.get(spot);
                    location.setImage(blankTile);
                    for (Laser L : Laser.laserList){
                        if(L.space==location) L.deactivate();
                    }
                    break;
                }
            case 2:
                {
                    location = LR2imgs.get(spot);
                    location.setImage(blankTile);
                    for (Laser L : Laser.laserList){
                        if(L.space==location) L.deactivate();
                    }
                    break;
                }
            case 3:
                {
                    location = LCimgs2.get(spot);
                    location.setImage(blankTile);
                    for (Laser L : Laser.laserList){
                        if(L.space==location) L.deactivate();
                    }
                    break;
                }
        }
                
        int newLocation = ((line*8)+spot+1)%32;
        line = newLocation/8;
        spot = newLocation%8;
        Image laser;
        switch (line) {
            case 0:
                {
                    laser = new Image("q4proj/lasertop.png");
                    location = LR1imgs.get(spot);
                    location.setImage(laser);
                    for (Laser L : Laser.laserList){
                        if(L.space==location) L.activate();
                    }
                    break;
                }
            case 1:
                {
                    laser = new Image("q4proj/laserleft.png");
                    location = LCimgs1.get(spot);
                    location.setImage(laser);
                    for (Laser L : Laser.laserList){
                        if(L.space==location) L.activate();
                    }
                    break;
                }
            case 2:
                {
                    laser = new Image("q4proj/laserbottom.png");
                    location = LR2imgs.get(spot);
                    location.setImage(laser);
                    for (Laser L : Laser.laserList){
                        if(L.space==location) L.activate();
                    }
                    break;
                }
            case 3:
                {
                    laser = new Image("q4proj/laserright.png");
                    location = LCimgs2.get(spot);
                    location.setImage(laser);
                    for (Laser L : Laser.laserList){
                        if(L.space==location) L.activate();
                    }
                    break;
                }
        }
        
    }
    
    public void checkWin(String win){
        win = null;
        
        int player1Count = 0;
        int player2Count = 0;
        
        String player1Shape = Player.playerList.get(0).getShape();
        String player2Shape = Player.playerList.get(1).getShape();
        
        for(int x=0; x<8; x++){
            for(int y=0; y<8; y++){
                if (Tile.grid[x][y].playerStatus.equals(player1Shape)) player1Count++;
                else if (Tile.grid[x][y].playerStatus.equals(player2Shape)) player2Count++;
            }
        }
        
        
        if(player1Count>player2Count) win = "Player 1 wins!";
        else if(player1Count<player2Count) win = "Player 2 wins!";
        else win = "Tie!";
        
        
        try{
            endGame(true);
        }
        catch(Exception e){
            
        }
    }
    
//    private void endGame(ActionEvent event) throws IOException{
//       Node node = (Node) event.getSource();
//        Scene currentScene = node.getScene();
//        Stage currentStage = (Stage) currentScene.getWindow();
//        
//        Parent root = FXMLLoader.load(getClass().getResource("Screen5.fxml"));
//        Scene helpScene = new Scene(root);
//        currentStage.hide();
//        currentStage.setScene(helpScene);
//        currentStage.show();   
//   }
    
    public void endGame(boolean gameDone) throws IOException {
        if (gameDone == true) {
            Parent menu_parent = FXMLLoader.load(getClass().getResource("Screen5.fxml"));
            Scene SceneMenu = new Scene(menu_parent);
            Stage stage = (Stage)back.getParent().getScene().getWindow();
            stage.setScene(SceneMenu);
            stage.show();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeBoard();
        
        initializeLaser(line, spot);
    }    

}

//code source for endGame function: https://stackoverflow.com/questions/59587115/how-to-switch-to-new-scenes-without-an-mouse-drag-etc-event