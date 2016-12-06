package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Equipe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	private Long id;

	@Column(name="RESPONSAVEL")
	private String responsavel;

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="equipe" )
	private Set<Chamado> chamados;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public Set<Chamado> getChamados() {
		return chamados;
	}
	public void setChamados(Set<Chamado> chamados) {
		this.chamados = chamados;
	}
	@Override
	public String toString() {
		return String.format("Equipe [id=%s, responsavel=%s, chamados=%s]", id, responsavel, chamados);
	}
}
