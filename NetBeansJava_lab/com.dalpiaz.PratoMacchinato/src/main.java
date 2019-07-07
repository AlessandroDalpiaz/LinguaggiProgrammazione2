/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Alessandro
 */
public class main extends Application {
    
   // @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
       // Cella c= new Cella();
        Pane gridLast= new HBox();
        for (int i = 0; i < 8; i++) {
            gridLast.getChildren().add(new Colonna());
        }
        root.setCenter(gridLast);
        
        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
