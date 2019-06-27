/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Alessandro
 */
public class CompitoGiugno19 extends Application {
        ArrayList<Tile> elementiArray= new ArrayList();
        Button btn_riordina=new Button("Riordina");
        final VBox colonna =new VBox();       
        final HBox eliminati_box = new HBox();
        @Override
    public void start(Stage primaryStage) {
        BorderPane root =new BorderPane();
        /*********RICHIESTA UTENTE**********/
        int num_figure=0;
        boolean numCorrect=false;
        Scanner scanner =new Scanner(System.in);
        while(!numCorrect){
            System.out.println("inserisci un numero 3<N<11");
            num_figure= Integer.parseInt(scanner.nextLine());
            if(num_figure<11 && num_figure>3 && num_figure%2==0){
                numCorrect=true;
            }
        }
        //pdf 5_JavaFXIntro.pptx.pdf
        /*TextInputDialog dialog= new TextInputDialog("Default answer");
        dialog.setTitle("Dialog Title");
        dialog.setHeaderText("Dialog header");
        dialog.setContentText("Answer label:");
        String s= dialog.showAndWait().get();*/
        
        

        
        
        
        
        
        
        root.setLeft(btn_riordina);
        root.setCenter(colonna);
        root.setBottom(eliminati_box);
        
        btn_riordina.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent t) {
                elementiArray= ordinaLista();
                colonna.getChildren().clear();
                colonna.getChildren().addAll(elementiArray);
            }
            
        });
        EventHandler<KeyEvent> eventoTasti = new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent t) {
                if(t.getCode()==KeyCode.R){
                    elementiArray= ordinaLista();
                    colonna.getChildren().clear();
                    colonna.getChildren().addAll(elementiArray);
                }
            }
        };
        EventHandler<KeyEvent> eventoNum = new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent t) {
                for (int i = 0; i < elementiArray.size(); i++) {
                    for (int j = 0; j < 10; j++) {
                       if(t.getCharacter().equals(String.valueOf(j)) && elementiArray.get(i).numero==j){
                            elementiArray.get(i).gtlt();
                            aggiornaAlClick();
                       } 
                    }  
                }   
            }
        };
        EventHandler<MouseEvent> aggiornaOrdina = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                aggiornaAlClick();
            }
        };
        
        
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, eventoTasti);
        primaryStage.addEventHandler(KeyEvent.KEY_TYPED, eventoNum);
        primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, aggiornaOrdina);
        generaColonna(num_figure);       
        colonna.getChildren().addAll(elementiArray);
        
        
        Scene scene = new Scene(root, 520, 900);
        primaryStage.setTitle("Esame Giugno 2019");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * Generatore casuale di un intero da 0 a x-1
     * @param x numero max intervallo (escluso)
     * @return numero generato int
     */
    int randomGenerator(int x){
        Random rnd=new Random();
        return rnd.nextInt(x);
    }
    ArrayList<Tile> ordinaLista(){
        ArrayList<Tile> listaNuova =new ArrayList();
        //Collections.sort();
        int max=0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < elementiArray.size(); j++) {
                if(i==elementiArray.get(j).numero)
                {
                    listaNuova.add(elementiArray.get(j));
                }
            }
        }
        
        return listaNuova;
    }
    void aggiornaAlClick(){
        for (int i = 0; i < elementiArray.size(); i++) {
            for (int j = 0; j < elementiArray.size(); j++) {
               if (i!=j && tileEquals(elementiArray.get(i),elementiArray.get(j))) {
                    elementiArray.get(i).setDisable(true);
                    elementiArray.get(j).setDisable(true);
                    eliminati_box.getChildren().addAll(elementiArray.get(i),elementiArray.get(j));
                    elementiArray.remove(elementiArray.get(j));
                    elementiArray.remove(elementiArray.get(i));
               }
            }
        }
        for (int j = 0; j < elementiArray.size(); j++) {
            if(elementiArray.get(j).cliccato){
                elementiArray.get(j).cliccato=false;
                elementiArray=mettiSottoSopra(elementiArray.get(j));
                colonna.getChildren().clear();
                colonna.getChildren().addAll(elementiArray);
            }
        }
        
        
    }
    ArrayList<Tile> mettiSottoSopra(Tile t){
        ArrayList<Tile> newLista=new ArrayList();
        if(t instanceof SquareTile){
            newLista.add(t);
            for (int i = 0; i < elementiArray.size(); i++) {
                if (!tileEquals(elementiArray.get(i), t)) {
                    newLista.add(elementiArray.get(i));                            
                }
            }
        }else{
            for (int i = 0; i < elementiArray.size(); i++) {
                if (!tileEquals(elementiArray.get(i), t)) {
                    newLista.add(elementiArray.get(i));                            
                }
            }
            newLista.add(t);
        }
        return newLista;
    }
    void generaColonna(int num){
        int num_ciascuno= num/2;
        int contaR;
        int contaC;
        int rand;
        contaC = contaR=num_ciascuno;
        for (int i = 0; i < num; i++) {
            rand =randomGenerator(11);
            if (rand>5 && contaC!=0) {
                CircleTile c=new CircleTile(randomGenerator(10),Color.rgb(randomGenerator(256),randomGenerator(256),randomGenerator(256)));
                while(checkIfExist(c)){
                    c=new CircleTile(randomGenerator(10),Color.rgb(randomGenerator(256),randomGenerator(256),randomGenerator(256)));
                }
                elementiArray.add(c);
                contaC--;
            }else if(contaR!=0){
                SquareTile r=new SquareTile(randomGenerator(10),Color.rgb(randomGenerator(256),randomGenerator(256),randomGenerator(256)));
                while(checkIfExist(r)){
                    r=new SquareTile(randomGenerator(10),Color.rgb(randomGenerator(256),randomGenerator(256),randomGenerator(256)));
                }
                elementiArray.add(r);
                contaR--;
            }else{
                CircleTile c=new CircleTile(randomGenerator(9)+1,Color.rgb(randomGenerator(256),randomGenerator(256),randomGenerator(256)));
                while(checkIfExist(c)){
                    c=new CircleTile(randomGenerator(9)+1,Color.rgb(randomGenerator(256),randomGenerator(256),randomGenerator(256)));
                }
                elementiArray.add(c);
                contaC--;
            }
        }
    }
    boolean tileEquals(Tile t1,Tile t2){
        //System.out.println("t1--> "+ t1);
        //System.out.println("t2--> "+ t2);
        if (t1 instanceof SquareTile) {
            if (t2 instanceof SquareTile) {
                if(((SquareTile)t1).numero==((SquareTile)t2).numero){

                    return true;
                }
            }
        }else if (t1 instanceof CircleTile) {
            if (t2 instanceof CircleTile) {
                if (((CircleTile)t1).numero==((CircleTile)t2).numero) {
                    return true;
                }
            }
        }
        return false;
        //return ((t1 instanceof SquareTile)==(t2 instanceof SquareTile) && ((SquareTile)t1).numero==((SquareTile)t2).numero);// || ( && ((CircleTile)t1).numero==((CircleTile)t2).numero);
    }
    boolean checkIfExist(Tile t){
        for (int i = 0; i < elementiArray.size(); i++) {
            if (tileEquals(t,elementiArray.get(i))) {
                return true;
            }
        }
        return false;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
