/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 *
 * @author Alessandro
 */
public class Calcolatrice3 extends Application {
    final TextField input =new TextField();
    
    final OperationBotton btn_piu= new OperationBotton(this,"PIU", "+");
    final OperationBotton btn_meno= new OperationBotton(this,"MENO", "-");
    final OperationBotton btn_per= new OperationBotton(this,"PER", "*");
    final OperationBotton btn_diviso= new OperationBotton(this,"DIVISO", "/");
    
    boolean piu,meno,per,diviso=false;
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        final TilePane NumBottons=new TilePane();
         ///---------------------------top-----------------------------
        root.setTop(input);
        
        root.setAlignment(input, Pos.CENTER);
        
        ///---------------------------center---------------------------        
        final NumButton btn_uno =new NumButton(this,"1","1");
        final NumButton btn_due =new NumButton(this,"2","2");
        final NumButton btn_tre =new NumButton(this,"3","3");
        final NumButton btn_quattro =new NumButton(this,"4","4");
        final NumButton btn_cinque =new NumButton(this,"5","5");
        final NumButton btn_sei =new NumButton(this,"6","6");
        final NumButton btn_sette =new NumButton(this,"7","7");
        final NumButton btn_otto =new NumButton(this,"8","8");
        final NumButton btn_nove =new NumButton(this,"9","9");
        final NumButton btn_zero =new NumButton(this,"0","0");
        final NumButton btn_canc =new NumButton(this,"CANC","C");
        final NumButton btn_res =new NumButton(this,"=","=");
        
        NumBottons.getChildren().addAll(btn_sette,btn_otto,btn_nove,btn_diviso,btn_quattro,btn_cinque,btn_sei,btn_per,btn_uno,btn_due,btn_tre,btn_meno,btn_canc,btn_zero,btn_res,btn_piu);
        NumBottons.setPrefColumns(3);

        root.setCenter(NumBottons);
        root.setAlignment(NumBottons, Pos.CENTER);
        
        
        
        
        EventHandler<KeyEvent>	keyEventHandler	= new EventHandler<KeyEvent>(){	
            @Override	
            public void handle(KeyEvent	e){
                if (e.getCode().equals(KeyCode.DELETE)){
                    System.out.println("Buttom	CANC pressed");
                    reset();
                }
                if (e.getCharacter().equals("+")){
                    System.out.println("Buttom	+ pressed");
                    SelSegno("+");
                }
                if (e.getCharacter().equals("-")){
                    System.out.println("Buttom	- pressed");
                    SelSegno("-");
                }
                if (e.getCharacter().equals("*")){
                    System.out.println("Buttom	* pressed");
                    SelSegno("*");
                }
                if (e.getCharacter().equals("/")){
                    System.out.println("Buttom	/ pressed");
                    SelSegno("/");
                }
                if ((e.getCode().equals(KeyCode.ENTER))|| (e.getCharacter().equals("="))){
                    System.out.println("Buttom	= pressed");
                    //NumBottons.getChildren().get(14).fireEvent(e);
                    //NumBottons.getChildren().get(14).requestFocus();
                    btn_res.fire();
                    calcola();
                    System.out.println(input.getText());
                    
                }
            }};
        primaryStage.addEventHandler(javafx.scene.input.KeyEvent.KEY_TYPED,keyEventHandler);
        input.addEventHandler(javafx.scene.input.KeyEvent.KEY_TYPED,keyEventHandler);
        
        input.setOnKeyPressed(keyEventHandler);
        
        //MODIFICARE IN TEMPO REALE LE MISURE WIDTH E HEIGHT
        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                double w = newValue.doubleValue() * 3 / 5;
                input.setMaxWidth(w);
               
                NumBottons.setMaxWidth(w);
                NumBottons.setMinWidth(w);
                double iw = Math.floor(w / 4);
                
                btn_uno.setOBWidth(iw);
                btn_due.setOBWidth(iw);
                btn_tre.setOBWidth(iw);
                btn_quattro.setOBWidth(iw);
                btn_cinque.setOBWidth(iw);
                btn_sei.setOBWidth(iw);
                btn_sette.setOBWidth(iw);
                btn_otto.setOBWidth(iw);
                btn_nove.setOBWidth(iw);
                btn_zero.setOBWidth(iw);
                btn_canc.setOBWidth(iw);
                btn_res.setOBWidth(iw);
                
                btn_piu.setOBWidth(iw); 
                btn_meno.setOBWidth(iw);
                btn_diviso.setOBWidth(iw);
                btn_per.setOBWidth(iw);
            }
        });
        //MODIFICARE IN TEMPO REALE LE MISURE WIDTH E HEIGHT
        primaryStage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                double w = newValue.doubleValue() * 3 / 5;
                input.setMaxHeight(w);

               
                NumBottons.setMaxHeight(w);
                NumBottons.setMinHeight(w);
                double iw = Math.floor(w / 4);
                
                btn_uno.setOBHeight(iw);
                btn_due.setOBHeight(iw);
                btn_tre.setOBHeight(iw);
                btn_quattro.setOBHeight(iw);
                btn_cinque.setOBHeight(iw);
                btn_sei.setOBHeight(iw);
                btn_sette.setOBHeight(iw);
                btn_otto.setOBHeight(iw);
                btn_nove.setOBHeight(iw);
                btn_zero.setOBHeight(iw);
                btn_canc.setOBHeight(iw);
                btn_res.setOBHeight(iw);
                
                btn_piu.setOBHeight(iw); 
                btn_meno.setOBHeight(iw);
                btn_diviso.setOBHeight(iw);
                btn_per.setOBHeight(iw);
            }
        });
        
        
        Scene scene = new Scene(root, 500, 250);
        
        primaryStage.setTitle("Calcolatrice 3.0");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void reset(){
        piu=meno=per=diviso=false;
        btn_piu.setDisable(false);
        btn_meno.setDisable(false);
        btn_per.setDisable(false);
        btn_diviso.setDisable(false);
        
        input.setText("");
    }
    public void Add(String msg){
        msg = input.getText()+msg;
        input.setText(msg);
    }
    public void Esegui(String operation){
        System.out.println("test "+input.getText());
        switch(operation){
            case "+": double tmp= Double.parseDouble(input.getText());
                System.out.println("aa "+tmp);        
                tmp+=tmp;
                System.out.println(tmp);
                input.setText(String.valueOf(tmp));break;
        }
    }
    public void SelSegno(String segno){
        switch(segno){
            case "+": piu=true;btn_per.setDisable(true);btn_diviso.setDisable(true);btn_meno.setDisable(true); break;
            case "-": meno=true;btn_per.setDisable(true);btn_diviso.setDisable(true);btn_piu.setDisable(true);break;
            case "*": per=true;btn_piu.setDisable(true);btn_diviso.setDisable(true);btn_meno.setDisable(true);break;
            case "/": diviso=true;btn_per.setDisable(true);btn_piu.setDisable(true);btn_meno.setDisable(true);break;
        }
    }
    public void calcola(){
        if(piu){
            String arr[]=input.getText().split("\\+");
            double db=Double.parseDouble(arr[0]);
            for (int i=1;i<arr.length;i++) {
                db=db+ Double.parseDouble(arr[i]);
            }
            input.setText(String.valueOf(db));
        }else if(meno){
            String arr[]=input.getText().split("\\-");
            double db=Double.parseDouble(arr[0]);
            for (int i=1;i<arr.length;i++) {
                db=db- Double.parseDouble(arr[i]);
            }
            input.setText(String.valueOf(db));
        }else if(per){
            String arr[]=input.getText().split("\\*");
            double db=Double.parseDouble(arr[0]);
            for (int i=1;i<arr.length;i++) {
                db=db* Double.parseDouble(arr[i]);
            }
            input.setText(String.valueOf(db));
        }else if(diviso){
            String arr[]=input.getText().split("/");
            System.out.println(arr[0]+""+arr[1]+""+arr.length);
            double db=Double.parseDouble(arr[0]);
            for (int i=1;i<arr.length;i++) {
                db=db / Double.parseDouble(arr[i]);
                
            }
            input.setText(String.valueOf(db));
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    } 
}
