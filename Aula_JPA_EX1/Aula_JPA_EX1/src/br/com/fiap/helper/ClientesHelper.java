package br.com.fiap.helper;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;

public class ClientesHelper {
	private EntityManager em;
	
	public ClientesHelper(EntityManager em){
		this.em = em;
	}
	
	public String salvar(Clientes cliente){
		try{
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
			return "Forum salvo";
		}catch(Exception e){
			return e.getMessage();
		}
	}
	public String adicionarPedido(int idCliente, Pedidos pedido){
		try {
			Clientes cliente = em.find(Clientes.class, idCliente);
			pedido.setCliente(cliente);
			cliente.getPedidos().add(pedido);
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
			return "Inclusao realizada";
		} catch(Exception e){
			return e.getMessage();
		}
	}

}
