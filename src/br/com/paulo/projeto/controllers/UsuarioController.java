package br.com.paulo.projeto.controllers;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.paulo.projeto.entities.Usuario;
import br.com.paulo.projeto.services.UsuarioService;
import br.com.paulo.util.Util;

public class UsuarioController {
	
	static Logger logger = Util.setupLogger();
	Usuario usuario = new Usuario();
	
	public void listarNomes() throws IOException {
		List<Usuario> usuarios = UsuarioService.listaNomesUsuarios();
		Util.customizer();
		
		logger.log(Level.INFO, () -> usuarios + "\n\nLista gerada com sucesso!");
	}
}
