package it.unitn.lingProg.ronchet.esercitazione3a;

import java.util.Random;

public class Esercitazione3a {

    Mazzo m=null;
    public static void main(String[] args) {
        new Esercitazione3a();
    }
    public Esercitazione3a(){
        int nMazziBase = 2;
        m = new Mazzo(nMazziBase);
        m.mescola();
        Mazzo mazzetto = new Mazzo();
        mazzetto.addAll(m.subList(0, 10));
        System.out.println(mazzetto);
        Carta doppia = mazzetto.contieneCarteUguali();
        if (doppia!=null) controllaRaddoppio(doppia);
    }

    private void controllaRaddoppio(Carta doppia) {
        Random rg = new Random(System.currentTimeMillis());
        Carta aCaso = null;
        //dobbiamo stare attenti a non estrarre una carta 
        //appartenente alla coppia di carte uguali già selezionate
        do {
            int k = rg.nextInt(m.size());
            aCaso = m.get(k);
        } while (doppia.equals(aCaso));
        System.out.print("Estratto "+aCaso);
        if (aCaso.seme.equals(doppia.seme)) {
            System.out.println(" Raddoppiato!");
        } else {
            System.out.println(" Raddoppio fallito!");
        }   
    }

}
