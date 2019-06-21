/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author Alessandro
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        BorderPane root =new BorderPane();
        VBox tavolo = new VBox();
        HBox tipo1 =new HBox();
        HBox tipo2 =new HBox();
        HBox tipo3 =new HBox();
        HBox tipo4 =new HBox();
        CartaFX cc =new CartaFX(2,2);
        ArrayList<CartaFX> mazzoFX=new ArrayList<CartaFX>();
   
        //inizializzo
        for(int i=0;i<4;i++){
            for (int j = 1; j < 14; j++) {
                mazzoFX.add(new CartaFX(j,i));
                }
        }
        Collections.shuffle(mazzoFX);
        for (int i = 0; i < 13; i++) {
                mazzoFX.get(i).setPrefWidth(110);
                mazzoFX.get(i).setPrefHeight(210);
                tipo1.getChildren().add(mazzoFX.get(i));
        }
        for (int i = 13; i < 26; i++) {
                mazzoFX.get(i).setPrefWidth(110);
                mazzoFX.get(i).setPrefHeight(210);
                tipo2.getChildren().add(mazzoFX.get(i));
        }
        for (int i = 26; i < 39; i++) {
                mazzoFX.get(i).setPrefWidth(110);
                mazzoFX.get(i).setPrefHeight(210);
                tipo3.getChildren().add(mazzoFX.get(i));
        }
        for (int i = 39; i < 52; i++) {
                mazzoFX.get(i).setPrefWidth(110);
                mazzoFX.get(i).setPrefHeight(210);
                tipo4.getChildren().add(mazzoFX.get(i));
                //mazzoFX.get(i).addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        }

        tavolo.getChildren().addAll(tipo1,tipo2,tipo3,tipo4);
        root.setCenter(tavolo);
        root.autosize();
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Gioco Carte");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setX(150);
        primaryStage.setMinHeight(1000);
        primaryStage.setMinWidth(1500);
        
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }
    
}
