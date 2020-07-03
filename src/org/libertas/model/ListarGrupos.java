package org.libertas.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.GrupoDao;
import org.libertas.pojo.Grupo;

import com.google.gson.Gson;

public class ListarGrupos implements Modelo {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		try {
			GrupoDao gdao = new GrupoDao();
			List<Grupo> grupos = gdao.listar();
			Gson gson = new Gson();
			String json = gson.toJson(grupos);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
