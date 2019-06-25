
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alessandro
 */
public abstract class Terreno extends StackPane{
    boolean puoAvereMacchina=false;
    Circle auto =new Circle(50,50,50); 
    Rectangle rett= new Rectangle(100, 100);
    Terreno(){
       // CreaMacchina();
    }
    abstract void  CreaMacchina();/*{
        if(puoAvereMacchina){
            auto.setFill(Color.BLUE);
            this.getChildren().addAll(rett,auto);
        }
        else{
            this.getChildren().addAll(rett);
        }
    }*/
}
