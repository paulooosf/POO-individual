package br.com.paulo.projeto.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.paulo.projeto.entities.Usuario;

public class UsuarioService {

	public static List<Usuario> listaUsuarios() throws IOException {

		List<Usuario> listaNomesUsuarios = new ArrayList<>();

		for (Usuario usuario : Usuario.getMapaUsuarios().values()) {
			listaNomesUsuarios.add(usuario);
		}
		return listaNomesUsuarios;
	}
}
