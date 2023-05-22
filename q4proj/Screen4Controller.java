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
import java.lang.Math;  


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
    
//    private ImageView[][] realBoard = new ImageView[8][8];
    private ArrayList<ImageView> realBoard = new ArrayList(64);

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

//    @FXML
//    private void clickCell(){
//        board.setOnMouseClicked(event -> {
//            ImageView source = (ImageView) event.getTarget();
////            int columnIndex = GridPane.getColumnIndex(source);
////            int rowIndex = GridPane.getRowIndex(source);
//            Image icon = new Image("q4proj/circle1.png");
//            source.setImage(icon);
//        });
//    }
    //code above is from Sai Dandem on https://stackoverflow.com/questions/69429420/javafx-update-imageview-on-gridpane-click

//    @FXML
//    private void clickCell(MouseEvent event){
//            ImageView source = (ImageView) event.getTarget();
////            int columnIndex = GridPane.getColumnIndex(source);
////            int rowIndex = GridPane.getRowIndex(source);
//            Image icon = new Image("q4proj/circle1.png");
//            source.setImage(icon);
//    }

    @FXML
    public void makeBoard() {

        for(int i=0; i<64; i++){
            ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("emptytile.png")));
            icon.setFitHeight(30);
            icon.setFitWidth(30);
            realBoard.add(icon);
            int row = i/8;
            int col = i%8;
            board.add(icon,col,row);
            System.out.println("create");



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
                
                Tile thisTile = Tile.grid[x][y];
                
                int tilePopulation = thisTile.getNumberStatus();
                System.out.println(tilePopulation);
                String filename = null;
                
                if(tilePopulation<thisTile.getCriticalMass() && tilePopulation<playerturn.getCriticalMass() && (thisTile.getPlayerStatus().equals("empty") || thisTile.getPlayerStatus().equals(playerturn.getName()))) {
                    
                    if(tilePopulation==0) filename = "q4proj/"+playerturn.getShape()+"1.png";
                    else if(tilePopulation==1) filename = "q4proj/"+playerturn.getShape()+"2.png";
                    else if(tilePopulation==2 && !playerturn.getShape().equals("triangle")) filename = "q4proj/"+playerturn.getShape()+"3.png";
                
                }
                
                Image tileicon = new Image(filename);
                source.setImage(tileicon);
                
                Tile.incRoundNum();
                thisTile.incNumberSatus();
                thisTile.setPlayerStatus(playerturn.getName());
            });
        }
  }
    
    
     @FXML 
    private void laserCol1(){ 
        
            for(int i=0; i<8; i++){
                ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("emptytile.png")));
                icon.setFitHeight(30);
                icon.setFitWidth(30);
                LCimgs1.add(icon);
                int row = i;
                int col = 0;
                laserCol1.add(icon,col,row);
                System.out.println("col"); 
            }
    }
    
             @FXML 
    private void laserCol2(){ 
        
            for(int i=0; i<8; i++){
                ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("emptytile.png")));
                icon.setFitHeight(30);
                icon.setFitWidth(30);
                LCimgs2.add(icon);
                int row = i;
                int col = 0;
                laserCol2.add(icon,col,row);
                System.out.println("col"); 
            }
    }
    
             @FXML 
    private void laserRow1(){ 
        
            for(int i=0; i<8; i++){
                ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("emptytile.png")));
                icon.setFitHeight(30);
                icon.setFitWidth(30);
                LR1imgs.add(icon);
                int row = 0;
                int col = i;
                laserRow1.add(icon,col,row);
                System.out.println("row"); 
            }
    }
    
             @FXML 
    private void laserRow2(){ 
        
            for(int i=0; i<8; i++){
                ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("emptytile.png")));
                icon.setFitHeight(30);
                icon.setFitWidth(30);
                LR2imgs.add(icon);
                int row = 0;
                int col = i;
                laserRow2.add(icon,col,row);
                System.out.println("row"); 
            }
    }
    
    private void initializeLaser(){
        int laserLocation = ((int)Math.random())%32;
        if(laserLocation<8){
            Image laserIcon = new Image("lasertop.png");
            LR1imgs.get(laserLocation).setImage(laserIcon);
        }
        else if (laserLocation<16) {
            laserLocation -= 8;
            Image laserIcon = new Image("laserleft.png");
            LCimgs1.get(laserLocation).setImage(laserIcon);
        }
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeBoard();
        Tile.makeGrid();
        laserCol1();
        laserCol2();
        laserRow1();
        laserRow2();
    }    

}

//generate for loop in a for loop to generate the 8x8 gridpane with imageviews
//use gridpane coords to access each imageview
//overlay th imageview 2d array on the gridpane somehow