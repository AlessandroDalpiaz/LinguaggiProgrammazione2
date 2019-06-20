

import static java.lang.Math.random;
import  java.util.Random;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alessandro
 */
public class Carta{ 
    enum Tseme{C,P,Q,F}
    int n;
    Tseme seme;
    
    Carta(){
        Random random=new Random();
        n= random.nextInt(12);//Valori compresi tra 0 e 10
        int tmp= random.nextInt(3);
        seme= scelta(tmp);
    }
    Carta(int _n,int j){
        n=_n;
        seme= scelta(j);
    }
    public void stampa(){
        System.out.println(n+" "+ seme);
    }
    public Tseme scelta(int i){
        Carta.Tseme seme = null;
        switch(i){
            case 0:seme=Tseme.C; break;
            case 1:seme=Tseme.P; break;
            case 2:seme=Tseme.Q; break;
            case 3:seme=Tseme.F; break;
        }
        return seme;
        
    }
    //sovrascrivo metodo toString()
    public String toString(){
         return n+" "+ seme;
    }
}