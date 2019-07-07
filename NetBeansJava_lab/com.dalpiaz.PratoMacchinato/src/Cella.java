
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alessandro
 */
public class Cella extends StackPane{
    Cella(){
        ini();
        //Creating the mouse event handler 
        r.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    }
    Rectangle r = new Rectangle(60,60);
    Circle circle =new Circle(20,20,20);
    Text S = new Text("S");
    Text P = new Text("P");
    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
            @Override 
            public void handle(MouseEvent e) { 
               r.setFill(Color.BEIGE);
            } 
         };
    void ini(){
        
        r.setStroke(Color.BLACK);
        r.setFill(Color.WHITE);
        //this.getChildren().addAll(r, S);
        this.getChildren().add(r);
        //this.getChildren().add(S);
        Random rnd= new Random();
        SetSimbolo(rnd.nextInt(2));
        this.setAlignment(Pos.CENTER);
    }
   
    void SetSimbolo(int n){
        switch(n){
            case 0: this.getChildren().add(S);break;
            case 1: this.getChildren().add(P);break;
            case 2: this.getChildren().add(circle);break;
                
        }
    }
}
