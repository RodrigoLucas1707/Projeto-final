package org.libertas.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.PessoaDao;


public class ExcluirPessoa implements Modelo {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
	
		int idpessoa = Integer.parseInt(request.getParameter("idpessoa"));
		PessoaDao pdao = new PessoaDao();
		pdao.excluir(idpessoa);
		
		return "pessoa excluida com sucesso!";
	}

}
