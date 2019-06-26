
import com.sun.javafx.embed.AbstractEvents;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Classe che estende Terreno: vale una cella
 * @author Alessandro
 */
class Prato extends Terreno{
        int cordX,cordY;
        GridPane city;
        Prato(GridPane _city,int x,int y){
            city=_city;
            cordX=x;
            cordY=y;
            super.puoAvereMacchina=false;
            rett.setFill(Color.GREEN);
            this.getChildren().addAll(rett);
        }

    @Override
    void CreaMacchina() {
        
    }
}
