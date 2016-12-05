package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="matmed")
public class MatMed implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	private Integer id;

	@Column(name="DESCRICAO", length=45)
	private String descricao;

	@Column(name="PRECO")
	private Double preco;

	@Column(name="FABRICANTE", length=45)
	private String fabricante;

//	@Column(name="CPFPAC", length=11)
	@ManyToOne(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name="CPFPAC")
	private Paciente paciente;

	@Deprecated
	public MatMed(){
		super();
	}
	
	@Override
	public String toString() {
		return String.format("MatMed [id=%s, descricao=%s, preco=%s, fabricante=%s]", id, descricao, preco, fabricante);
	}

	public MatMed(String descricao, Double preco, String fabricante, Paciente paciente) {
		super();
		this.descricao = descricao;
		this.preco = preco;
		this.fabricante = fabricante;
		this.paciente = paciente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Paciente getCpfPac() {
		return paciente;
	}

	public void setCpfPac(Paciente cpfPac) {
		this.paciente = cpfPac;
	}

}
