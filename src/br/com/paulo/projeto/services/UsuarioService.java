package br.com.paulo.projeto.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.paulo.projeto.entities.Usuario;
import br.com.paulo.projeto.io.RelatorioIO;

public class UsuarioService {

	public static List<Usuario> listaUsuarios() throws IOException {

		List<Usuario> listaNomesUsuarios = new ArrayList<>();

		for (Usuario usuario : Usuario.getMapaUsuarios().values()) {
			listaNomesUsuarios.add(usuario);
		}
		return listaNomesUsuarios;
	}
	
	public static void relatorioUsuarios() throws IOException {
		RelatorioIO.relatorioListaUsuarios(listaUsuarios());
	}
}
