package br.com.paulo.projeto.controllers;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.paulo.projeto.entities.Usuario;
import br.com.paulo.projeto.io.RelatorioIO;
import br.com.paulo.projeto.services.UsuarioService;
import br.com.paulo.util.Util;

public class UsuarioController {
	
	static Logger logger = Util.setupLogger();
	Usuario usuario = new Usuario();
	
	public static void listarUsuarios() throws IOException {
		List<Usuario> usuarios = UsuarioService.listaUsuarios();
		Util.customizer();
		
		logger.log(Level.INFO, () -> usuarios.toString().replace("[", "").replace("]", "").replace(",", "") + "\n\nLista gerada com sucesso!\n");
	}
	
	public static void relatorioUsuarios() throws IOException {
		RelatorioIO.relatorioListaUsuarios(UsuarioService.listaUsuarios());
	}
}
