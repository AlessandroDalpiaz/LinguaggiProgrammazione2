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
import javafx.stage.Stage;

/**
 *
 * @author Alessandro
 */
public class Bottone extends Button implements EventHandler<ActionEvent> {

    Bottone(){
        this.setText("A");
        addEventFilter(ActionEvent.ACTION, this);
    }
    @Override
    public void handle(ActionEvent t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(t.getSource());
        System.out.println(this.getText());
        
    }
   
}
