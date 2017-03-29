package service;

import java.util.ArrayList;

import dao.EmpresaDAO;
import model.Empresa;

public class EmpresaService {
	EmpresaDAO dao;
	
	public EmpresaService() {
		dao = new EmpresaDAO();
	}
	
	public void incluir(Empresa em) {
		dao.incluir(em);
	}
	
	public void atualizar(Empresa em, String cnpj) {
		dao.atualizar(em, cnpj);
	}
	
	public void excluir(String cnpj) {
		dao.excluir(cnpj);
	}
	
	public Empresa carregar(String cnpj) {
		return dao.carregar(cnpj);
	}
	
	public ArrayList<Empresa> carregarTudo() {
		return dao.carregarTudo();
	}
}
