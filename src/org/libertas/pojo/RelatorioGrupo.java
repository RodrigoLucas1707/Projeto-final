package org.libertas.pojo;

public class RelatorioGrupo {
	private int idgrupo;
	private String grupo;
	private int quantidade;
	private double valortotal;

	public RelatorioGrupo() {
		this.idgrupo = 0;
		this.grupo = "";
		this.quantidade = 0;
		this.valortotal = 0.0;
	}

	public int getIdgrupo() {
		return idgrupo;
	}

	public void setIdgrupo(int idgrupo) {
		this.idgrupo = idgrupo;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValortotal() {
		return valortotal;
	}

	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}
}
