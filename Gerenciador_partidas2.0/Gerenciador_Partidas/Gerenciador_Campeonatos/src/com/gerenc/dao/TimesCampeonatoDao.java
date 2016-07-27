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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JoséAugusto
 */
public class TimesCampeonatoDao {
    
        private final String INSERT_CAMP_TIME = "INSERT INTO TAB_CAMP_TIME (CAMP_ID, TIME_ID) VALUES (?,?)";
	private final String UPDATE_CAMP_TIME = "UPDATE TAB_CAMP_TIME SET CAMP_ID=?, TIME_ID=? WHERE CAMP_TIME_ID=?";
	private final String DELETE_CAMP_TIME = "DELETE FROM TAB_CAMP_TIME WHERE CAMP_TIME_ID =?";
        private final String LISTBYID_CAMP_TIME = 
                "SELECT TAB_TIME.TIME_NOME FROM TAB_TIME, TAB_CAMP_TIME, TAB_CAMP "+
                "WHERE TAB_CAMP.CAMP_ID=? AND " +
                "TAB_CAMP.CAMP_ID=TAB_CAMP_TIME.CAMP_ID AND "+
                "TAB_TIME.TIME_ID=TAB_CAMP_TIME.TIME_ID";
      	private final String LIST_TIME = "SELECT TIME_ID FROM TAB_CAMP_TIME WHERE CAMP_ID =?";

        private final String SELECT_ID = "SELECT CAMP_TIME_ID FROM TAB_CAMP_TIME WHERE CAMP_ID = ? AND TIME_ID = ?";
    
        public void inserirTimeCampeonato(Campeonato camp, Time time) {
		if (camp != null) {
			Connection conn = null;
			try {
				conn = FabricaConexao.getConexao();
				PreparedStatement pstm;
				pstm = conn.prepareStatement(INSERT_CAMP_TIME);
				pstm.setInt(1, camp.getId());
                                pstm.setInt(2, time.getId());
				pstm.execute(); 
				JOptionPane.showMessageDialog(null, "Time incluído com sucesso");
                                FabricaConexao.fecharConexao();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao inserir time no campeonato"
						+ e.getMessage());
			}
		} else {
			System.out.println("O time enviado por parâmetro está vazio");
		}
	}
        
        public void remover(int id) {
		Connection conn = null;
		try {
			conn = FabricaConexao.getConexao();
			PreparedStatement pstm;
			pstm = conn.prepareStatement(DELETE_CAMP_TIME);
			pstm.setInt(1, id);
			pstm.execute();
//			FabricaConexao.fechaConexao(conn, pstm);
                        FabricaConexao.fecharConexao();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir "
			+ "Campeonato do banco de dados " + e.getMessage());
		}
	}
        
        public int retornarID(int id, int id2){
            Connection conn = null;
            ResultSet rs;
            int result = 0;
            try {
			conn = FabricaConexao.getConexao();
			PreparedStatement pstm;
			pstm = conn.prepareStatement(SELECT_ID);
			pstm.setInt(1, id);
                        pstm.setInt(2, id2);
			rs = pstm.executeQuery();
			rs.first();
                        result = rs.getInt("CAMP_TIME_ID");
			
                        FabricaConexao.fecharConexao();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro "
			+ "ao buscar ID " + e.getMessage());
		}
                return result;
        }

        public List<Time> getCampTimesID(Campeonato camp) {
            Connection conn = null;
            PreparedStatement pstm = null;
            ResultSet rs = null;
            ArrayList<Time> times = new ArrayList<Time>();
            try {
                    conn = FabricaConexao.getConexao();
                    pstm = conn.prepareStatement(LIST_TIME);
                    pstm.setInt(1, camp.getId());
                    rs = pstm.executeQuery();
                    while (rs.next()) {
                            Time time = new Time();
                            time.setId(rs.getInt("TIME_ID"));
                            times.add(time);
                    }
                    //FabricaConexao.fechaConexao(conn, pstm, rs);
                    FabricaConexao.fecharConexao();
            } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao listar times/Campeonato " + e.getMessage());
            }
            return times;
	}

        
}
