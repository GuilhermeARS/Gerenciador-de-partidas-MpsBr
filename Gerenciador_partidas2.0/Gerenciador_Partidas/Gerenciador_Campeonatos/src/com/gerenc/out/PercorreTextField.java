/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gerenc.out;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author augusto
 */
public class PercorreTextField {
    
    
     public void criaJTextFields(javax.swing.JPanel vPanel, int vQuant){
          vPanel.removeAll();
          vPanel.updateUI();
          
          if (vQuant > 2 && vQuant < 21){
               for (int j = 0; j < vQuant; j++ ){
               JTextField xTextField = new JTextField("Time"+Integer.toString(j+1));
               xTextField.setHorizontalAlignment(JTextField.CENTER);
               vPanel.add(xTextField);
               vPanel.updateUI();
               }
           }
           else {
           JOptionPane.showMessageDialog(null, "Precisa haver no mínimo 3 e no máximo 20 times para montar um campeonato!","Novo Camepeonato", 1);
           vPanel.removeAll();
           vPanel.updateUI();             
           }
       }  
}
