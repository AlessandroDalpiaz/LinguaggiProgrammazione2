/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Alessandro
 */
public class Bottone extends Button implements EventHandler<ActionEvent> {
    TextField  tf=new TextField();
    main mainn=null;
    TextBox tb=new TextBox();
    
    
    Bottone(String s){
        this.setText(s);
        addEventFilter(ActionEvent.ACTION, this);
    }
    Bottone(String s,TextField tff){
        this.setText(s);
        tf=tff;
        addEventFilter(ActionEvent.ACTION, this);
        addEventHandler(EventType.ROOT, this);
        addEventFilter(ActionEvent.ACTION, this);
    }
    Bottone(String s,TextBox tbb){
        this.setText(s);
        tb=tbb;
        addEventFilter(ActionEvent.ACTION, this);
        addEventHandler(EventType.ROOT, this);
    }
    @Override
    public void handle(ActionEvent t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(this.getText());
        
        System.out.println(tb.getText());
    }

    private void addEventHandler(EventType<Event> ROOT, Bottone aThis) {
        System.out.println(this.getText());
        System.out.println(tb.getText());
        setId(tb.getText());
        //tb.re
    }
   
}
