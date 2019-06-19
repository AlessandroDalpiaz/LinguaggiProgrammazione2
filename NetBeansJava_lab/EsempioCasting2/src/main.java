/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alessandro
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        A a = new A();
        A ab= new B();
        B b = new B();
        
        a.g(a);
        a.g(ab);
        a.g(b);
        System.out.println("");
        ab.g(a);
        ab.g(ab);
        ab.g(b);
        System.out.println("");
        b.g(a);
        b.g(ab);
        b.g(b);
        
    }
    
}
class	A{
    public void	g(A x){
        System.out.println("called on instance of A");
    }			
}	
class	B extends A {
    public void	g(A x){
        System.out.println("called 1 on instance of B");
    }	
    public void	g(B x){
        System.out.println("called 2 on instance of B");
    }	
}
/** OUTPUT
called on instance of A
called on instance of A
called on instance of A

called 1 on instance of B
called 1 on instance of B
called 1 on instance of B

called 1 on instance of B
called 1 on instance of B
called 2 on instance of B
 **/