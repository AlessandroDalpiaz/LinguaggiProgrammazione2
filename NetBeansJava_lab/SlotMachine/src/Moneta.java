/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.glass.events.MouseEvent;
import java.util.Random;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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
import javafx.scene.text.Text;

public class Moneta extends StackPane{
    Circle circle =new Circle(50,50,50);
    //StackPane stack = new StackPane();
    Text numero = new Text("1 Euro");
    //helpText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
    Moneta(){
        ini();
    }
     
    private void ini(){
        circle.setFill(Color.AQUAMARINE);
        this.getChildren().addAll(circle, numero);
        this.setAlignment(Pos.CENTER);
    }

    void addEventHandler(int CLICK, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
