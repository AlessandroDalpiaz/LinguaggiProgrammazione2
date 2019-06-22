/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.glass.events.MouseEvent;
import com.sun.javafx.scene.layout.region.BackgroundFill;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import static javax.swing.text.StyleConstants.Background;

/**
 *
 * @author Alessandro
 */

public class main extends Application {
public static final int NUM_MONETE = 3; // numero di monete disponibili    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        StackPane tmp= new StackPane();
        Rectangle rett= new Rectangle(1000,200);
        Text testo = new Text("SuperSlot");
        rett.setFill(Color.YELLOW);
        tmp.getChildren().addAll(rett, testo);
        tmp.setAlignment(Pos.CENTER);
        
        
        Label titolo= new Label();
        titolo.setText("Super Slot");
        //titolo.setFont(Font.font("Cambria", 32));
        titolo.setPrefHeight(200);
        titolo.setPrefWidth(1000);
        titolo.setTextFill(Color.web("#000000"));
        //titolo.setFont(new Font(30));
        //titolo.setFont(new Font("Arial", 30)); // set to Label
        titolo.setAlignment(Pos.CENTER);
        root.setTop(tmp);
        //root.setTop(titolo);
        ///----------3 simboli--------
        final Pane layout = new HBox();
        for (int i = 0; i < 3; i++) {
            layout.getChildren().add(new Elementi());
        }
        root.setCenter(layout);
        
        ///--------- UNA HBox con 2 VBOX con CheckBox e label------------
        Pane PuntiEBottoni= new VBox();
        Pane punti = new HBox();
        final BloccoCheck bcCredito=new BloccoCheck("Credito");
        final BloccoCheck bcPunteggio=new BloccoCheck("Punteggio");
        
        
        punti.getChildren().add(bcCredito);
        punti.getChildren().add(bcPunteggio);
        
        //root.setBottom(punti);
        PuntiEBottoni.getChildren().add(punti);
        ///---------2 bottoni SPIN PLAY------------
        Pane bottoni = new HBox();
        final Button b1 = new Button();
        final Button b2= new Button();
        final Button b3= new Button();
        b1.setText("Nuova Partita");
        b2.setText("SPIN");
        b3.setText("PAY");
        /////////////////////////
        EventHandler<javafx.scene.input.MouseEvent> btn_newGame;
        btn_newGame = new EventHandler<javafx.scene.input.MouseEvent>() { 
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            System.out.println("CLICCATO b1");
            if (bcCredito.get()<100) {
                System.out.println("credito insuff");  
            }else{
                System.out.println("Nuova Partita");
                bcCredito.RemovePoints(100);
                bcPunteggio.AddPoints(128);
            }
        
        }
        };
        /////////////////////////
        /////////////////////////
        EventHandler<javafx.scene.input.MouseEvent> btn_Spin;
        btn_Spin = new EventHandler<javafx.scene.input.MouseEvent>() { 
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            System.out.println("CLICCATO b2");
            layout.getChildren().clear();
            for (int i = 0; i < 3; i++) {
                layout.getChildren().add(new Elementi());
            }
        }
        };
        EventHandler<javafx.scene.input.MouseEvent> btn_Spin_Press;
        btn_Spin_Press = new EventHandler<javafx.scene.input.MouseEvent>() { 
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            System.out.println("prss b2");
            bcPunteggio.dimezza();
        }
        };
        /////////////////////////
        /////////////////////////
        EventHandler<javafx.scene.input.MouseEvent> btn_Pay;
        btn_Pay= new EventHandler<javafx.scene.input.MouseEvent>() { 
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            System.out.println("click b3");
            double v= bcCredito.get()/100.0;
            showPopup("HAI VINTO "+ v+ " EURO!");
        }
        };
        /////////////////////////
        b1.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, btn_newGame);
        b2.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, btn_Spin);
        b2.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_PRESSED, btn_Spin_Press);
        b3.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_PRESSED, btn_Pay);
        bottoni.getChildren().add(b1);
        bottoni.getChildren().add(b2);
        bottoni.getChildren().add(b3);
        System.out.println(bcCredito.isZero());
        if(bcCredito.isZero()){
                b2.setDisable(true);
                b3.setDisable(true);
            }
        PuntiEBottoni.getChildren().add(bottoni);
        root.setBottom(PuntiEBottoni);
        
        //--------monete a destra----------------
        final Pane MoneyBox = new VBox();
        final List<Moneta> monete=new  ArrayList<Moneta>();
        //creo monete
        for (int i = 0; i < NUM_MONETE; i++) {
         monete.add(new Moneta());
        }
        EventHandler<javafx.scene.input.MouseEvent> eventHandler;
        eventHandler = new EventHandler<javafx.scene.input.MouseEvent>() { 
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            System.out.println("CLICCATO"); 
            System.out.println(e.getSource());
            MoneyBox.getChildren().remove(e.getSource());
            System.out.println(e.getTarget());
            bcCredito.AddPoints(100);
            if(!bcCredito.isZero()){
                b2.setDisable(false);
                b3.setDisable(false);
                
            }
            
        }
    };
        final VBox test=new VBox();
        final TextField tff=new TextField();
        EventHandler<javafx.scene.input.MouseEvent> ModTest;
        ModTest = new EventHandler<javafx.scene.input.MouseEvent>() { 
            @Override
            public void handle(javafx.scene.input.MouseEvent e) {
                System.out.println("CLICCATO"); 
                tff.setText("2");
            }
        };
        //////////////////////
        //inserisco nel box
        for (int i = 0; i < NUM_MONETE; i++) {
            monete.get(i).addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, eventHandler);
         MoneyBox.getChildren().add(monete.get(i));
        }
        root.setRight(MoneyBox);
        //-------------------------test a sinistra---------
        
        tff.setText("0");
        tff.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, ModTest);
        
        test.getChildren().add(tff);
        root.setLeft(test);
        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
        public void showPopup(String message) {
        Label label= new Label(message);
        label.setAlignment(Pos.CENTER);
        //label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        Scene sc = new Scene(label, 500, 200);
        Stage stage = new Stage();
        stage.setScene(sc);
        stage.setX(100);
        stage.setY(100);
        stage.initModality(Modality.WINDOW_MODAL);
        //stage.initOwner(mainWindow);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        }
    }
