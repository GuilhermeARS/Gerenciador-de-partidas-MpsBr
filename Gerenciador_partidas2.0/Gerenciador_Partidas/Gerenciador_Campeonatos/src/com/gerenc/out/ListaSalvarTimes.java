/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gerenc.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author augusto
 */
public class ListaSalvarTimes {
   
    
    public ArrayList<String> salvarTimes(javax.swing.JPanel vPanel){
        ArrayList<String> lista = new ArrayList();
        for(int i=0;i<vPanel.getComponentCount();i++){
            if(vPanel.getComponent(i) instanceof JTextField){
                JTextField xTextField = (JTextField) vPanel.getComponent(i);
                lista.add(xTextField.getText());
                new QueryData().Pesquisa(xTextField.getText());
            }
        }
        return lista;
    }  
    
    /*public void testaMetodo(ArrayList<String> vLista){
        for(int i=0;i<vLista.size();i++){
            System.out.println(vLista.get(i));
        }
    }*/
    
   
}


