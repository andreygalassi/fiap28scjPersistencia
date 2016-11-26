package br.com.fiap.programa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;
import br.com.fiap.helper.ClientesHelper;

public class TesteClientes {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Aula_JPA_EX");
		
		EntityManager em = emf.createEntityManager();
		ClientesHelper dao = new ClientesHelper(em);
		
		Clientes cliente = new Clientes();
		cliente.setEmail("email1@fiap.com");
		cliente.setNome("Nome1");
		
		System.out.println(dao.salvar(cliente));
		
		Pedidos p1 = new Pedidos();
		p1.setCliente(cliente);
		p1.setData(new Date());
		p1.setDescricao("Produto1");
		p1.setValor(10.0);
		System.out.println(dao.adicionarPedido(cliente.getId(), p1));
		
		Pedidos p2 = new Pedidos();
		p2.setCliente(cliente);
		p2.setData(new Date());
		p2.setDescricao("Produto2");
		p2.setValor(20.0);
		System.out.println(dao.adicionarPedido(cliente.getId(), p2));
		
		System.out.println(dao.salvar(cliente));
	}

}
