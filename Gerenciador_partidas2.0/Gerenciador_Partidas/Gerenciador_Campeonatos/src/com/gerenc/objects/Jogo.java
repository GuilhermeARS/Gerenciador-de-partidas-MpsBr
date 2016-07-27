/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenc.objects;


/**
 *
 * @author JoséAugusto
 */
public class Jogo {
    private Time casa;
    private Time visitante;
    private int result_casa;
    private int result_visitante;

    public Time getCasa() {
        return casa;
    }

    public void setCasa(Time casa) {
        this.casa = casa;
    }

    public Time getVisitante() {
        return visitante;
    }

    public void setVisitante(Time visitante) {
        this.visitante = visitante;
    }

    public int getResult_casa() {
        return result_casa;
    }

    public void setResult_casa(int result_casa) {
        this.result_casa = result_casa;
    }

    public int getResult_visitante() {
        return result_visitante;
    }

    public void setResult_visitante(int result_visitante) {
        this.result_visitante = result_visitante;
    }
    
}
