package br.com.paulo.projeto;

import java.io.IOException;
import java.util.Scanner;

import br.com.paulo.projeto.io.RelatorioIO;

public class ProjetoApplication {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		
		RelatorioIO.leitor("banco");
		
		sc.close();
	}

}
