package org.libertas.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.CidadeDao;
import org.libertas.dao.PessoaDao;
import org.libertas.dao.ProdutoDao;
import org.libertas.dao.VendaDao;
import org.libertas.pojo.Cidade;
import org.libertas.pojo.Pessoa;
import org.libertas.pojo.Produto;
import org.libertas.pojo.Venda;


public class SalvarVenda implements Modelo {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			if (request.getParameter("idvenda")==null) {
				return "idvenda obrigatório!";
			}
			if (request.getParameter("pessoa")==null) {
				return "Cliente obrigatório!";
			}
			if (request.getParameter("pessoa").equals("")) {
				return "Cliente obrigatório!";
			}
			if (request.getParameter("produto")==null) {
				return "Produto obrigatório!";
			}
			if (request.getParameter("produto").equals("")) {
				return "Produto obrigatório!";
			}
			if (request.getParameter("data")==null) {
				return "Data obrigatório!";
			}
			if (request.getParameter("data").equals("")) {
				return "Data obrigatório!";
			}
			if (request.getParameter("quantidade")==null) {
				return "Quantidade obrigatório!";
			}
			if (request.getParameter("quantidade").equals("")) {
				return "Quantidade obrigatório!";
			}
			if (request.getParameter("valorunitario")==null) {
				return "Valor unitário obrigatório!";
			}
			if (request.getParameter("valorunitario").equals("")) {
				return "Valor unitário obrigatório!";
			}
			
			Venda v = new Venda();
			
			PessoaDao pdao = new PessoaDao();
			Pessoa p = pdao.consultar(Integer.parseInt(request.getParameter("pessoa")));
			v.setPessoa(p);
			
			ProdutoDao ptdao = new ProdutoDao();
			Produto pt = ptdao.consultar(Integer.parseInt(request.getParameter("produto")));
			v.setProduto(pt);
			
			v.setData(request.getParameter("data"));
			v.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
			v.setValorunitario(Double.parseDouble(request.getParameter("valorunitario")));
			v.setValortotal(Double.parseDouble(request.getParameter("valortotal")));
			
			VendaDao vdao = new VendaDao();
			vdao.salvar(v);
			
			return "Sucesso ao salvar dados!";
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
