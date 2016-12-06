package br.com.fiap.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Chamado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	private Long id;
	
	@Column(name="DESCRICAO")
	private String descricao;

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="chamado" )
	private List<Itens> itens = new ArrayList<>();;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="DT_SOLICITACAO")
	private Date dtSolicitacao = new Date();
	
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS")
	private EnumStatus status = EnumStatus.ABERTO;

	@ManyToOne(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name="ID_EQUIPE")
	private Equipe equipe;
	
	public Chamado(){
		super();
	}
	public Chamado(String descricao) {
		this.descricao = descricao;
	}
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
	public List<Itens> getItens() {
		return itens;
	}
	public void setItens(List<Itens> itens) {
		this.itens = itens;
	}
	public Date getDtSolicitacao() {
		return dtSolicitacao;
	}
	public void setDtSolicitacao(Date dtSolicitacao) {
		this.dtSolicitacao = dtSolicitacao;
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
	@Override
	public String toString() {
		return String.format("Chamado [id=%s, descricao=%s, itens=%s, dtSolicitacao=%s, status=%s]",
				id, descricao, itens, dtSolicitacao, status);
	}
	public void addItem(Itens item) {
		if (itens==null) itens = new ArrayList<>();
		itens.add(item);
	}
	
}
