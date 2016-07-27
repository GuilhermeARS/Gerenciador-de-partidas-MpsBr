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
public class CampeonatoDao {
        private final String INSERT_CAMP = "INSERT INTO TAB_CAMP (CAMP_NOME, CAMP_QUANT_TIME) VALUES (?,?)";
	private final String UPDATE_CAMP = "UPDATE TAB_CAMP SET CAMP_NOME=?, CAMP_QUANT_TIME=? WHERE CAMP_ID=?";
	private final String DELETE_CAMP = "DELETE FROM TAB_CAMP WHERE CAMP_ID =?";
	private final String LIST_CAMP = "SELECT * FROM TAB_CAMP";
	private final String LISTBYID_CAMP = "SELECT * FROM TAB_CAMP WHERE CAMP_ID=?";
        private final String LISTBYNAME_CAMP = "SELECT * FROM TAB_CAMP WHERE CAMP_NOME =?";
        
    
	public void inserirCampeonato(Campeonato camp) {
		if (camp != null) {
			Connection conn = null;
			try {
				conn = FabricaConexao.getConexao();
				PreparedStatement pstm;
				pstm = conn.prepareStatement(INSERT_CAMP);
				pstm.setString(1, camp.getNome());
                                pstm.setInt(2, camp.getMax());
				pstm.execute(); 
				JOptionPane.showMessageDialog(null, "Campeonato cadastrado com sucesso");
                                FabricaConexao.fecharConexao();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao inserir time no banco de"
						+ "dados " + e.getMessage());
			}
		} else {
			System.out.println("O time enviado por parâmetro está vazio");
		}
	}

	/*public void inserirTimesCampeonato(Campeonato camp, Time time) {
		if (time != null) {
			Connection conn = null;
			conn = FabricaConexao.getConexao();
			PreparedStatement pstm;
                        try {
				pstm = conn.prepareStatement(INSERT_CAMP);
				pstm.setInt(1, camp.getMax());
                                pstm.setInt(2, camp.getId());
                                
				pstm.execute();
				//JOptionPane.showMessageDialog(null, "Campeonato cadastrado com sucesso");
                                FabricaConexao.fecharConexao();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao inserir time no banco de"
						+ "dados " + e.getMessage());
			}
		} else {
			System.out.println("O time enviado por parâmetro está vazio");
		}
	}  */      
       
	public Campeonato getCampeonatoById(int id) {
            Connection conn = null;
            PreparedStatement pstm = null;
            ResultSet rs = null;
            Campeonato camp = new Campeonato();
            try {
                    conn = FabricaConexao.getConexao();
                    pstm = conn.prepareStatement(LISTBYID_CAMP);
                    pstm.setInt(1, id);
                    rs = pstm.executeQuery();
                    while (rs.next()) {
                            camp.setId(rs.getInt("CAMP_ID"));
                            camp.setNome(rs.getString("CAMP_NOME"));
                            camp.setMax(rs.getInt("CAMP_QUANT_TIME"));
                    }
                    //FabricaConexao.fechaConexao(conn, pstm, rs);
                    FabricaConexao.fecharConexao();
            } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao listar Campeonatos" + e.getMessage());
            }
            return camp;
	}
        
	public List<Campeonato> getCampeonatos() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Campeonato> campeonatos = new ArrayList<Campeonato>();
		try {
			conn = FabricaConexao.getConexao();
			pstm = conn.prepareStatement(LIST_CAMP);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Campeonato camp = new Campeonato();
				camp.setId(rs.getInt("CAMP_ID"));
				camp.setNome(rs.getString("CAMP_NOME"));
                                camp.setMax(rs.getInt("CAMP_QUANT_TIME"));
				campeonatos.add(camp);
			}
                        FabricaConexao.fecharConexao();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar Campeonatos" + e.getMessage());
		}
		return campeonatos;
	}
        
	public ResultSet getCampeonatoByName(String nome) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
                Campeonato camp = new Campeonato();
		try {
			conn = FabricaConexao.getConexao();
			pstm = conn.prepareStatement(LISTBYNAME_CAMP);
			pstm.setString(1, nome);
			rs = pstm.executeQuery();
			while (rs.next()) {
				camp.setId(rs.getInt("CAMP_ID"));
				camp.setNome(rs.getString("CAMP_NOME"));
                                camp.setMax(rs.getInt("CAMP_QUANT_TIME"));
			}
			//FabricaConexao.fechaConexao(conn, pstm, rs);
                        FabricaConexao.fecharConexao();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar Campeonato" + e.getMessage());
		}
		return rs;
	}   
        
	public void remover(int id) {
		Connection conn = null;
		try {
			conn = FabricaConexao.getConexao();
			PreparedStatement pstm;
			pstm = conn.prepareStatement(DELETE_CAMP);
			pstm.setInt(1, id);
			pstm.execute();
//			FabricaConexao.fechaConexao(conn, pstm);
                        FabricaConexao.fecharConexao();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir "
			+ "Campeonato do banco de dados " + e.getMessage());
		}
	}
        
}
