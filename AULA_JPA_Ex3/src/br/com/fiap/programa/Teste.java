package br.com.fiap.programa;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Agenda;
import br.com.fiap.entity.MatMed;
import br.com.fiap.entity.Paciente;
import br.com.fiap.entity.Procedimento;
import br.com.fiap.helper.Helper;
public class Teste {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaEX3");
		EntityManager em = emf.createEntityManager();
		try {
			System.out.println("====INCLUINDO PACIENTES====");
			incluirPaciente(em);
		} catch (ParseException e) {
			System.out.println("Erro ao converter alguma data");
		}
		System.out.println("====LISTANDO PACIENTES====");
		listarPacientes(em);
		System.out.println("====BUSCANDO PACIENTES COM 's' NO NOME====");
		buscarPacientePorNome(em, "s");
		System.out.println("====BUSCANDO PACIENTE PELO CPF 333.333.333-33====");
		buscarPacientePorCpf(em, "333.333.333-33");
		em.close();
		return;
	}
	private static void incluirPaciente(EntityManager em) throws ParseException{
		SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfH = new SimpleDateFormat("hh:mm");
		Helper dao = new Helper(em);
		Paciente paciente1 = new Paciente("111.111.111-11","Andre","01/01/2000");
		Paciente paciente2 = new Paciente("222.222.222-22","Carlos","02/01/2001");
		Paciente paciente3 = new Paciente("333.333.333-33","Larissa","03/01/2002");
		
		Agenda agenda1 = new Agenda();
		Agenda agenda2 = new Agenda();
		agenda1.setDescricao("atendimento1");
		agenda1.setData(sdfD.parse("01/12/2016"));
		agenda1.setHora(sdfH.parse("10:10"));
		agenda1.addPaciente(paciente1);
		agenda1.addPaciente(paciente2);

		agenda2.setDescricao("atendimento2");
		agenda2.setData(sdfD.parse("04/12/2016"));
		agenda2.setHora(sdfH.parse("11:11"));
		agenda2.addPaciente(paciente3);
		
		Procedimento procedimento1 = new Procedimento("Proc1",10.0,paciente1);
		Procedimento procedimento2 = new Procedimento("Proc2",20.0,paciente1);
		Procedimento procedimento3 = new Procedimento("Proc3",33.0,paciente2);
		Procedimento procedimento4 = new Procedimento("Proc4",40.0,paciente3);
		Procedimento procedimento5 = new Procedimento("Proc5",9.0,paciente3);
		
		MatMed matMed1 = new MatMed("MatMed1",5.00,"Fab1",paciente1);
		MatMed matMed2 = new MatMed("MatMed2",10.00,"Fab2",paciente1);
		MatMed matMed3 = new MatMed("MatMed3",58.00,"Fab3",paciente2);
		MatMed matMed4 = new MatMed("MatMed4",10.33,"Fab4",paciente2);
		MatMed matMed5 = new MatMed("MatMed5",15.00,"Fab5",paciente2);
		MatMed matMed6 = new MatMed("MatMed6",22.00,"Fab6",paciente3);
		
		paciente1.addAgenda(agenda1);
		paciente2.addAgenda(agenda1);
		paciente3.addAgenda(agenda2);
		
		paciente1.addProcedimento(procedimento1);
		paciente1.addProcedimento(procedimento2);
		paciente2.addProcedimento(procedimento3);
		paciente3.addProcedimento(procedimento4);
		paciente3.addProcedimento(procedimento5);
		
		paciente1.addMatMed(matMed1);
		paciente1.addMatMed(matMed2);
		paciente2.addMatMed(matMed3);
		paciente2.addMatMed(matMed4);
		paciente2.addMatMed(matMed5);
		paciente3.addMatMed(matMed6);
		
		try {
//			List<Paciente> pacientes = new ArrayList<>();
//			pacientes.add(paciente1);
//			pacientes.add(paciente2);
//			pacientes.add(paciente3);
			dao.salvar(paciente1);
			dao.salvar(paciente2);
			dao.salvar(paciente3);
			System.out.println("Paciente OK");
		} catch (Exception e) {
			System.out.println("ERRO ===>> " + e.getMessage());
		}
	}
	private static void listarPacientes(EntityManager em){
		Helper dao = new Helper(em);
		List<Paciente> pacientes = dao.listarTodos();
		for (Paciente paciente : pacientes) {
			System.out.println(paciente);
		}
	}
	private static void buscarPacientePorNome(EntityManager em, String nome){
		Helper dao = new Helper(em);
		List<Paciente> lista = dao.buscarPacientePorNome(nome);
		System.out.println(lista);
	}
	private static void buscarPacientePorCpf(EntityManager em, String cpf){
		Helper dao = new Helper(em);
		Paciente p = dao.buscarPacientePorCpf(cpf);
		System.out.println(p);
	}
}