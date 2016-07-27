/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenc.controllers;

import com.gerenc.dao.CampeonatoDao;
import com.gerenc.dao.TimeDao;
import com.gerenc.objects.Campeonato;
import com.gerenc.objects.Time;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JoséAugusto
 */
public class ControllerCampeonato {

 public boolean localizarNomeTabela(String nomeCampeonato, JTable tabela){  
        boolean result = false;
        for (int linha = 0; linha < tabela.getRowCount(); linha++){    
             String celula = (String) tabela.getValueAt(linha, 1);    
             if (celula.equals(nomeCampeonato)){    
                 result = true;
                 tabela.setCellSelectionEnabled(false); //Precisa estar false! 
                 tabela.setRowSelectionAllowed(true);                 
                 tabela.setRowSelectionInterval(linha, linha); 
                 tabela.setColumnSelectionInterval(0, 2);
                 break;
             } else{
                 result = false;
             } 
        }
        System.out.println(result);
        return result;
    }    
    
    public void atualizarTabela(JTable tabela) {
            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
            modelo.setNumRows(0);
            CampeonatoDao dao = new CampeonatoDao();
            for (Campeonato camp : dao.getCampeonatos()) {
               modelo.addRow(new Object[]{camp.getId(), camp.getNome(), camp.getMax()});
            }
    }
    
    public void inserirCampeonatoTabela(JTable tabela, String nomeCampeonato, Integer quantMaxTimes) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        Campeonato camp = new Campeonato();
        if (nomeCampeonato.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Verifique se o campo 'Nome do Campeonato' está preenchido.");
        } else{
            if (quantMaxTimes > 2) {
                camp.setNome(nomeCampeonato);
                camp.setMax(quantMaxTimes);
                CampeonatoDao dao = new CampeonatoDao();
                try {
                    if (dao.getCampeonatoByName(camp.getNome()).first()){
                        JOptionPane.showMessageDialog(null, "Campeonato existente na base de dados.");
                    } else{
                        dao.inserirCampeonato(camp);
                        atualizarTabela(tabela);
                    }

                } catch (SQLException ex) {
                       JOptionPane.showMessageDialog(null, "Não foi possível inserir o Campeonato na base de dados.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Só é possível criar Campeonatos com no mínimo três times.");
            }
        }
    }    

    public Campeonato getSelecionadoTabela(JTable tabela){
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        Campeonato camp = new Campeonato();
        if (tabela.getSelectedColumnCount()!=0){
            camp.setId((Integer) tabela.getValueAt(tabela.getSelectedRow(),0));
            camp.setNome((String) tabela.getValueAt(tabela.getSelectedRow(),1));
            camp.setMax((Integer) tabela.getValueAt(tabela.getSelectedRow(), 2));
        } else{
            camp = null;
            JOptionPane.showMessageDialog(null, "Selecione o Campeonato.");
        }
        return camp;
    }    
    
    public void excluirCampeonatoTabela(JTable tabela) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        int linhaSelecionada = -1;
        linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada >= 0) {
                int idCampeonato = (int) tabela.getValueAt(linhaSelecionada, 0);
                CampeonatoDao dao = new CampeonatoDao();
                dao.remover(idCampeonato);
                modelo.removeRow(linhaSelecionada);
        } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
        }
    }  
    
    
        public void inserirTabela(JTable tabela, JTextField jText, JTextField jText1) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        Time time = new Time();
        time.setNome(jText.getText());
        TimeDao dao = new TimeDao();
        try {
            if (dao.getResultSetByName(time.getNome()).first()){
                JOptionPane.showMessageDialog(null, "Time existente na base de dados.");
            } else{
                dao.inserir(time);
                atualizarTabela(tabela);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir o time na base de dados.");
        }
    }
    
    public DefaultListModel addListTimes(JList jList){
        TimeDao timeDao = new TimeDao();
        List <Time> times = timeDao.getTimes();
        DefaultListModel modelo = new DefaultListModel();   
        for (Time time : times) {
            modelo.addElement(time.getNome());
        }
        jList.setModel(modelo);
        return modelo;
    }
    
    
}
