package org.libertas.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.CidadeDao;
import org.libertas.dao.GrupoDao;
import org.libertas.dao.PessoaDao;
import org.libertas.dao.ProdutoDao;
import org.libertas.pojo.Cidade;
import org.libertas.pojo.Grupo;
import org.libertas.pojo.Pessoa;
import org.libertas.pojo.Produto;


public class SalvarProduto implements Modelo {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			if (request.getParameter("idproduto")==null) {
				return "idproduto obrigatório!";
			}
			if (request.getParameter("descricao")==null) {
				return "Descrição obrigatório!";
			}
			if (request.getParameter("descricao").equals("")) {
				return "Descrição obrigatório!";
			}
			if (request.getParameter("grupo")==null) {
				return "Grupo obrigatório!";
			}
			if (request.getParameter("grupo").equals("")) {
				return "Grupo obrigatório!";
			}
			if (request.getParameter("preco")==null) {
				return "Grupo obrigatório!";
			}
			if (request.getParameter("preco").equals("")) {
				return "Grupo obrigatório!";
			}
			
			Produto p = new Produto();
			p.setIdproduto(Integer.parseInt(request.getParameter("idproduto")));
			p.setDescricao(request.getParameter("descricao"));
			
			GrupoDao gdao = new GrupoDao();
			Grupo g = gdao.consultar(Integer.parseInt(request.getParameter("grupo")));
			
			p.setPreco(Double.parseDouble(request.getParameter("preco")));
			p.setGrupo(g);
			
			ProdutoDao pdao = new ProdutoDao();
			pdao.salvar(p);
			
			return "Sucesso ao salvar dados!";
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
