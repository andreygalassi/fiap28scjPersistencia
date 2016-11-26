package br.com.fiap.dao.entity;

import java.util.Date;

public class Pedidos {

	private int id;
	private int idCliente;
	private Date data;
	private String descricao;
	private double valor;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return String.format("Pedidos [id=%s, idCliente=%s, data=%s, descricao=%s, valor=%s]", id, idCliente, data,
				descricao, valor);
	}
	
	
}
