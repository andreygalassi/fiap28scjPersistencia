package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chamado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	private Long id;
	private String descricao;
	private Set<Itens> itens;
	private Date dtSolicitacao;
	private Date dtConclussao;
	private EnumStatus status;
	private Equipe equipe;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Set<Itens> getItens() {
		return itens;
	}
	public void setItens(Set<Itens> itens) {
		this.itens = itens;
	}
	public Date getDtSolicitacao() {
		return dtSolicitacao;
	}
	public void setDtSolicitacao(Date dtSolicitacao) {
		this.dtSolicitacao = dtSolicitacao;
	}
	public Date getDtConclussao() {
		return dtConclussao;
	}
	public void setDtConclussao(Date dtConclussao) {
		this.dtConclussao = dtConclussao;
	}
	public EnumStatus getStatus() {
		return status;
	}
	public void setStatus(EnumStatus status) {
		this.status = status;
	}
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
}
