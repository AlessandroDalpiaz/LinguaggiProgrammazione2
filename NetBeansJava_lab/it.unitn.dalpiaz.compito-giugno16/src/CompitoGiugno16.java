/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Alessandro
 */
public class CompitoGiugno16 extends Application {
    final GridPane griglia=new GridPane();
    

    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root= new BorderPane();
        //----------left----------------------------------
        VBox campi=new VBox();
        HBox textCont=new HBox();
        HBox addBtn=new HBox();
        Label testo=new Label("Auto disponibili");
        Label spazio=new Label("        ");
        Label contatoreLabel=new Label("3");
        textCont.getChildren().addAll(testo,spazio,contatoreLabel);
        
        Button btn_addAuto=new Button("Aggiungi Auto");
        Button btn_inizia=new Button("Inzia");
        addBtn.getChildren().addAll(btn_addAuto,spazio,btn_inizia);
        campi.getChildren().addAll(textCont,addBtn);
        root.setLeft(campi);
        
        //----------center----------------------------------
        inizializzaGriglia();
        root.setCenter(griglia);
        Scene scene = new Scene(root, 900, 900);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    void inizializzaGriglia(){
        
        for (int i = 0; i < 7; i++) {
          griglia.add(new Strada(griglia,i,0),i,0);
        }
        for (int i = 0; i < 7; i++) {
          griglia.add(new Strada(griglia,i,7),i,7); 
        }
        for (int i = 0; i < 8; i++) {
           griglia.add(new Strada(griglia,7,i),7,i); 
        }
        for (int i = 0; i <7; i++) {
           griglia.add(new Strada(griglia,0,i),0,i); 
        }
        
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                griglia.add(new Prato(griglia,i,j),i,j);
            }
        }
        ///griglia.add(new Strada(3,3),3,3);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
