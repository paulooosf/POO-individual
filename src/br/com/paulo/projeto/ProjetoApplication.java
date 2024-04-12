package br.com.paulo.projeto;

import java.io.IOException;

import br.com.paulo.projeto.io.RelatorioIO;
import br.com.paulo.projeto.services.MenuService;

public class ProjetoApplication {
	
	public static void main(String[] args) throws IOException {
		RelatorioIO.leitor("banco");
		MenuService.menu();
	}

}
