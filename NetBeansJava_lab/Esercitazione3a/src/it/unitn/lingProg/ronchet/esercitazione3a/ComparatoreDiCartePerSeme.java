package it.unitn.lingProg.ronchet.esercitazione3a;

import java.util.Comparator;

public class ComparatoreDiCartePerSeme implements Comparator<Carta>{

    @Override
    public int compare(Carta c1, Carta c2) {
       if (c1 == c2)
            return 0;
        if (c1 ==null || c2==null)
            System.err.println("Error in compare "+c1+" "+c2);
        int s_comp=c1.seme.compareTo(c2.seme);
        //int v_comp=other.seme.ordinal()-this.seme.ordinal();
        if (s_comp!=0) return s_comp;
        int v_comp=c1.valore.compareTo(c2.valore);
        return v_comp;
    }
    
}
