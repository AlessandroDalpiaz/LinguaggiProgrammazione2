
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alessandro
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Carta> mazzo = new ArrayList<Carta>();
        LinkedList<Carta> mazzo2 = new LinkedList<Carta>();
        HashSet<Carta> mazzo3 = new HashSet<Carta>();
        //inizializzo
        for(int i=0;i<4;i++){
            for (int j = 1; j < 14; j++) {
                mazzo.add(new Carta(j,i));
                mazzo2.add(new Carta(j,i));
                mazzo3.add(new Carta(j,i));
            }
        }
        System.out.println("mazzo \tmazzo2 \t mazzo3");
        for (int i = 0; i < 52; i++) {
            System.out.println(" "+ mazzo.get(i).n+ " "+ mazzo.get(i).seme + "\t" + mazzo2.get(i).n+ " "+ mazzo2.get(i).seme+ "\t"+mazzo3.toString()+ " "); 
        }
        //mazzo1 e 2 ordinati, mentre mazzo3 già mescolato
        Collections.shuffle(mazzo);
        Collections.shuffle(mazzo2);
        System.out.println("-------------MESCOLATE-------------");
        for (Carta c : mazzo) {
            c.stampa();
        }
    }
}
