/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.geom.Path2D;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Alessandro
 */
public class Calcolatrice2 extends Application {
    TextField input1=new TextField();
    TextField input2=new TextField();
    TextField output=new TextField();

    public Calcolatrice2() {
        output.setDisable(true);
    }
    
    
    
    
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root =new BorderPane();
        final TilePane campi=new TilePane();
        final TilePane OpBottons= new TilePane();
        VBox allbtn=new VBox();
        //----titolo-------
        Label lt = new Label("MiniCalculator");
        lt.setFont(Font.font("Verdana", FontWeight.BOLD, 36));
        root.setTop(lt);
        BorderPane.setAlignment(lt, Pos.CENTER);
        //sx
        Label text =new Label("|-|-|-|-|");
        root.setLeft(text);
        //----primo,secondo  e terzo box
        
        campi.setPrefColumns(1);
        campi.getChildren().addAll(input1,input2,output);
        
        //----bottoni operazioni----------
        OperationBotton btn_piu= new OperationBotton(this,"PIU", "+");
        OperationBotton btn_meno= new OperationBotton(this,"MENO", "-");
        OperationBotton btn_per= new OperationBotton(this,"PER", "*");
        OperationBotton btn_diviso= new OperationBotton(this,"DIVISO", "/");
        
        OpBottons.getChildren().addAll(btn_piu,btn_meno,btn_per,btn_diviso);
        
        allbtn.getChildren().addAll(campi,OpBottons);
        root.setCenter(allbtn);
        Scene scene = new Scene(root, 1000, 700);
        
        primaryStage.setTitle("MiniCalculator");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
    }
    boolean check(String c){
        return "1234567890".contains(c);
    }
    boolean checkTF(TextField t){
        System.out.println("da capire--> "+t.equals(""));
        for (char c : t.getText().toCharArray()) {
            if(!check(String.valueOf(c))){return false;}
        }
       // if(check(t.getText())){return false;}
        return true;
    }
    public String somma(String s1,String s2){
        if(!checkTF(input1) || !checkTF(input2)){
            return "errore";
        }
        String res;
        int in1=Integer.parseInt(s1);
        int in2=Integer.parseInt(s2);
        int tmp= in1+in2;
        res= String.valueOf(tmp);
        return res;
    }
    public String sommad(String s1,String s2){
        double d1,d2;
        try{
        d1=Double.parseDouble(input1.getText());
        d2=Double.parseDouble(input2.getText());
        return String.valueOf(d1+d2);
        }catch(Exception e){
            System.out.println("eroore");
        }
        return null;    
    }
    public String diffd(String s1,String s2){
        double d1,d2;
        try{
        d1=Double.parseDouble(input1.getText());
        d2=Double.parseDouble(input2.getText());
        return String.valueOf(d1-d2);
        }catch(Exception e){
            System.out.println("eroore");
        }
        return null;    
    }
    public String perd(String s1,String s2){
        double d1,d2;
        try{
        d1=Double.parseDouble(input1.getText());
        d2=Double.parseDouble(input2.getText());
        return String.valueOf(d1*d2);
        }catch(Exception e){
            System.out.println("eroore");
        }
        return null;    
    }
    public String divd(String s1,String s2){
        double d1,d2;
        try{
        d1=Double.parseDouble(input1.getText());
        d2=Double.parseDouble(input2.getText());
        return String.valueOf(d1/d2);
        }catch(Exception e){
            System.out.println("eroore");
        }
        return null;    
    }
    public void Esegui(String operatore){
        switch(operatore){
            //case "+":output.setText(somma(input1.getText(),input2.getText()));break;
            case "+": output.setText(sommad(input1.getText(),input2.getText()));break;
            case "-": output.setText(diffd(input1.getText(),input2.getText()));break;
            case "*": output.setText(perd(input1.getText(),input2.getText()));break;
            case "/": output.setText(divd(input1.getText(),input2.getText()));break;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}