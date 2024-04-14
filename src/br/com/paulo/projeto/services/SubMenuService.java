package br.com.paulo.projeto.services;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.paulo.projeto.controllers.DenunciaController;
import br.com.paulo.projeto.controllers.UsuarioController;
import br.com.paulo.util.Util;

public class SubMenuService {

	static DenunciaController denunciaController = new DenunciaController();
	static UsuarioController usuarioController = new UsuarioController();
	static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);

	public static void subMenuTela() throws IOException {

		Util.customizer();
		logger.log(Level.INFO, () -> "" 
					+ "Opções de relatórios na tela:\n" 
					+ "[1] Listar Usuários cadastrados\n"
					+ "[2] Listar Denúncias disponíveis\n"
					+ "[3] Listar Denúncias por Usuários\n"
					+ "[4] Voltar\n" 
					+ "\nDigite uma opção:");

		int subOpcao = MenuService.sc.nextInt();

		switch (subOpcao) {

		case 1:
			Util.customizer();
			logger.log(Level.INFO, "\nListando usuários cadastrados:");
			UsuarioController.listarUsuarios();
			subMenuTela();
			break;
		case 2:
			Util.customizer();
			logger.log(Level.INFO, "\nListando denúncias:");
			DenunciaController.listarDenuncias();
			subMenuTela();
			break;
		case 3:
			Util.customizer();
			logger.log(Level.INFO, "\nListando denúncias por usuários:\n");
			DenunciaController.listarDenunciasUsuarios();
			subMenuTela();
			break;
		case 4:
			MenuService.menu();
			break;
		default:
			Util.customizer();
			logger.log(Level.WARNING, "Opção inválida!");
			subMenuTela();
			break;
		}
	}

	public static void subMenuImpresso() throws IOException {

		Util.customizer();
		logger.log(Level.INFO, () -> "" 
					+ "Opções de relatórios impressos:\n" 
					+ "[1] Relatório de Usuários cadastrados\n"
					+ "[2] Relatório de Denúncias disponíveis\n" 
					+ "[3] Relatório de Denúncias por Usuários\n"
					+ "[4] Voltar\n" 
					+ "\nDigite uma opção:");

		int subOpcao = MenuService.sc.nextInt();

		switch (subOpcao) {

		case 1:
			Util.customizer();
			UsuarioController.relatorioUsuarios();
			logger.log(Level.INFO, "\nRelatório gerado no arquivo /temp/lista-usuarios.txt\n");
			subMenuImpresso();
			break;
		case 2:
			Util.customizer();
			DenunciaController.relatorioDenuncias();
			logger.log(Level.INFO, "\nRelatório gerado no arquivo /temp/lista-denuncias.txt\n");
			subMenuImpresso();
			break;
		case 3:
			Util.customizer();
			DenunciaController.relatorioDenunciaUsuario();
			logger.log(Level.INFO, "\nRelatório gerado no arquivo /temp/lista-denuncias-usuarios.txt\n");
			subMenuImpresso();
			break;
		case 4:
			MenuService.menu();
			break;
		default:
			Util.customizer();
			logger.log(Level.WARNING, "Opção inválida!");
			subMenuTela();
			break;
		}
	}
}
