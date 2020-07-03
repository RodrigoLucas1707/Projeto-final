package org.libertas.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.dao.VendaDao;
import org.libertas.pojo.RelatorioCidade;
import org.libertas.pojo.Venda;

import com.google.gson.Gson;

public class ListarVendasPorCidade implements Modelo {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		try {
			VendaDao vdao = new VendaDao();
			ArrayList<Venda> lista = new ArrayList<Venda>();
			lista.addAll(vdao.listar());
			ArrayList<RelatorioCidade> relatorio = new ArrayList<RelatorioCidade>();
			Gson gson = new Gson();
			
			for (Venda itens : lista) {
				boolean verifica = false;
				for (RelatorioCidade relatorioCidade : relatorio) {
					if(itens.getPessoa().getCidade().getIdcidade()==relatorioCidade.getIdcidade()) {
						double valortotal = relatorioCidade.getValortotal();
						relatorioCidade.setValortotal(valortotal+itens.getValortotal());
						int quantidade = relatorioCidade.getQuantidade();
						relatorioCidade.setQuantidade(quantidade+itens.getQuantidade());
						
						verifica = true;
						break;
					}
				}
				
				if(!verifica) {
					RelatorioCidade relatorioCidade = new RelatorioCidade();
					relatorioCidade.setIdcidade(itens.getPessoa().getCidade().getIdcidade());
					relatorioCidade.setCidade(itens.getPessoa().getCidade().getCidade());
					relatorioCidade.setQuantidade(itens.getQuantidade());
					relatorioCidade.setValortotal(itens.getValortotal());
					
					relatorio.add(relatorioCidade);
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
