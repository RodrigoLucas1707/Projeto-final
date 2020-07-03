package org.libertas.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.VendaDao;
import org.libertas.pojo.Venda;

import com.google.gson.Gson;

public class ListarVendas implements Modelo {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		try {
			VendaDao vdao = new VendaDao();
			List<Venda> lista = vdao.listar();
			Gson gson = new Gson();
			String json = gson.toJson(lista);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
