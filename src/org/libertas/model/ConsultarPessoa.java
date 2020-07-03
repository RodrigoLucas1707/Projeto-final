package org.libertas.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.PessoaDao;
import org.libertas.pojo.Pessoa;

import com.google.gson.Gson;

public class ConsultarPessoa implements Modelo {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		int idpessoa = Integer.parseInt(request.getParameter("idpessoa"));
		
		PessoaDao pdao = new PessoaDao();
		Pessoa p = pdao.consultar(idpessoa);
		Gson gson = new Gson();
		
		return gson.toJson(p);
	}

}
