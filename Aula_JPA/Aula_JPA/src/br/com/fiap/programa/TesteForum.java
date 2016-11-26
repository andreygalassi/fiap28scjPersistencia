package br.com.fiap.programa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Forum;
import br.com.fiap.entity.Usuario;
import br.com.fiap.helper.ForumHelper;

public class TesteForum {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Aula_JPA");
		
		EntityManager em = emf.createEntityManager();
		ForumHelper dao = new ForumHelper(em);
		
		Forum forum = new Forum();
		forum.setAssunto("JPA");
		forum.setDescricao("Java Persistence API");
		
		System.out.println(dao.salvar(forum));
		
		Usuario u1 = new Usuario();
		u1.setNome("Joaquim");
		u1.setEmail("joaquim@fiap.com.br");
		u1.setForum(forum);
		System.out.println(dao.adicionarUsuario(forum.getId(), u1));

		Usuario u2 = new Usuario();
		u2.setNome("usuario2");
		u2.setEmail("usuario2@fiap.com.br");
		u2.setForum(forum);
		System.out.println(dao.adicionarUsuario(forum.getId(), u2));

		Usuario u3 = new Usuario();
		u3.setNome("usuario3");
		u3.setEmail("usuario3@fiap.com.br");
		u3.setForum(forum);
		System.out.println(dao.adicionarUsuario(forum.getId(), u3));
		
		System.out.println(dao.salvar(forum));
	}

}
