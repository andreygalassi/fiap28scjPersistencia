package br.com.fiap.Programa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.entity.Chamado;
import br.com.fiap.entity.Equipe;
import br.com.fiap.entity.Itens;
import br.com.fiap.helper.ChamadoHelper;

public class EquipeMain {

	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory(ChamadoHelper.DS);
//		EntityManager em = emf.createEntityManager();
		
		Object[] opcoes = {"INCLUIR", "LISTAR", "SAIR"};
		int opcao = JOptionPane.showOptionDialog(null, 
				"Escolha a opção!", 
				null, 
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.DEFAULT_OPTION, 
				null, 
				opcoes, opcoes[0]);
		
		switch (opcao) {
		case 0://incluir
			incluir();
			break;
		case 1://listar
			
			break;
		case 2://sair
			
			break;

		default:
			break;
		}
		
		
//		try {
//			incluirPaciente(em);
//		} catch (ParseException e) {
//			System.out.println("Erro ao converter alguma data");
//		}
//		System.out.println("====LISTANDO PACIENTES====");
//		listarPacientes(em);
//		System.out.println("====BUSCANDO PACIENTES COM 's' NO NOME====");
//		buscarPacientePorNome(em, "s");
//		System.out.println("====BUSCANDO PACIENTE PELO CPF 333.333.333-33====");
//		buscarPacientePorCpf(em, "333.333.333-33");
//		em.close();
//		return;
	}

	private static void incluir() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_31680_31489");
		EntityManager em = emf.createEntityManager();
		
		Equipe equipe = new Equipe();
		
		String responsavel = JOptionPane.showInputDialog("Digite o nome do responsável");
		
		equipe.setResponsavel(responsavel);
		
		String descricaoChamado="";
		while (true) {
			descricaoChamado = JOptionPane.showInputDialog("Digite a descrição do chamado");
			if (descricaoChamado==null) break;
			Chamado chamado = new Chamado(descricaoChamado);
			chamado.setEquipe(equipe);
			String descricaoItem="";
			while (true) {
				descricaoItem = JOptionPane.showInputDialog("Digite a descrição do item do chamado");
				if (descricaoItem==null) break;
				Itens item = new Itens(descricaoItem,chamado);
				chamado.addItem(item);
			}
			equipe.addChamado(chamado);
		}
		ChamadoHelper helper = new ChamadoHelper(em);
		try {
			helper.salvar(equipe);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		System.out.println(equipe);
	}
}
