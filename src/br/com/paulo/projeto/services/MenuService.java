package br.com.paulo.projeto.services;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.paulo.projeto.controllers.DenunciaController;
import br.com.paulo.projeto.controllers.UsuarioController;
import br.com.paulo.util.Util;

public class MenuService {
	
	static DenunciaController denunciaController = new DenunciaController();
	static UsuarioController usuarioController = new UsuarioController();	
	static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);
	
	public static void menu() throws IOException {
		
		Util.customizer();
		logger.log(Level.INFO, () -> ""
					+ "Menu interativo:\n"
					+ "[1]\tListar nomes dos Usuarios\n"
					+ "[2]\tListar Denuncias\n"
					+ "[3]\tListar as Denúncias e seus Usuários\n"
					+ "[4]\tCadastrar Denuncia\n"
					+ "[0]\tSair"
					+ "\n\nDigite uma opção:");

		int opcao = sc.nextInt();
		
		switch(opcao) {
		
		case 1:
			Util.customizer();
			logger.log(Level.INFO, "\nListar nomes dos Usuários");
			usuarioController.listarNomes();
			logger.log(Level.INFO, "\n\n");
			menu();
		case 2:
			Util.customizer();
			logger.log(Level.INFO, "\nListar denúncias");
			denunciaController.listarDenuncias();
			logger.log(Level.INFO, "\n\n");
			menu();
		case 3:
			Util.customizer();
			logger.log(Level.INFO, "\nListar denúncias");
			denunciaController.listarDenunciaUsuario();
			logger.log(Level.INFO, "\n\n");
			menu();
		case 4:
			
		case 0:
			Util.customizer();
			logger.log(Level.INFO, "Até a próxima!");
			break;
		default:
			Util.customizer();
			logger.log(Level.WARNING, "Opção inválida!");
			menu();
			break;
		}
	}
}
