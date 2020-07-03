package org.libertas.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cad_cidades")
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idcidade;
	
	@Column
	private String cidade;
	
	@Column
	private String estado;
	
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	
}
