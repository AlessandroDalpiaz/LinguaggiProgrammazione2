
enum Seme {P,C,F,Q}

public class Carta {
    public Seme seme= null;
    public int numero=0;
    
    Carta(int n, Seme s){
        numero=n;
        seme=s;
    }  
    
    public Seme getSeme()
    {
        return seme;
    }
    public void stampa(){
        System.out.println("numero: "+ numero + ", seme: "+ seme);
    }
    
}
