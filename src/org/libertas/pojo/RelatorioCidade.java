package org.libertas.pojo;

public class RelatorioCidade {
	private int idcidade;
	private String cidade;
	private int quantidade;
	private double valortotal;

	public RelatorioCidade() {
		this.idcidade = 0;
		this.cidade = "";
		this.quantidade = 0;
		this.valortotal = 0.0;
	}

	public int getIdcidade() {
		return idcidade;
	}

	public void setIdcidade(int idcidade) {
		this.idcidade = idcidade;
	}

	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
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
