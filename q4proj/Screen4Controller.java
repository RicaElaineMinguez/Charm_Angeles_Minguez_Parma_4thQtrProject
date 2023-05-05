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


/**
 *
 * @author briep
 */
public class Screen4Controller implements Initializable {

    @FXML private Button back;
    @FXML public GridPane board;
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

    @FXML
    private void clickCell(MouseEvent event){
            ImageView source = (ImageView) event.getTarget();
//            int columnIndex = GridPane.getColumnIndex(source);
//            int rowIndex = GridPane.getRowIndex(source);
            Image icon = new Image("q4proj/circle1.png");
            source.setImage(icon);
    }

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
//                
                
//            int columnIndex = GridPane.getColumnIndex(source);
//            int rowIndex = GridPane.getRowIndex(source);
//                Player x = Player.playerList.get(0);
//                String filename = "q4proj/"+x.getShape()+"1.png";
//                System.out.println(filename);
//                Image tileicon = new Image(filename);
//                source.setImage(tileicon);
            });
        }

//    ImageView[][] imageGrid = new ImageView[8][8];

//    for(int x = 0; x < 8; x++) {
//      for(int y = 0; y < 8; y++) {
//        
//        ImageView tile = new ImageView();
////        imageGrid[x][y] = tile;
//        board.add(tile,y,x);
//        tile.setOnMouseClicked(event -> {
//            ImageView source = (ImageView) event.getTarget();
////            int columnIndex = GridPane.getColumnIndex(source);
////            int rowIndex = GridPane.getRowIndex(source);
//            Image icon = new Image("q4proj/circle1.png");
//            source.setImage(icon);
//            
//        });
//        
//        
//      }
//    }
  }
//    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeBoard();
        Tile.makeGrid();
    }    

}

//generate for loop in a for loop to generate the 8x8 gridpane with imageviews
//use gridpane coords to access each imageview
//overlay th imageview 2d array on the gridpane somehow
