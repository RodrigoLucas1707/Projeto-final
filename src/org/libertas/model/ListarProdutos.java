package org.libertas.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.ProdutoDao;
import org.libertas.pojo.Produto;

import com.google.gson.Gson;

public class ListarProdutos implements Modelo {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		try {
			ProdutoDao pdao = new ProdutoDao();
			List<Produto> lista = pdao.listar();
			Gson gson = new Gson();
			String json = gson.toJson(lista);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
