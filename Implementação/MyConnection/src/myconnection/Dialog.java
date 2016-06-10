/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

        
package myconnection;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author augusto
 */
public class Dialog extends JPanel{
    JTextField textfield, textfield1;
  JButton printButton, dialogButton, okayButton;
  static JFrame frame;
  public static void main(String[] args) {
    frame = new JFrame();
    frame.setSize(200, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new Dialog());
    frame.setVisible(true);
}
  
  Dialog() {
    textfield = new JTextField(10);
    add(textfield);
    ((AbstractButton) add(printButton = new JButton("Adicionar")))
        .addActionListener(new printListener());
    //((AbstractButton) add(dialogButton = new JButton("Dialog")))
        //.addActionListener(new dialogListener());
  }

  private class printListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      String string = textfield.getText();
      System.out.println(string);
    }
  }
  
  /*private class dialogListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JDialog dialog = new JDialog(frame, "Dialog", true);
      JPanel p = new JPanel();
      textfield1 = new JTextField(10);
      p.add(textfield1);
      p.add(okayButton = new JButton(new AbstractAction("Okay") {
        public void actionPerformed(ActionEvent e) {
          String string = null;
          textfield.setText(textfield1.getText());
          System.out.println(string);
          dialog.dispose();
        }
      }));
      dialog.add(p);
      dialog.pack();
      dialog.setVisible(true);
    }
  }*/
}
