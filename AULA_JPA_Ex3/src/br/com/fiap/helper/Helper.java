package br.com.fiap.helper;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.entity.Paciente;
public class Helper {
	private EntityManager em;
	public Helper(EntityManager em){
		this.em = em;
	}
	public void salvar(Paciente paciente) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(paciente);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
	}
	//JPQL: Usando Query
	@SuppressWarnings("unchecked")
	public List<Paciente> listarFuncionarios(){
		Query query = em.createQuery("from Paciente");
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Paciente> buscarFuncionario(String nome){
		Query query = em.createQuery("select p from Paciente p where nome like :nome");
				query.setParameter("nome", "%"+nome+"%");
//				Paciente p = (Paciente)query.getSingleResult();
				return query.getResultList();
	}
	//JPQL: usando NamedQuery
	@SuppressWarnings("unchecked")
	public List<Paciente> listarTodos(){
		Query query = em.createNamedQuery("Paciente.findAll");
		return query.getResultList();
	}
}