/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package q4proj;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
import q4proj.Model.*;


/**
 *
 * @author briep
 */
public class Screen5Controller implements Initializable {
    
    @FXML
    private Button back;
    
    @FXML
    private Label winnerLabel;

    public void displayWinner(String winner){
        winnerLabel.setText("Player " + winner + " wins!");
    }
    
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
        
        
        for(Player p : Player.playerList) {
            Player.playerList.remove(p);
        }
        
        
//        for(Tile grid : var) {
//            grid.remove(var);
//        }

 for(int x = 0; x < 8; x++) {
      for(int y = 0; y < 8; y++) {
        Tile tile = Tile.grid[x][y];
        tile.numberStatus = 0;
        tile.playerStatus = "empty";
      }
    }
        
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayWinner(Screen4Controller.win);
    }    
    
}
