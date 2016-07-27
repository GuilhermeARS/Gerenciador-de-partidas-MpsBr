/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenc.controllers;

import com.gerenc.dao.TimeDao;
import com.gerenc.dao.JogosDao;
import com.gerenc.dao.TimesCampeonatoDao;
import com.gerenc.objects.Campeonato;
import com.gerenc.objects.Time;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.Box.Filler;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author JoséAugusto
 */
public class ControllerJogos {
    
    private TimeDao timeDao = new TimeDao();
    private TimesCampeonatoDao timesCampDao = new TimesCampeonatoDao();
    private JogosDao jogosDao = new JogosDao();
    
    public void criarComponentes(JPanel jPanel, ResultSet rs) throws SQLException{
         Time timeCasa = new Time();
         Time timeVisitante = new Time();
        
         jPanel.removeAll();
         jPanel.updateUI(); 
         if (rs.last()) {
         int fim = rs.getRow();
            rs.first();
            for (int j = 0; j < rs.getRow() ; j++ ){
            JPanel xPanel = new JPanel();
            JLabel jLabel1 = new javax.swing.JLabel();
            JTextField jTextField1 = new javax.swing.JTextField();
            JLabel jLabel2 = new javax.swing.JLabel();
            JTextField jTextField2 = new javax.swing.JTextField();
            JLabel jLabel3 = new javax.swing.JLabel();
            Filler filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
            JLabel jLabel4 = new javax.swing.JLabel();
            JFormattedTextField jFormattedTextField1 = new javax.swing.JFormattedTextField();

            xPanel.setLayout(new FlowLayout());
            
            timeCasa = timeDao.getTimeById(rs.getInt("JOGO_ID_TIME1"));
            timeVisitante = timeDao.getTimeById(rs.getInt("JOGO_ID_TIME2"));
            
            jLabel1.setText(timeCasa.getNome());
            xPanel.add(jLabel1);
            jTextField1.setMinimumSize(new java.awt.Dimension(40, 25));
            jTextField1.setName(""); // NOI18N
            jTextField1.setPreferredSize(new java.awt.Dimension(40, 25));             
            xPanel.add(jTextField1);
            jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            jLabel2.setText("X");             
            xPanel.add(jLabel2);
            jTextField2.setMinimumSize(new java.awt.Dimension(40, 25));
            jTextField2.setName(""); // NOI18N
            jTextField2.setPreferredSize(new java.awt.Dimension(40, 25));            
            xPanel.add(jTextField2);
            jLabel3.setText(timeVisitante.getNome());             
            xPanel.add(jLabel3);
            xPanel.add(filler1);
            jLabel4.setText("Data:");             
            xPanel.add(jLabel4);
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
            jFormattedTextField1.setMinimumSize(new java.awt.Dimension(80, 25));
            jFormattedTextField1.setPreferredSize(new java.awt.Dimension(80, 25));
            xPanel.add(jFormattedTextField1);             
             
            xPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            xPanel.setSize(370, 32);
            xPanel.setBackground(new java.awt.Color(255, 255, 255));
            xPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            jPanel.add(xPanel);
            jPanel.updateUI();             
        }
     
    }
}
    
    public void criarNovoJogo(Campeonato camp){
        Time timeCasa = new Time() ;
        Time timeVisitante = new Time();
        ArrayList<String> tabela = montarTabela(camp);
         for (int i=0; i< tabela.size(); i++){
            System.out.println(tabela.get(i)); 
            String[] confronto = separarTimes(tabela, i);
            System.out.println(confronto[0]);
            //timeCasa = timeDao.getTimeByName(confronto[0]);
            timeVisitante = timeDao.getTimeByName(confronto[1]);
            //jogosDao.inserirJogoCampeonato(camp, timeCasa, timeVisitante);
         }
    }
    
    
    
    public ArrayList<String> montarTabela(Campeonato camp){
        List lista1 = timesCampDao.getCampTimesID(camp);
        List lista2 = timesCampDao.getCampTimesID(camp);
        ArrayList<String> listaFinal = new ArrayList<String>();
     for (int i=0; i < lista1.size(); i++){
         for (int j=i+1; j < lista2.size(); j++){
             listaFinal.add(lista1.get(i)+","+lista2.get(j));
             System.out.println(lista1.get(i)+","+lista2.get(j));
         }
     }
     Collections.shuffle(listaFinal);
     return listaFinal;
    }
    
    public String[] separarTimes(ArrayList<String> arrayTimes, int i){
        String times = (String) arrayTimes.get(i);
        return times.split(",");
    }
}
