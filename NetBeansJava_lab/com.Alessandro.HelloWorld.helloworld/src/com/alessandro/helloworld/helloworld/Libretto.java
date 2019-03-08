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
public class Libretto {
    Esame esami[];
    float media;
    int indice;
    
    public Libretto(){
        //inizializzo array
        esami=new Esame[10];
        for (int i = 0; i < 10; i++) {
            esami[i]=new Esame();
        }
        indice=0;
    }
    public void addEsame(String _n,int _v){
        System.out.println("entra AddEsame");
        esami[indice].nome=_n;
        esami[indice].voto=_v;
        indice++;
        media= CalcolaMedia();
    }
    private float CalcolaMedia(){
        int sum=0;
        for (int i = 0; i < indice; i++) {
           sum+=esami[i].voto;
        }
        return sum/ (float) indice;
    }
}
