/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alessandro.helloworld.helloworld;

/**
 *
 * @author Alessandro
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String s1="Hello";
       String s2="World";
       s1= s1.concat(s2);
       System.out.println(s1);
       
       ///esercizio 1
       Studente s= new Studente("Pippo","Cesare",125);
       s.libretto.addEsame("Geometria",27);
       s.libretto.addEsame("Fisica",22);
       
       System.out.print(s.persona.nome+"-"+s.persona.cognome+"; ");
       System.out.println(s.libretto.media);
       

    }
    
}
