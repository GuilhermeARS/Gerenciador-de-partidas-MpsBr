/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenc.dao;

import com.gerenc.bd.FabricaConexao;
import com.gerenc.objects.Campeonato;
import com.gerenc.objects.Time;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author JoséAugusto
 */

public class JogosDao {

        private final String INSERT_CAMP_JOGO = "INSERT INTO TAB_JOGO (CAMP_ID, JOGO_ID_TIME1, JOGO_ID_TIME2) VALUES (?,?,?)";
	private final String UPDATE = "UPDATE TAB_TIME SET TIME_NOME=? WHERE TIME_ID=?";
	private final String DELETE = "DELETE FROM TAB_TIME WHERE TIME_ID =?";
	private final String LIST = "SELECT * FROM TAB_TIME";
	private final String LISTBYID = "SELECT * FROM TAB_TIME WHERE TIME_ID=?";
        private final String LISTBYNAME = "SELECT * FROM TAB_TIME WHERE TIME_NOME =?";
        
        public void inserirJogoCampeonato(Campeonato camp, Time time1, Time time2) {
		if (camp != null) {
			Connection conn = null;
			try {
				conn = FabricaConexao.getConexao();
				PreparedStatement pstm;
				pstm = conn.prepareStatement(INSERT_CAMP_JOGO);
				pstm.setInt(1, camp.getId());
                                pstm.setInt(2, time1.getId());
                                pstm.setInt(3, time2.getId());
				pstm.execute(); 
				//JOptionPane.showMessageDialog(null, "Times incluídos com sucesso");
                                FabricaConexao.fecharConexao();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao inserir time no campeonato"
						+ e.getMessage());
			}
		} else {
			System.out.println("O time enviado por parâmetro está vazio");
		}
	}
  

    
}
