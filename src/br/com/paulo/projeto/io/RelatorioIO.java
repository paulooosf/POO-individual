package br.com.paulo.projeto.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.text.DateFormatter;

import br.com.paulo.projeto.entities.Denuncia;
import br.com.paulo.projeto.entities.Usuario;
import br.com.paulo.projeto.enums.TipoRegistro;
import br.com.paulo.util.Util;

public class RelatorioIO {

	static final String CAMINHO_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";
	private static Logger logger = Util.setupLogger();
	static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	static DateTimeFormatter dtfBr = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public static void leitor(String path) throws IOException {
		
		BufferedReader buffRead = new BufferedReader(new FileReader(CAMINHO_BASICO + path + EXTENSAO));
		String linha = "";
		
		while (true) {			
			linha = buffRead.readLine();			
			if (linha != null) {				
				String[] dados = linha.split(";");				
				if (dados[0].equalsIgnoreCase(TipoRegistro.DENUNCIA.name())) {					
					Denuncia denuncia = new Denuncia(Integer.parseInt(dados[1]), LocalDate.parse(dados[2]), dados[3], Boolean.parseBoolean(dados[4]), Integer.parseInt(dados[5]));
					Denuncia.getMapaDenuncias().put(Integer.parseInt(dados[1]), denuncia);
				} else if (dados[0].equalsIgnoreCase(TipoRegistro.USUARIO.name())) {					
					Usuario usuario = new Usuario(Integer.parseInt(dados[1]), dados[2], dados[3], dados[4], dados[5],
							dados[6]);
					Usuario.getMapaUsuarios().put(Integer.parseInt(dados[1]), usuario);
				}				
			} else {				
				break;
			}
		}
		buffRead.close();
	}

	public static void relatorioListaUsuarios(List<Usuario> nomesUsuarios) throws IOException {
		
		String nome = "lista-usuarios";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(CAMINHO_BASICO + nome + EXTENSAO, true));

		buffWrite.append(">======= RELATÓRIO: LISTA DE USUARIOS =======<\n\n");		
		if (!nomesUsuarios.isEmpty()) {			
			for (Usuario usuario : nomesUsuarios) {
				buffWrite.append(" ID: " + usuario.getId() + " | Nome: " + usuario.getNome() + " | CPF: " + usuario.getCpf() 
								+ " | Telefone: " + usuario.getTelefone() + "\n");				
			}
		}		
		LocalDateTime ldt = LocalDateTime.now();
		buffWrite.append("\n Data da requisição: " + dtfBr.format(ldt));
		buffWrite.append("\n\n>=============== FIM DA LISTA ===============<\n\n");
		buffWrite.close();		
	}
	
	public static void relatorioListaDenuncia(List<Denuncia> denuncias) throws IOException {
		
		String nome = "lista-denuncias";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(CAMINHO_BASICO + nome + EXTENSAO, true));

		buffWrite.append(">======= RELATÓRIO: LISTA DE DENUNCIAS =======<\n\n");		
		if (!denuncias.isEmpty()) {
			for (Denuncia denuncia : denuncias) {				
				buffWrite.append(" ID: " + denuncia.getId() + " | Data: " + denuncia.getData().format(formato) +  " | Detalhamento: " 
								+ denuncia.getDetalhamento() + " | Anônimo: " + denuncia.getAnonimo() + "\n");				
			}
		}		
		LocalDateTime ldt = LocalDateTime.now();
		buffWrite.append("\n Data da requisição: " + dtfBr.format(ldt));
		buffWrite.append("\n\n>=============== FIM DA LISTA ===============<\n\n");
		buffWrite.close();
		
	}
	
	public static void relatorioListaDenunciaUsuario(List<Denuncia> denuncias, List<Usuario> usuarios) throws IOException {
		
		String nome = "lista-denuncias-usuarios";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(CAMINHO_BASICO + nome + EXTENSAO, true));

		buffWrite.append(">======= RELATÓRIO: LISTA DE DENUNCIAS POR USUARIOS =======<\n\n");
		
		if (!denuncias.isEmpty() && !usuarios.isEmpty()) {			
			for (Denuncia denuncia : denuncias) {				
				for (Usuario usuario : usuarios) {					
					if (denuncia.getFkUsu() == usuario.getId()) {						
						if (denuncia.getAnonimo() == false) {
							buffWrite.append(" ID: " + denuncia.getId() + " | Data: " + denuncia.getData().format(formato) 
											+ " | Detalhamento: " + denuncia.getDetalhamento() + " | Usuário: " + usuario.getNome() 
											+ " | CPF: " + usuario.getCpf() + "\n");									
						} else if (denuncia.getAnonimo() == true) {							
							buffWrite.append(" ID: " + denuncia.getId() + " | Data: " + denuncia.getData().format(formato) 
											+ " | Detalhamento: " + denuncia.getDetalhamento() + " | Usuário: Anônimo\n");
						}
					}
				}
			}
		}		
		LocalDateTime ldt = LocalDateTime.now();
		buffWrite.append("\n Data da requisição: " + dtfBr.format(ldt));
		buffWrite.append("\n\n>====================== FIM DA LISTA ======================<\n\n");
		buffWrite.close();
	}
}