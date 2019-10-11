package it.unitn.lingProg.ronchet.esercitazione3a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Mazzo extends ArrayList<Carta> {
    /**
     * crea un mazzo contenente n carte per tipo
     * @param n 
     */
    Mazzo(int n) {
        for (Seme s : Seme.values()) {
            for (Valore v : Valore.values()) {
                for (int i = 0; i < n; i++) {
                    add(new Carta(s, v));
                }
            }
        }
    }
    /**
     * genera un mazzo vuoto
     */
    Mazzo() {}
    /**
     * costruttore di copia: crea una copia contenente le stesse carte
     * @param m mazzo da copiare
     */
    Mazzo(Mazzo m) {
        this.addAll(m);
    }
    void mescola() {
        Collections.shuffle(this);
    }
    void riordinaPerValore(){
        Collections.sort(this);
    }
    void riordinaPerSeme(){
        Collections.sort(this,new ComparatoreDiCartePerSeme());
    }

    @Override
    public String toString() {
        String s="";
        for (Carta c:this) {
            s=s.concat(c.toString());
        }
        return "Mazzo{" + s+'}';
    }
    public Carta contieneCarteUguali(){
        // crea una copia del mazzo per poterla riordinare 
        // senza modificare il mazzo di origine
        // se due carte sono uguali, saranno adiacenti nel
        // mazzo riordinato
        Mazzo m = new Mazzo(this);
        //Mazzo m=(Mazzo)(this.clone());
        m.riordinaPerValore();
        Carta prossimaCarta,questaCarta=null;
        Carta doppia=null;
        Iterator<Carta> iter=m.iterator();
        // proteggi dal mazzo vuoto
        if (iter.hasNext()) questaCarta=iter.next();
        while (iter.hasNext()) {
            prossimaCarta=iter.next();
            if (questaCarta.equals(prossimaCarta)){
                doppia=questaCarta;
                break;
            }
            questaCarta=prossimaCarta;
        }
        if (doppia!=null) {
            System.out.println("Hai vinto: Trovato coppia uguale : "+doppia);
        }
        else {
            System.out.println("Hai perso: Non trovato coppia uguale.");
        }
        return doppia;
    }
    public static void main(String a[]){
        Mazzo m=new Mazzo(2);
        m.mescola();
        System.out.println(m);
        System.out.println("====================");
        m.riordinaPerSeme();
        System.out.println(m);
        System.out.println("====================");
        m.riordinaPerValore();
        System.out.println(m);
    }
}
