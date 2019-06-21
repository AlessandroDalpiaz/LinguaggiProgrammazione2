/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
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
    Rectangle rett=new Rectangle(100,200);
    Text t = new Text();
    
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
        @Override 
        public void handle(MouseEvent e) { 
            System.out.println("CLICCATO"); 
            System.out.println(e.getSource());
            if(rett.getFill()==Color.TRANSPARENT){
                System.out.println("entro");
                String s=e.getSource().toString().split(" ")[1];
                System.out.println(s);
                switch(s){
                    case "C":rett.setFill(Color.TOMATO);System.out.println("entroo");break;
                    case "P":rett.setFill(Color.VIOLET);break;
                    case "Q":rett.setFill(Color.BLANCHEDALMOND);break;
                    case "F":rett.setFill(Color.GREENYELLOW);break;
                }
                t.setFill(Color.BLACK);
            }else{
            rett.setFill(Color.TRANSPARENT);
            t.setFill(Color.TRANSPARENT);
            }} 
        };    
    
    
    CartaFX(int j,int i) {
       n=j;
       seme= scelta(i);
       /*switch(i){
           case 0:rett.setFill(Color.RED);break;
           case 1:rett.setFill(Color.VIOLET);break;
           case 2:rett.setFill(Color.BLANCHEDALMOND);break;
           case 3:rett.setFill(Color.GREENYELLOW);break;
       }*/
       rett.setFill(Color.TRANSPARENT);
       t.setFill(Color.TRANSPARENT);
       
       rett.setStroke(Color.BLACK);
       
       t.setFont(new Font(20));
       t.setTextAlignment(TextAlignment.JUSTIFY);
       t.setText(n+" "+seme);
       
       this.getChildren().addAll(rett,t);
       this.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
      
    }
    enum Tsseme{C,P,Q,F}
    int n;
    Tsseme seme;


    public void stampa(){
        System.out.println(n+" "+ seme);
    }
    public Tsseme scelta(int i){
        Tsseme seme = null;
        switch(i){
            case 0:seme=Tsseme.C; break;
            case 1:seme=Tsseme.P; break;
            case 2:seme=Tsseme.Q; break;
            case 3:seme=Tsseme.F; break;
        }
        return seme;
        
    }
    //sovrascrivo metodo toString()
    public String toString(){
         return n+" "+ seme;
    }
    CartaFX(){
        
    }
    
}
