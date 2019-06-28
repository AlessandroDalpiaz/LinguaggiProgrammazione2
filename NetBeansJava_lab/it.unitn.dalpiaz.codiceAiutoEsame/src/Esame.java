/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Alessandro
 */
public class Esame extends Application {
    public static final int NUM_MONETE = 3; // numero di monete disponibili
    Stage mainWindow = null;
    int contatore=0;
    Label ll = new Label("premi");
    //metodo crea un popup esterno allo stage principale
    public void showPopup(String message) {
        Label label = new Label(message);
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        Scene sc = new Scene(label, 500, 200);
        Stage stage = new Stage();
        stage.setScene(sc);
        stage.setX(100);
        stage.setY(100);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(mainWindow);
        stage.show();
    }
    void mouseClicked(){
        ll.setText(String.valueOf(contatore++));
    }
    @Override
    public void start(Stage primaryStage) {
        BorderPane root =new BorderPane();
        VBox box=new VBox();
        box.getChildren().add(ll);
        root.setCenter(box);
        root.setAlignment(box,Pos.CENTER);
        showPopup("messaggio");
       //creazione di un esagono
        Polygon exagon= new Polygon(33,0,66,0,100,50,66,100,33,100,0,50);

        ArrayList<Integer> nome= new ArrayList();
        //Mescolo una lista
        Collections.shuffle(nome);
        //Riordino una lista
        Collections.sort(nome);
        
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setX(100);
        primaryStage.setY(500);
        
        //Creazione stage 2
        Stage st2 = new Stage();
        st2.setTitle("Stage 2");
        Button btn =new Button("Click me!");
            
        //Creazione di un Eventhandler diretto METODO UNO
        btn.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent t) {
                ll.setText("Hai premuto");
            }
            
        });
        /*btn.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent t) -> {
                mouseClicked();         
        });*/
        //Creazione di un Eventhandler diretto METODO DUE
        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent t) {
                mouseClicked();
            }
        
        });
        Scene scene2 = new Scene(btn, 300, 250);
        st2.setScene(scene2);
        st2.centerOnScreen(); ///METTE IN CENTRO ALLO SCHERMO
        st2.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
