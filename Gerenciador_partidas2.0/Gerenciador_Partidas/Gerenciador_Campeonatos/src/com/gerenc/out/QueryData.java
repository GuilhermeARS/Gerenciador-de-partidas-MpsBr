/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gerenc.out;

import com.gerenc.bd.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;



/**
 *
 * @author augusto
 */
public class QueryData {
   static final String query3 = "INSERT INTO tab_time(TIME_NOME)"+"VALUES (?)";;

    
   public void Pesquisa(String valorPesquisa){
         try{
                
                 Connection con = FabricaConexao.getConexao();
                 PreparedStatement stat = con.prepareStatement(query3); 
                 stat.setString(1, valorPesquisa);
                 stat.execute();
                 }catch(Exception e) {
                         System.err.println("Erro");
                    System.err.println(e.getMessage());
                 }     
        
    } 
}
