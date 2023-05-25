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


/**
 *
 * @author briep
 */
public class Screen2Controller implements Initializable {
    
    @FXML
    private Button back;
    
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
