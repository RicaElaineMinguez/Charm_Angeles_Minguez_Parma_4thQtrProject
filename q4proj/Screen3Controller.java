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
import javafx.scene.control.RadioButton;
import q4proj.Model.*;


/**
 *
 * @author briep
 */
public class Screen3Controller implements Initializable {
    
    @FXML
    private RadioButton circle1, circle2, square1, square2, triangle1,triangle2;
    private Button playbutton;
    public static Player player1, player2;
    

    @FXML
    private void player1CircleSelect(ActionEvent event) {
        Player player1 = new PlayerCircle("player1", 4);
        
    }
    
    @FXML
    private void player1SquareSelect(ActionEvent event) {
        Player player1 = new PlayerSquare("player1", 4);
        
    }
    
    @FXML
    private void player1TriangleSelect(ActionEvent event) {
        Player player1 = new PlayerTriangle("player1", 3);
    }
    
    @FXML
    private void player2CircleSelect(ActionEvent event) {
           Player player2 = new PlayerCircle("player2", 4);
        
    }
    
    @FXML
    private void player2SquareSelect(ActionEvent event) {
        Player player2 = new PlayerSquare("player2", 4);
        
    }
    
    @FXML
    private void player2TriangleSelect(ActionEvent event) {
        Player player2 = new PlayerTriangle("player2", 3);
    }
    
     
    
   @FXML
   private void playStart(ActionEvent event) throws IOException{
       Node node = (Node) event.getSource();
        Scene currentScene = node.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("Screen4 - Copy.fxml"));
        Scene helpScene = new Scene(root);
        currentStage.hide();
        currentStage.setScene(helpScene);
        currentStage.show();   
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
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
