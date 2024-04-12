package br.com.paulo.projeto.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import br.com.paulo.projeto.entities.Denuncia;
import br.com.paulo.projeto.entities.Usuario;
import br.com.paulo.projeto.enums.TipoRegistro;
import br.com.paulo.util.Util;

public class RelatorioIO {

	static final String CAMINHO_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";
	private static Logger logger = Util.setupLogger();
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	static DateTimeFormatter dtfBr = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public static void leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(CAMINHO_BASICO + path + EXTENSAO));
		String linha = "";
		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				String[] dados = linha.split(";");
				if (dados[0].equalsIgnoreCase(TipoRegistro.DENUNCIA.name())) {
					Denuncia denuncia = new Denuncia(Integer.parseInt(dados[1]), LocalDate.parse(dados[2]), dados[3],
							Boolean.parseBoolean(dados[4]), Integer.parseInt(dados[5]));
					Denuncia.getMapaDenuncias().put(Integer.parseInt(dados[1]), denuncia);
					//logger.log(Level.INFO, denuncia::toString);
				} else if (dados[0].equalsIgnoreCase(TipoRegistro.USUARIO.name())) {
					Usuario usuario = new Usuario(Integer.parseInt(dados[1]), dados[2], dados[3], dados[4], dados[5],
							dados[6]);
					Usuario.getMapaUsuarios().put(Integer.parseInt(dados[1]), usuario);
					//logger.log(Level.INFO, usuario::toString);
				}
			} else {
				break;
			}
		}
		buffRead.close();
	}

	public static void relatorioListaUsuarios(List<Usuario> nomesUsuarios) throws IOException {
		String nome = "lista-nomes-usuarios";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(CAMINHO_BASICO + nome + EXTENSAO, true));

		buffWrite.append("-------RELATÓRIO: LISTA NOMES DE USUARIOS------\n\n");
		if (!nomesUsuarios.isEmpty()) {
			// Foreach para percorrer a lista de nomes dos pets de um em um
			for (Usuario usuario : nomesUsuarios) {
				buffWrite.append(usuario.getNome() + "\n");
			}
		}
		LocalDateTime ldt = LocalDateTime.now();
		buffWrite.append("\nData da requisição: " + dtfBr.format(ldt));
		buffWrite.append("\n\n---------FIM DA LISTA NOMES DE USUARIOS--------\n\n");
		buffWrite.close();
	}
	
	public static void relatorioListaDenuncia(List<Denuncia> denuncias) throws IOException {
		String nome = "lista-denuncias";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(CAMINHO_BASICO + nome + EXTENSAO, true));

		buffWrite.append("-------RELATÓRIO: LISTA DE DENUNCIAS------\n\n");
		if (!denuncias.isEmpty()) {
			// Foreach para percorrer a lista de nomes dos pets de um em um
			for (Denuncia denuncia : denuncias) {
				buffWrite.append("Detalhamento:" + denuncia.getDetalhamento() + "\nAnônimo: " + denuncia.getAnonimo() + "\n");
			}
		}
		LocalDateTime ldt = LocalDateTime.now();
		buffWrite.append("\nData da requisição: " + dtfBr.format(ldt));
		buffWrite.append("\n\n---------FIM DA LISTA DE DENUNCIAS--------\n\n");
		buffWrite.close();
	}
	
	public static void relatorioListaDenunciaUsuario(List<Denuncia> denuncias, List<Usuario> usuarios) throws IOException {
		String nome = "lista-denuncias-usuarios";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(CAMINHO_BASICO + nome + EXTENSAO, true));

		buffWrite.append("-------RELATÓRIO: LISTA DE DENUNCIAS POR USUARIOS------\n\n");
		if (!denuncias.isEmpty() && !usuarios.isEmpty()) {
			// Foreach para percorrer a lista de nomes dos pets de um em um
			for (Denuncia denuncia : denuncias) {
				for (Usuario usuario : usuarios) {
					if (denuncia.getFkUsu() == usuario.getId()) {
						buffWrite.append("Detalhamento:" + denuncia.getDetalhamento() + " Anônimo: " + denuncia.getAnonimo() + " Usuário:" + usuario.getNome() + "\n");						
					}
				}
			}
		}
		LocalDateTime ldt = LocalDateTime.now();
		buffWrite.append("\nData da requisição: " + dtfBr.format(ldt));
		buffWrite.append("\n\n---------FIM DA LISTA DE DENUNCIAS POR USUARIOS--------\n\n");
		buffWrite.close();
	}
}

/*
 * public static void escritor(String path) throws IOException {
 * 
 * Util.customizer(); logger.log(Level.INFO, () ->
 * "Escreva o nome do arquivo: "); String nome =
 * ProjetoApplication.sc.nextLine();
 * 
 * BufferedWriter buffWrite = new BufferedWriter(new FileWriter(CAMINHO_BASICO +
 * nome + EXTENSAO, true)); String linha = "";
 * 
 * Util.customizer(); logger.log(Level.INFO, () -> "Escreva algo: "); linha =
 * ProjetoApplication.sc.nextLine(); buffWrite.append(linha + "\n");
 * buffWrite.close();
 * 
 * }
 * 
 * }
 */
