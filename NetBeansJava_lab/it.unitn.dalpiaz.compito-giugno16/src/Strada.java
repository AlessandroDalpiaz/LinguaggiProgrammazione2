
import java.util.Random;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
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
class Strada extends Terreno{
    int cordX,cordY;
    boolean visibile;
    GridPane city;
        Strada(GridPane _city,int x,int y){
            city=_city;
            cordX=x;
            cordY=y;
            super.puoAvereMacchina=true;
            rett.setFill(Color.GRAY);
            CreaMacchina();
            randomMacchinaVisibile();

            
        }
 void SetVisible(){
     visibile =!visibile;
     auto.setVisible(visibile);;
 }
 void randomMacchinaVisibile(){
     Random rnd=new Random();
     
     if (rnd.nextDouble()<=0.6) {
         SetVisible();
     }
 }
    @Override
    void CreaMacchina() {
        if(puoAvereMacchina){
            auto.setFill(Color.BLUE);
            this.getChildren().addAll(rett,auto);
            visibile=true;
        }
        else{
            this.getChildren().addAll(rett);
        }
    }
        
    }