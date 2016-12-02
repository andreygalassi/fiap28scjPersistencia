package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="paciente")
@NamedQuery(name="Paciente.findAll", query="select p from Paciente p")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="ID", unique=true, nullable=false)
//	private Integer id;
	@Id
	@Column(name="CPF", length=11)
	private String cpf;

	@Column(name="NOME", length=45)
	private String nome;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="DATANASC")
	private Date dtNacimento;

	@Column(name="TELEFONE", length=20)
	private String tel;

	@ManyToMany(fetch=FetchType.LAZY, mappedBy="pacientes")
	private Set<Agenda> agendas = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="paciente")
	private Set<Procedimento> procedimentos = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="paciente")
	private Set<MatMed> matMeds = new HashSet<>();

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtNacimento() {
		return dtNacimento;
	}

	public void setDtNacimento(Date dtNacimento) {
		this.dtNacimento = dtNacimento;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Set<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(Set<Agenda> agendas) {
		this.agendas = agendas;
	}

	public Set<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(Set<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public Set<MatMed> getMatMeds() {
		return matMeds;
	}

	public void setMatMeds(Set<MatMed> matMeds) {
		this.matMeds = matMeds;
	}
}
