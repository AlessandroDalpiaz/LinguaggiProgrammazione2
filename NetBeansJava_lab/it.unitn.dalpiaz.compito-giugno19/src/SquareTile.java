
import javafx.scene.paint.Color;
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
public class SquareTile extends Tile{
    Rectangle rectangle =new Rectangle(100,100);
    SquareTile(int x,Color p){
        numero=x;
        rectangle.setFill(p);
    }
}
