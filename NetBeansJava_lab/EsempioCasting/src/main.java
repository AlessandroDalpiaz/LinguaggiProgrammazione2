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
        B b = new B();
        C c=new C();
        a.f1();
        a=c; //se faccio a=b 
        ((C)a).f2(); //non va
        System.out.println();
        c.ale();
        
    }
    
}
class A { 
    void f1(){
        System.out.println("f1");
    }
    void ale(){
        System.err.println("ale");
    }
}
class B extends A {
    void f2(){
        System.out.println("f2");
    }
    void ale(){
        
        System.err.println("ALE");
        super.ale();
    }
}
class C extends B {
    void f3(){
        System.out.println("f3");
    }
    void ale(){
        super.ale();
        System.err.println("a_l_e");
    }
}
/** OUTUPUT 
f1
f2

ALE
ale
a_l_e

**/