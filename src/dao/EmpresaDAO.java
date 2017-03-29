package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Empresa;
import model.Horario;

public class EmpresaDAO {
	
	// Incluir uma nova empresa
	public void incluir(Empresa em) {
		String sqlInsert = "INSERT INTO empresa (rsocial, cnpj, temp, conjunto, horaF, horaA) VALUES (?, ?, ?, ?, ?, ?)";
		
		try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, em.getRazaoSocial());
			stm.setString(2, em.getCnpj());
			stm.setString(3, em.getTemperatura());
			stm.setInt(4, em.getConjunto());
			stm.setString(5, em.getHoraFuncionamento().toString());
			stm.setString(6, em.getHoraArCondicionado().toString());
		
			stm.execute();
			
			System.out.println("Empresa salva com sucesso!");
		} catch(SQLException e) {
			System.out.println("Erro ao tentar salvar a empresa!");
			e.printStackTrace();
		}
	}
	
	// Atualizar uma empresa
	public void atualizar(Empresa em, String cnpj) {
		String sqlUpdate = "UPDATE empresa SET rsocial=?, cnpj=?, temp=?, conjunto=?, horaF=?, horaA=? WHERE cnpj=?";
		
		if(em != null) {
			try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setString(1, em.getRazaoSocial());
				stm.setString(2, em.getCnpj());
				stm.setString(3, em.getTemperatura());
				stm.setInt(4, em.getConjunto());
				stm.setString(5, em.getHoraFuncionamento().toString());
				stm.setString(6, em.getHoraArCondicionado().toString());
				stm.setString(7, cnpj);
				
				stm.execute();
				
				System.out.println("Empresa atualizada com sucesso!");
			} catch(SQLException e) {
				System.out.println("Erro ao tentar atualizar a empresa!");
				e.printStackTrace();
			}
		}
	}
	
	// Excluir um empresa
	public void excluir(String cnpj) {
		String sqlDelete = "DELETE FROM empresa WHERE cnpj=?";
		
		try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setString(1, cnpj);
			
			stm.execute();
			
			System.out.println("Empresa removida com sucesso!");
		} catch(SQLException e) {
			System.out.println("Erro ao tentar remover a empresa!");
			e.printStackTrace();
		}
	}
	
	// Carregar uma empresa
	public Empresa carregar(String cnpj) {
		Empresa em = new Empresa();
		String sqlSelect = "SELECT * FROM empresa WHERE cnpj=?";
		
		try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, cnpj);
			
			try(ResultSet rs = stm.executeQuery();) {
				if(rs.next()) {
					em.setRazaoSocial(rs.getString("rsocial"));
					em.setCnpj(rs.getString("cnpj"));
					em.setTemperatura(rs.getString("temp"));
					em.setConjunto(rs.getInt("conjunto"));
					String[] h = rs.getString("horaF").split("-");
					Horario h1 = new Horario(h[0], h[1]);
					em.setHoraFuncionamento(h1);
					String[] ha = rs.getString("horaA").split("-");
					Horario h2 = new Horario(ha[0], ha[1]);
					em.setHoraArCondicionado(h2);
				}
			} catch(SQLException e) {
				System.out.println("Erro ao tentar carregar a empresa!");
				e.printStackTrace();
			}
		} catch(SQLException e) {
			System.out.println("Erro ao tentar carregar a empresa!");
			e.printStackTrace();
		}
		
		return em;
	}
	
	// Carregar todas as Empresas
	public ArrayList<Empresa> carregarTudo() {
		ArrayList<Empresa> ems = new ArrayList<>();
		String sqlSelect = "SELECT * FROM empresa";
		
		try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try(ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					Empresa em = new Empresa();
					
					em.setRazaoSocial(rs.getString("rsocial"));
					em.setCnpj(rs.getString("cnpj"));
					em.setTemperatura(rs.getString("temp"));
					em.setConjunto(rs.getInt("conjunto"));
					String[] h = rs.getString("horaF").split("-");
					Horario h1 = new Horario(h[0], h[1]);
					em.setHoraFuncionamento(h1);
					String[] ha = rs.getString("horaA").split("-");
					Horario h2 = new Horario(ha[0], ha[1]);
					em.setHoraArCondicionado(h2);
					
					ems.add(em);
				}
			} catch(SQLException e) {
				System.out.println("Erro ao tentar carregar empresas!");
				e.printStackTrace();
			}
		} catch(SQLException e) {
			System.out.println("Erro ao tentar carregar empresas!");
			e.printStackTrace();
		}
		
		return ems;
	}
}
