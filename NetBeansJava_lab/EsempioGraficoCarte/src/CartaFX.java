/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class CartaFX extends StackPane {
    CartaFX(){
        Rectangle rett=new Rectangle(100,200);
        rett.setFill(Color.GREENYELLOW);
        rett.setStroke(Color.BLACK);
        
        Text t = new Text();
        t.setFont(new Font(20));
        t.setTextAlignment(TextAlignment.JUSTIFY);
        t.setText("CARTA");
        this.getChildren().addAll(rett,t);
    }
    
}
