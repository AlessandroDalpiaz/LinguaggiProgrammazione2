

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alessandro
 */
public class Title extends Group{
    /**
     * Creazieone del Titolo
     */
    public Title(){
       Label lab=new Label("Super\n Slot");
       lab.setAlignment(Pos.CENTER);
       lab.setFont(Font.font("Arial", FontWeight.BOLD, 30));
       lab.setLayoutX(250);
       lab.setLayoutY(15);
       Rectangle rect =new Rectangle(600,100);
       rect.setFill(Color.YELLOW);
       rect.setStroke(Color.BLACK);
       rect.setStrokeWidth(5);
       this.getChildren().addAll(rect,lab);
    }
    
}
