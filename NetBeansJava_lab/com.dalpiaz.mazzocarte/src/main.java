/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Alessandro
 */
public class main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
                
                
                
                
                
        List <Carta> carte = new ArrayList<Carta>();
        List <Carta> estratte = new ArrayList<Carta>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 13; j++) {
                carte.add(new Carta(j,Seme.C));
                
            }
            for (int j = 0; j < 13; j++) {
                carte.add(new Carta(j,Seme.F));
                
            }
            for (int j = 0; j < 13; j++) {
                carte.add(new Carta(j,Seme.P));
            }
            for (int j = 0; j < 13; j++) {
                carte.add(new Carta(j,Seme.Q));
            }
        }
        Collections.shuffle(carte);
                for (int i = 0; i < 10; i++) {// 10 da far scegliere dall'utente
                    estratte.add(carte.get(i));
                    estratte.get(i).stampa();
                    
                }
                
                for (Carta c : estratte) {
                    if(Collections.frequency(carte, c)>1)
                    {
                        System.err.println("ciccio");
                    }
                    else{
                        System.err.println("perso");
                    }
                    
                }
                

            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
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
