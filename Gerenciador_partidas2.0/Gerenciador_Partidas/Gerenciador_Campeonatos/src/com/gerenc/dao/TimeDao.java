/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerenc.dao;

import com.gerenc.bd.FabricaConexao;
import com.gerenc.objects.Time;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author  Augusto César
 */
public class TimeDao {
    	private final String INSERT = "INSERT INTO TAB_TIME (TIME_NOME) VALUES (?)";
	private final String UPDATE = "UPDATE TAB_TIME SET TIME_NOME=? WHERE TIME_ID=?";
	private final String DELETE = "DELETE FROM TAB_TIME WHERE TIME_ID =?";
	private final String LIST = "SELECT * FROM TAB_TIME";
	private final String LISTBYID = "SELECT * FROM TAB_TIME WHERE TIME_ID=?";
        private final String LISTBYNAME = "SELECT * FROM TAB_TIME WHERE TIME_NOME =?";
        
	public void inserir(Time time) {
		if (time != null) {
			Connection conn = null;
			try {
				conn = FabricaConexao.getConexao();
				PreparedStatement pstm;
				pstm = conn.prepareStatement(INSERT);
				pstm.setString(1, time.getNome());
				pstm.execute();
				JOptionPane.showMessageDialog(null, "Time cadastrado com sucesso");
                                FabricaConexao.fecharConexao();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao inserir time no banco de"
						+ "dados " + e.getMessage());
			}
		} else {
			System.out.println("O time enviado por parâmetro está vazio");
		}
	}

	public void update(Time time) {
		if (time != null) {
			Connection conn;
			try {
                                conn = FabricaConexao.getConexao();
				PreparedStatement pstm;
				pstm = conn.prepareStatement(UPDATE);
				pstm.setString(1, time.getNome());
				pstm.setInt(2, time.getId());
				pstm.execute();
				JOptionPane.showMessageDialog(null, "Time alterado com sucesso");
				//FabricaConexao.fechaConexao(conn);
                                FabricaConexao.fecharConexao();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar time no banco de"
						+ "dados " + e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "O time enviado por parâmetro está vazio");
		}
	}

	public void remover(int id) {
		Connection conn = null;
		try {
			conn = FabricaConexao.getConexao();
			PreparedStatement pstm;
			pstm = conn.prepareStatement(DELETE);
			pstm.setInt(1, id);
			pstm.execute();
//			FabricaConexao.fechaConexao(conn, pstm);
                        FabricaConexao.fecharConexao();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir time do banco de"
					+ "dados " + e.getMessage());
		}
	}

	public List<Time> getTimes() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Time> times = new ArrayList<Time>();
		try {
			conn = FabricaConexao.getConexao();
			pstm = conn.prepareStatement(LIST);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Time time = new Time();
				time.setId(rs.getInt("TIME_ID"));
				time.setNome(rs.getString("TIME_NOME"));
				times.add(time);
			}
			//FabricaConexao.fechaConexao(conn, pstm, rs);
                        FabricaConexao.fecharConexao();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar times" + e.getMessage());
		}
		return times;
	}

	public Time getTimeById(int id) {
            Connection conn = null;
            PreparedStatement pstm = null;
            ResultSet rs = null;
            Time time = new Time();
            try {
                    conn = FabricaConexao.getConexao();
                    pstm = conn.prepareStatement(LISTBYID);
                    pstm.setInt(1, id);
                    rs = pstm.executeQuery();
                    rs.first();
                    time.setId(rs.getInt("TIME_ID"));
                    time.setNome(rs.getString("TIME_NOME"));
                    FabricaConexao.fecharConexao();
            } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao listar times da tabela" + e.getMessage());
            }
            return time;
	}
        
        public Time getTimeByName(String nome){
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Time time = new Time();
		try {
			conn = FabricaConexao.getConexao();
			pstm = conn.prepareStatement(LISTBYNAME);
			pstm.setString(1, nome);
			rs = pstm.executeQuery();
			while (rs.next()) {
			time.setId(rs.getInt("TIME_ID"));
			time.setNome(rs.getString("TIME_NOME"));
                        }
			//FabricaConexao.fechaConexao(conn, pstm, rs);
                        FabricaConexao.fecharConexao();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar nomes dos times" + e.getMessage());
		}
            return time;
        }

        
	public ResultSet getResultSetByName(String nome) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Time time = new Time();
		try {
			conn = FabricaConexao.getConexao();
			pstm = conn.prepareStatement(LISTBYNAME);
			pstm.setString(1, nome);
			rs = pstm.executeQuery();
			while (rs.next()) {
				time.setId(rs.getInt("TIME_ID"));
				time.setNome(rs.getString("TIME_NOME"));
			}
			//FabricaConexao.fechaConexao(conn, pstm, rs);
                        FabricaConexao.fecharConexao();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar times" + e.getMessage());
		}
		return rs;
	}        
        
        
        
        public ResultSet getResultSet(){
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		try {
			conn = FabricaConexao.getConexao();
			pstm = conn.prepareStatement(LIST);
			rs = pstm.executeQuery();
                        FabricaConexao.fecharConexao();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar times" + e.getMessage());
		}
			return rs;
        }
    
}
