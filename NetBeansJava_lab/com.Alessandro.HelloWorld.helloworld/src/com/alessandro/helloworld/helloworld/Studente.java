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
public class Studente {
    Persona persona=new Persona();
    Libretto libretto = new Libretto();
    int matricola;
    
    Studente(String _n,String _c,int _m){
        persona.nome=_n;
        persona.cognome= _c;
        matricola=_m;
        }
    }
