
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alessandro
 */
public class CircleTile extends Tile{
Circle circle=new Circle(50,50,50);
    public CircleTile(int x,Color p) {
        numero=x;
        circle.setFill(p);
        lbl_number.setText(String.valueOf(x));
        lbl_number.setTextFill(p.invert());
        getChildren().addAll(circle,lbl_number);
    }
    
}
