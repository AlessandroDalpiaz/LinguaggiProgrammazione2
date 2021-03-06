/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Alessandro
 */
public class CompitoGiugno16 extends Application {
    final GridPane griglia=new GridPane();
    boolean haCliccato=false;

    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root= new BorderPane();
        //----------left----------------------------------
        VBox campi=new VBox();
        HBox textCont=new HBox();
        HBox addBtn=new HBox();
        Label testo=new Label("Auto disponibili");
        Label spazio=new Label("        ");
        final Label contatoreLabel=new Label("3");
        textCont.getChildren().addAll(testo,spazio,contatoreLabel);
        
        final Button btn_addAuto=new Button("Aggiungi Auto");
        Button btn_inizia=new Button("Inzia");

        EventHandler<MouseEvent> AddInzia = new EventHandler<MouseEvent>(){
        @Override
                    public void handle(MouseEvent t) {
                        haCliccato=false;

                    }
                };
        EventHandler<MouseEvent> IncContatore = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                
                haCliccato=!haCliccato;
                System.out.println("       "+haCliccato);
                int tmp= Integer.parseInt(contatoreLabel.getText());
                if (tmp!=0) {
                    tmp--;
                    contatoreLabel.setText(String.valueOf(tmp));
                }else{
                    System.out.println("errore: macchine esaurite");
                    btn_addAuto.setDisable(true);
                }
                System.out.println("click");
                
            }
        };
        btn_addAuto.addEventFilter(MouseEvent.MOUSE_CLICKED, IncContatore);
        btn_inizia.addEventFilter(MouseEvent.MOUSE_CLICKED, AddInzia);
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
    /**
     * inizializza griglia
     */
    void inizializzaGriglia(){
        
        for (int i = 0; i < 7; i++) {
          griglia.add(new Strada(haCliccato,griglia,i,0),i,0);
        }
        for (int i = 0; i < 7; i++) {
          griglia.add(new Strada(haCliccato,griglia,i,7),i,7); 
        }
        for (int i = 0; i < 8; i++) {
           griglia.add(new Strada(haCliccato,griglia,7,i),7,i); 
        }
        for (int i = 0; i <7; i++) {
           griglia.add(new Strada(haCliccato,griglia,0,i),0,i); 
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
