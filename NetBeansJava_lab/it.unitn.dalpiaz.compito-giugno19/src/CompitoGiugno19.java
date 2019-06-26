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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Alessandro
 */
public class CompitoGiugno19 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root =new BorderPane();
        //pdf 5_JavaFXIntro.pptx.pdf
        /*TextInputDialog dialog= new TextInputDialog("Default answer");
        dialog.setTitle("Dialog Title");
        dialog.setHeaderText("Dialog header");
        dialog.setContentText("Answer label:");
        String s= dialog.showAndWait().get();*/
                
                
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
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
