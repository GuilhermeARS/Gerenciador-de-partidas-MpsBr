/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenc.controllers;

import com.gerenc.dao.TimeDao;
import com.gerenc.objects.Time;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JoséAugusto
 */
public class ControllerTimes {
    
 public boolean localizarNomeTimeTabela(String nomeTime, JTable tabela){  
        boolean result = false;
        for (int linha = 0; linha < tabela.getRowCount(); linha++){    
             String celula = (String) tabela.getValueAt(linha, 1);    
             if (celula.equals(nomeTime)){    
                 result = true;
                 tabela.setCellSelectionEnabled(false); //Precisa estar false! 
                 tabela.setRowSelectionAllowed(true);
                 tabela.setRowSelectionInterval(linha, linha); 
                 tabela.setColumnSelectionInterval(0, 1);
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
            TimeDao dao = new TimeDao();
            for (Time time : dao.getTimes()) {
               modelo.addRow(new Object[]{time.getId(), time.getNome()});
            }
    }
    
    public void inserirTimeTabela(JTable tabela, JTextField jText) {
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
                JOptionPane.showMessageDialog(null, "Erro: Não foi possível inserir Time na Base de Dados.");
        }
    }
    
    public void excluirTimeTabela(JTable tabela) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        int linhaSelecionada = -1;
        linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada >= 0) {
                int idTime = (int) tabela.getValueAt(linhaSelecionada, 0);
                TimeDao dao = new TimeDao();
                dao.remover(idTime);
                modelo.removeRow(linhaSelecionada);
        } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
        }
    }    
    
    
    
}
