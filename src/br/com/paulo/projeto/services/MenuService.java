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
					+ "[1] Relatório na Tela\n"
					+ "[2] Relatório Impresso\n"
					+ "[3] Sair\n"
					+ "\nDigite uma opção: ");
		
		int opcao = sc.nextInt();
		
		switch(opcao) {
		
		case 1:
			SubMenuService.subMenuTela();
			break;
		case 2:
			SubMenuService.subMenuImpresso();
			break;
		case 3:
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
