/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenc.controllers;

import com.gerenc.dao.TimeDao;
import com.gerenc.dao.TimesCampeonatoDao;
import com.gerenc.objects.Campeonato;
import com.gerenc.objects.Time;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author JoséAugusto
 */
public class ControllerTimesCampeonato {
    
    private ControllerCampeonato controllerCampeonato = new ControllerCampeonato();
    private Integer contador;
    private TimesCampeonatoDao timeCampDao;
    private TimeDao timeDao;

    public ControllerTimesCampeonato() {
        timeCampDao = new TimesCampeonatoDao();
        timeDao = new TimeDao();
    }

       
    public void ordenarLista(DefaultListModel modeloDefault){
        List lista = Arrays.asList(modeloDefault.toArray());
        Collections.sort(lista);
        modeloDefault.removeAllElements();
        for (int i=0; i< lista.size();i++){
            modeloDefault.addElement(lista.get(i));
        }
    }
    

    public void removerEntreListas(JList jLista, DefaultListModel modelo, DefaultListModel modelo1){
        int indices[] = jLista.getSelectedIndices();
        List selectedValues = jLista.getSelectedValuesList();
            for (int i=indices.length-1; i>=0; i--){
                modelo.addElement(selectedValues.get(i));
                Time time = timeDao.getTimeByName((String) selectedValues.get(i));
                timeCampDao.remover(time.getId());
                modelo1.removeElement(selectedValues.get(i));
                contador = modelo1.getSize();
            }
    }
    
    /**
     * @param camp o Objeto Campeonato, pode ser obtido por meio do acesso ao 
     * método getSelecionadoTabela(jTable) do ControllerCampeonato
     */
    public void inserirEntreListas(JList jLista, JTable jTable, DefaultListModel modelo, DefaultListModel modelo1){
        Campeonato camp = new Campeonato();
        camp = controllerCampeonato.getSelecionadoTabela(jTable);
            if (camp != null){
                int j = camp.getMax();
                int indices[] = jLista.getSelectedIndices();
                List selectedValues = jLista.getSelectedValuesList(); 
                    for (int i=indices.length-1; i>=0; i--){
                        if (contador<j){ 
                            if (verificarItemNaoExiste(selectedValues.get(i),modelo1)){
                                JOptionPane.showMessageDialog(null, "Esse item já foi selecionado.");
                            } else{
                                modelo1.addElement(selectedValues.get(i));
                                Time time = timeDao.getTimeByName((String) selectedValues.get(i));
                                timeCampDao.inserirTimeCampeonato(camp, time);
                                modelo.removeElement(selectedValues.get(i));
                                contador = contador+1;
                            }
                        } else{
                            JOptionPane.showMessageDialog(null, "Erro: Não é possível exceder o quantitativo de  " 
                                    + Integer.toString(j) + " itens. Reveja os itens selecionados.");
                            
                            break;
                        }
                    }
            }
            
    }
    
    public boolean verificarItemNaoExiste(Object item, DefaultListModel modelo1){
        boolean result = false;
        for (int i=0; i<modelo1.getSize();i++){
            if(modelo1.get(i).equals(item)){
                result = true;
                break;
            }
            else{
                result = false;
            }
        }
        return result;
    }
    
    
}
