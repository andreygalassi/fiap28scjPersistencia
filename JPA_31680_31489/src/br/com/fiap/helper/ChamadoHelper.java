package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.entity.Chamado;
import br.com.fiap.entity.Equipe;

public class ChamadoHelper {
	
	public static final String DS = "JPA_31680_31489"; 
	
	private EntityManager em;
	public ChamadoHelper(EntityManager em){
		this.em = em;
	}

	public void salvar(Chamado chamado) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(chamado);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}
	public void salvar(Equipe equipe) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(equipe);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Chamado> listarTodos(){
		Query query = em.createNamedQuery("from Chamado");
		return query.getResultList();
	}

}
