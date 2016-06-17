/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myconnection;

 import java.util.ArrayList;
 import java.util.Collections;
/**
 *
 * @author augusto
 */
public class AgendaJogos {
    public ArrayList<String> criaListaArray(int vQuantidade){
      ArrayList<String> vLista = new ArrayList<>(vQuantidade);
      for (int i=0; i < vQuantidade; i++){
          vLista.add("Time"+Integer.toString(i+1));
      }
      return vLista;
  }    
      
  
  public ArrayList<String> montaTabelaJogosArray (ArrayList<String> xLista){
      ArrayList<String> lista1 = xLista;
      ArrayList<String> lista2 = xLista;
      ArrayList<String> listaFinal = new ArrayList();
      for (int i=0; i < lista1.size(); i++){
          for (int j=i+1; j < lista2.size(); j++){
              listaFinal.add(lista1.get(i)+" X "+lista2.get(j));
          }
      }
      Collections.shuffle(listaFinal);
      return listaFinal;
  }
  
  public void mostraTabelaArray(ArrayList<String> zLista){
      for (int i=0; i < zLista.size(); i++){
         System.out.println(zLista.get(i));
      }    
     
     
     
 }
}
