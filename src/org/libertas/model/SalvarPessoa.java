package org.libertas.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.CidadeDao;
import org.libertas.dao.PessoaDao;
import org.libertas.pojo.Cidade;
import org.libertas.pojo.Pessoa;


public class SalvarPessoa implements Modelo {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			if (request.getParameter("idpessoa")==null) {
				return "idpessoa obrigatório!";
			}
			if (request.getParameter("nome")==null) {
				return "Nome obrigatório!";
			}
			if (request.getParameter("nome").equals("")) {
				return "Nome obrigatório!";
			}
			
			Pessoa p = new Pessoa();
			p.setNome(request.getParameter("nome"));
			p.setIdpessoa(Integer.parseInt(request.getParameter("idpessoa")));
			
			CidadeDao cdao = new CidadeDao();
			Cidade c = cdao.consultar(Integer.parseInt(request.getParameter("cidade")));
			
			p.setTelefone(request.getParameter("telefone"));
			p.setLogradouro(request.getParameter("logradouro"));
			p.setNumero(request.getParameter("numero"));
			p.setBairro(request.getParameter("bairro"));
			p.setCidade(c);
			
			PessoaDao pdao = new PessoaDao();
			pdao.salvar(p);
			if (p.getIdpessoa()>0) {
				return "Registro alterado com sucesso!";
			} else {
				return "Registro inserido com sucesso!";
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
