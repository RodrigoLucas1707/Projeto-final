package org.libertas.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.VendaDao;


public class ExcluirVenda implements Modelo {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
	
		int idvenda = Integer.parseInt(request.getParameter("idvenda"));
		VendaDao vdao = new VendaDao();
		vdao.excluir(idvenda);
		
		return "Venda excluida com sucesso!";
	}

}
