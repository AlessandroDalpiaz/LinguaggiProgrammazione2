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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Alessandro
 */
public class BloccoCheck extends VBox {
    public BloccoCheck(String a){
        stringa.setText(a);
        this.getChildren().add(textField);
        this.getChildren().add(stringa);
    }
    TextField textField = new TextField ("0");
    Label stringa =new Label();
    
    public void AddPoints(int n){
        System.out.println(n);
       String s= textField.getText();
       int tmp= Integer.parseInt(s);
       tmp= tmp+n;
       System.out.println(s);
       textField.setText(Integer.toString(tmp));
    }
    int get(){
       return Integer.parseInt(textField.getText());
    }
    boolean isZero(){
        if(textField.getText().equals("0")){
            return true;
        }else{
           return false;
        }        
    }
    public void dimezza(){
       String s= textField.getText();
       int tmp= Integer.parseInt(s);
        if (tmp==1) {
            tmp=0;
        }else{ tmp= tmp/2; }
       textField.setText(Integer.toString(tmp)); 
    }
    public void RemovePoints(int n){
       String s= textField.getText();
       int tmp= Integer.parseInt(s);
       tmp= tmp-n;
       textField.setText(Integer.toString(tmp)); 
    }
}
