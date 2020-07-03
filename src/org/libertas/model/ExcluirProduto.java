package org.libertas.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.ProdutoDao;


public class ExcluirProduto implements Modelo {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
	
		int idproduto = Integer.parseInt(request.getParameter("idproduto"));
		ProdutoDao pdao = new ProdutoDao();
		pdao.excluir(idproduto);
		
		return "Produto excluida com sucesso!";
	}

}
