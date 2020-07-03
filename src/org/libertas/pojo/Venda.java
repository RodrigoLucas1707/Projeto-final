package org.libertas.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cad_vendas")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idvenda;
	
	@ManyToOne
	private Pessoa pessoa;
	
	@ManyToOne
	private Produto produto;
	
	@Column
	private String data;
	
	@Column
	private int quantidade;
	
	@Column
	private double valorunitario;
	
	@Column
	private double valortotal;

	public int getIdvenda() {
		return idvenda;
	}

	public void setIdvenda(int idvenda) {
		this.idvenda = idvenda;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorunitario() {
		return valorunitario;
	}

	public void setValorunitario(double valorunitario) {
		this.valorunitario = valorunitario;
	}

	public double getValortotal() {
		return valortotal;
	}

	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}
	
}
