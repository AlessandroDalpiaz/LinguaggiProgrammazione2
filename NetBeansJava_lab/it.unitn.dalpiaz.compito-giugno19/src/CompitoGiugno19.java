/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        System.out.println("num inertito : "+num_figure);
        //pdf 5_JavaFXIntro.pptx.pdf
        /*TextInputDialog dialog= new TextInputDialog("Default answer");
        dialog.setTitle("Dialog Title");
        dialog.setHeaderText("Dialog header");
        dialog.setContentText("Answer label:");
        String s= dialog.showAndWait().get();*/
        
        
        VBox colonna =new VBox();       
        HBox eliminati_box = new HBox();
        
        
        root.setLeft(btn_riordina);
        root.setCenter(colonna);
        root.setBottom(eliminati_box);
        
        btn_riordina.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent t) {
                System.out.println("hai cliccario il bootonz");
            }
            
        });
        EventHandler<KeyEvent> eventoTasti = new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent t) {
                System.out.println(t.getCharacter());
                if(t.getCharacter().equals("R")){
                    System.out.println("hai cliccato R");
                }
            }
        };
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, eventoTasti);
        generaColonna(num_figure);
        System.out.println(num_figure);
        
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
    void generaColonna(int num){
        int num_ciascuno= num/2;
        int contaR;
        int contaC;
        contaC = contaR=num_ciascuno;
        for (int i = 0; i < num; i++) {
            if (randomGenerator(11)>5 && contaC!=0) {
                CircleTile c=new CircleTile(randomGenerator(9)+1,Color.rgb(randomGenerator(256),randomGenerator(256),randomGenerator(256)));
                while(checkIfExist(c)){
                    c=new CircleTile(randomGenerator(9)+1,Color.rgb(randomGenerator(256),randomGenerator(256),randomGenerator(256)));
                }
                System.out.println("circle -->"+contaC);
                elementiArray.add(c);
                contaC--;
            }else if(contaR!=0){
                SquareTile r=new SquareTile(randomGenerator(9)+1,Color.rgb(randomGenerator(256),randomGenerator(256),randomGenerator(256)));
                while(checkIfExist(r)){
                    r=new SquareTile(randomGenerator(9)+1,Color.rgb(randomGenerator(256),randomGenerator(256),randomGenerator(256)));
                }
                System.out.println("rett -->"+contaR);
                elementiArray.add(r);
                contaR--;
            }
        }
    }
    boolean tileEquals(Tile t1,Tile t2){
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
