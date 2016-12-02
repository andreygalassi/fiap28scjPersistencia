package br.com.fiap.programa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class Teste {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaEX3");
		EntityManager em = emf.createEntityManager();
//		incluirFuncionario(em);
//		listarFuncionarios(em);
//		buscarFuncionario(em, "2000");
	}
//	@SuppressWarnings("unused")
//	private static void incluirFuncionario(EntityManager em){
//		Helper dao = new Helper(em);
//		Paciente paciente = new Paciente();
//		paciente.setMatricula("2000");
//		paciente.setNome("Alberto Santos");
//		Tarefa tarefa = new Tarefa();
//		tarefa.setDescricao("Teste Unitário");
//		tarefa.setDuracao(100);
//		tarefa.getFuncionarios().add(paciente);
//		paciente.getTarefas().add(tarefa);
//		try {
//			dao.salvar(paciente);
//			System.out.println("Funcionario OK");
//		} catch (Exception e) {
//			System.out.println("ERRO ===>> " + e.getMessage());
//		}
//	}
//	@SuppressWarnings("unused")
//	private static void listarFuncionarios(EntityManager em){
//		Helper dao = new Helper(em);
//		List<Funcionario> funcionarios = dao.listarTodos();
//		for (Funcionario funcionario : funcionarios) {
//			System.out.println(funcionario.getMatricula() + ": " +
//					funcionario.getNome());
//		}
//		em.close();
//	}
//	@SuppressWarnings("unused")
//	private static void buscarFuncionario(EntityManager em, String matricula){
//		Helper dao = new Helper(em);
//		Funcionario f = dao.buscarFuncionario(matricula);
//		System.out.println(f.getMatricula() + ": " + f.getNome());
//	}
}