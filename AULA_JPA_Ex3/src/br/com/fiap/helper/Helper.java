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
//			em.close();
		}
	}
	public void salvar(List<Paciente> pacientes) throws Exception {
		try {
			em.getTransaction().begin();
			for (Paciente paciente : pacientes) {
				em.persist(paciente);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
//			em.close();
		}
	}
	//JPQL: Usando Query
//	@SuppressWarnings("unchecked")
//	public List<Paciente> listarPacientes(){
//		Query query = em.createQuery("from Paciente");
//		return query.getResultList();
//	}
	@SuppressWarnings("unchecked")
	public List<Paciente> buscarPacientePorNome(String nome){
		Query query = em.createQuery("select p from Paciente p where nome like :nome");
				query.setParameter("nome", "%"+nome+"%");
				return query.getResultList();
	}
	public Paciente buscarPacientePorCpf(String cpf){
		Query query = em.createQuery("select p from Paciente p where cpf = :cpf");
				query.setParameter("cpf", cpf.replace(".", "").replace("-",""));
				return (Paciente) query.getSingleResult();
	}
	//JPQL: usando NamedQuery
	@SuppressWarnings("unchecked")
	public List<Paciente> listarTodos(){
		Query query = em.createNamedQuery("Paciente.findAll");
		return query.getResultList();
	}
}