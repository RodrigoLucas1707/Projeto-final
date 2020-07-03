package org.libertas.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.VendaDao;
import org.libertas.pojo.RelatorioGrupo;
import org.libertas.pojo.Venda;

import com.google.gson.Gson;

public class ListarVendasPorGrupo implements Modelo {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		try {
			VendaDao vdao = new VendaDao();
			ArrayList<Venda> lista = new ArrayList<Venda>();
			lista.addAll(vdao.listar());
			ArrayList<RelatorioGrupo> relatorio = new ArrayList<RelatorioGrupo>();
			Gson gson = new Gson();
			
			for (Venda itens : lista) {
				boolean verifica = false;
				for (RelatorioGrupo relatorioGrupo : relatorio) {
					if(itens.getProduto().getGrupo().getIdgrupo()==relatorioGrupo.getIdgrupo()) {
						double valortotal = relatorioGrupo.getValortotal();
						relatorioGrupo.setValortotal(valortotal+itens.getValortotal());
						int quantidade = relatorioGrupo.getQuantidade();
						relatorioGrupo.setQuantidade(quantidade+itens.getQuantidade());
						
						verifica = true;
						break;
					}
				}
				
				if(!verifica) {
					RelatorioGrupo relatorioGrupo = new RelatorioGrupo();
					relatorioGrupo.setIdgrupo(itens.getProduto().getGrupo().getIdgrupo());
					relatorioGrupo.setGrupo(itens.getProduto().getGrupo().getGrupo());
					relatorioGrupo.setQuantidade(itens.getQuantidade());
					relatorioGrupo.setValortotal(itens.getValortotal());
					
					relatorio.add(relatorioGrupo);
				}
			}
			
			
			
			String json = gson.toJson(relatorio);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
