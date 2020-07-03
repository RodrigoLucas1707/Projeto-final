package org.libertas.teste;

import java.util.List;

import org.libertas.dao.CidadeDao;
import org.libertas.dao.GrupoDao;
import org.libertas.pojo.Cidade;
import org.libertas.pojo.Grupo;
import org.libertas.pojo.Produto;

public class MainTeste {
	public static void main(String[] args) {
		CidadeDao cdao = new CidadeDao();
		GrupoDao gdao = new GrupoDao();
		
		
		/*Cidade c = new Cidade();
		c.setCidade("São Sebastião do Paraíso");
		c.setEstado("MG");
		cdao.inserir(c);
		List<Cidade> lista = cdao.listar();
		for (Cidade c : lista) {
			System.out.println(c.getCidade());
		}*/
		
		Grupo g = new Grupo();
		g.setGrupo("Outros");
		gdao.inserir(g);
	
	}
}
