

import java.util.Random;
import javafx.animation.FadeTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alessandro
 */
public class Spinbar extends HBox implements EventHandler{
    Figura figura[] =new Figura[3];
    main sm=null;
    Random random= new Random();
    
    /**
     * Slot-machine
     * @param sm 
     */
    public Spinbar(main sm){
        setAlignment(Pos.CENTER);
        setSpacing(10);
        this.sm=sm;
        inizialize();
    }
    public void inizialize(){
        getChildren().clear();
        for (int i = 0; i < 3; i++) {
            int tipo = random.nextInt(4);
            int colore = random.nextInt(5);
            
            figura[i] = new Figura(tipo, colore);
            figura[i].addEventFilter(MouseEvent.MOUSE_CLICKED,this);
            
        }
        getChildren().addAll(figura);
        // evita di iniziare con tutti i simboli già uguali!
        if (areSymbolsEqual()) {
            inizialize();
        }
    }
    /**
     * Metodo per verificare se tutti i simboli presenti sono uguali
     * @return true se tutti i simboli sono uguali, false altrimenti
     */
    public boolean areSymbolsEqual() {
        System.out.println(figura[0].getId());
        for (int i = 1; i < main.NUM_SPINNERS; i++) {
            System.out.println(figura[i].getId());
            if (!figura[0].getId().equals(figura[i].getId())) {
                return false;
            }
        }
        return true;
    }
    /**
     * Cambia l'i-esimo simbolo della spinbar - senza animazioni
     * @param i indice dell'elemento da modificare
     */
    public void spinElement(int i) {;
        int tipo = random.nextInt(main.NUM_SYMBOL_TYPES);
        int colore = random.nextInt(main.NUM_SYMBOL_COLORS);
        figura[i] = new Figura(tipo,colore);
        figura[i].addEventFilter(MouseEvent.MOUSE_CLICKED,this);
       
        System.out.println("replace simbolo " + i);
        this.getChildren().remove(i);
        this.getChildren().add(i, figura[i]);
    }
    /**
     * Cambia l'i-esimo simbolo della spinbar - con animazioni
     * @param i indice dell'elemento da modificare
     */
    public void spinElementWithAnimation(final int i) {
        int tipo = random.nextInt(main.NUM_SYMBOL_TYPES);
        int colore = random.nextInt(main.NUM_SYMBOL_COLORS);
        figura[i] = new Figura(tipo, colore);
        figura[i].addEventFilter(MouseEvent.MOUSE_CLICKED,this);
        System.out.println("replace simbolo " + i);
        Figura vecchioSimbolo = (Figura) this.getChildren().get(i);
        final Duration SEC_1 = Duration.millis(500);
        FadeTransition disappear = new FadeTransition(SEC_1, vecchioSimbolo);
        disappear.setFromValue(1.0);
        disappear.setToValue(0.0);
        final FadeTransition appear = new FadeTransition(SEC_1, figura[i]);
        appear.setFromValue(0.0);
        appear.setToValue(1.0);
        disappear.setOnFinished(new EventHandler() {
            public void handle(Event t) {
                getChildren().remove(i);
                //simbolo[i].setOpacity(0.0);
                getChildren().add(i, figura[i]);
                appear.play();
            }
        });
        disappear.play();
    }
    public void spinAll() {
        if (!sm.payPoints()) {
            return;
        }
        for (int i = 0; i < main.NUM_SPINNERS; i++) {
            spinElement(i);
        }
        if (areSymbolsEqual()) {
            sm.declareVictory();
        }
    }

// ================ LISTENER Simboli ===========================================

        public void handle(Event t) {
            System.out.println("Symbol event " + t);
            if (!sm.payPoints()) {
                return;
            }
            Figura s = (Figura) (t.getSource());
            for (int i = 0; i < main.NUM_SPINNERS; i++) {
                if (s == figura[i]) {
                    spinElement(i);
                }
            }
            t.consume();
            if (areSymbolsEqual()) {
                sm.declareVictory();
            }
        }
}
