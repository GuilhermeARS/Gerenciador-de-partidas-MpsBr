/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenc.objects;

import java.util.ArrayList;

/**
 *
 * @author JoséAugusto
 */
public class Campeonato {
    private int id;
    private String nome;
    private int max;
    private ArrayList<Time> times;
    private ArrayList<Jogo> jogos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public ArrayList<Time> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<Time> times) {
        this.times = times;
    }
    
    public void setTime(Time time){
        this.times.add(time);
    }
    
    public void deleteTime (Time time){
       int i = this.times.indexOf(time);
       if (i!=-1){
           this.times.remove(i);
       }
    }
    
    public ArrayList<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(ArrayList<Jogo> jogos) {
        this.jogos = jogos;
    }

    public void setJogo(Jogo jogo){
        this.jogos.add(jogo);
    }
    
    public void deleteJogo (Jogo jogo){
       int i = this.jogos.indexOf(jogo);
       if (i!=-1){
           this.jogos.remove(jogo);
       }
    }
    
}
