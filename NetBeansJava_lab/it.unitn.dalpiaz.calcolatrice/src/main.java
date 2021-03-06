/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Alessandro
 */
public class main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        BorderPane root = new BorderPane();
        VBox finale=new VBox();
        TextField numUno= new TextField();
        TextBox tb=new TextBox();
        numUno.setMinHeight(100);
        //numUno.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        Text numDue= new Text();
        numDue.setFont(new Font(60));
        numDue.setText("55");
        HBox Onepiu =  new HBox();
        HBox Fourmeno=  new HBox();
        HBox SevDiv=  new HBox();
        HBox ZeroCancPer=  new HBox();
        
        
        ArrayList<Bottone> bottoni=new ArrayList<Bottone>();
        bottoni.add(new Bottone("1"));
        bottoni.add(new Bottone("2"));
        bottoni.add(new Bottone("3"));
        bottoni.add(new Bottone("+"));
        bottoni.add(new Bottone("4"));
        bottoni.add(new Bottone("5"));
        bottoni.add(new Bottone("6"));
        bottoni.add(new Bottone("-"));
        bottoni.add(new Bottone("7"));
        bottoni.add(new Bottone("8"));
        bottoni.add(new Bottone("9"));
        bottoni.add(new Bottone("/"));
        bottoni.add(new Bottone("rad"));
        bottoni.add(new Bottone("0"));
        //bottoni.add(new Operation("=",numUno));
        bottoni.add(new Bottone("=",tb));
        bottoni.add(new Bottone("X"));
        
        for (int i = 0; i < 4; i++) {
            Onepiu.getChildren().add(bottoni.get(i));
        }
        for (int i = 4; i < 8; i++) {
            Fourmeno.getChildren().add(bottoni.get(i));
        }
        for (int i = 8; i < 12; i++) {
            SevDiv.getChildren().add(bottoni.get(i));
        }
        for (int i = 12; i < 16; i++) {
            ZeroCancPer.getChildren().add(bottoni.get(i));
        }
        finale.getChildren().addAll(tb,numUno,numDue,Onepiu,Fourmeno,SevDiv,ZeroCancPer);
        root.setCenter(finale);
        Scene scene = new Scene(root, 540, 800);
        //------------dimensioni---------------------
        double tmp=root.getWidth()/4;
        for (int i = 0; i < 16; i++) {
            bottoni.get(i).setMinWidth(tmp);
            bottoni.get(i).setMinHeight(tmp+20);
            bottoni.get(i).setFont(new Font(40));
        }
        primaryStage.setTitle("Calcolatrice");
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
