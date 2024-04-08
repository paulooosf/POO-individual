package br.com.paulo.projeto.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;

import br.com.paulo.util.Util;

public class RelatorioIO {

	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";

	public static void leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + path));
		String linha = "";
		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				Util.setupLogger().log(Level.INFO, linha::toString);
			} else {
				break;
			}
		}
		buffRead.close();
	}
	public static void escritor(String path) throws IOException {
		Scanner sc = new Scanner(System.in);
		Util.setupLogger().log(Level.INFO, () -> "Escreva o nome do arquivo: ");
		String nome = sc.next();

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + path));
		String linha = "";

		Util.setupLogger().log(Level.INFO, () -> "Escreva algo: ");
		linha = sc.nextLine();
		buffWrite.append(linha + "\n");
		buffWrite.close();
		sc.close();
	}
}
