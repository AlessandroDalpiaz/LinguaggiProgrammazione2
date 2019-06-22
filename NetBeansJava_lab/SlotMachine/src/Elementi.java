/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Alessandro
 */
public class Elementi extends HBox {
    Circle circle =new Circle(50,50,50);
    
    Polygon polygon = new Polygon(50.0, 0.0,0.0, 100.0,100.0, 100.0);
    Rectangle rettangle = new Rectangle(100,50);
    //currentPolygon.setStroke(Color.BLACK);
    
    EventHandler<javafx.scene.input.MouseEvent> FormaClick;
    
    
    public Elementi(){
        circle.setFill(Color.BLUEVIOLET);
        rettangle.setFill(Color.GREENYELLOW);
        polygon.setFill(Color.CORAL);
        ImplementaSingleRandom();
        //circle.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, FormaClick);
        
        FormaClick = new EventHandler<javafx.scene.input.MouseEvent>() { 
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            System.out.println("CLICCATO FIGURA");
           
        }
        };
    }
    
    public void ImplementaSingleRandom(){
        int pos=0;
        if(this.getChildren().size()==3){
            this.getChildren().remove(0,3);
        }
        pos= new Random().nextInt(3);
        System.out.println(pos);
        switch(pos){
            case 0:this.getChildren().add(circle);break;
            case 1:this.getChildren().add(rettangle);break;
            case 2:this.getChildren().add(polygon);break;
        }   
    }
   
}
