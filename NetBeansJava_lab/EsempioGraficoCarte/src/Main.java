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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
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
        CartaFX cc =new CartaFX();
        
        root.setCenter(cc);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Gioco Carte");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        ArrayList<Carta> mazzo = new ArrayList<Carta>();
        LinkedList<Carta> mazzo2 = new LinkedList<Carta>();
        HashSet<Carta> mazzo3 = new HashSet<Carta>();
        //inizializzo
        for(int i=0;i<4;i++){
            for (int j = 1; j < 14; j++) {
                mazzo.add(new Carta(j,i));
                mazzo2.add(new Carta(j,i));
                mazzo3.add(new Carta(j,i));
            }
        }
        System.out.println("mazzo \tmazzo2 \t mazzo3");
        for (int i = 0; i < 52; i++) {
            System.out.println(" "+ mazzo.get(i).n+ " "+ mazzo.get(i).seme + "\t" + mazzo2.get(i).n+ " "+ mazzo2.get(i).seme+ "\t"+mazzo3.toString()+ " "); 
        }
        //mazzo1 e 2 ordinati, mentre mazzo3 già mescolato
        Collections.shuffle(mazzo);
        Collections.shuffle(mazzo2);
        System.out.println("-------------MESCOLATE-------------");
        for (Carta c : mazzo) {
            c.stampa();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }
    
}
