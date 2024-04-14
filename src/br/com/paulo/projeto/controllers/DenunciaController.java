package br.com.paulo.projeto.controllers;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.paulo.projeto.entities.*;
import br.com.paulo.projeto.io.RelatorioIO;
import br.com.paulo.projeto.services.DenunciaService;
import br.com.paulo.projeto.services.UsuarioService;
import br.com.paulo.util.Util;

public class DenunciaController {

	public static Logger logger = Util.setupLogger();
	Denuncia denuncia = new Denuncia();
	
	public static void listarDenuncias() throws IOException {
		List<Denuncia> denuncias = DenunciaService.listaDenuncias();
		Util.customizer();
		
		logger.log(Level.INFO, () -> denuncias.toString().replace("[", "").replace("]", "").replace(",", "") + "\n\nLista gerada com sucesso!\n");
	}
	
	public static void listarDenunciasUsuarios() throws IOException {
	    DenunciaService.listaDenunciasUsuarios();
	    
	    logger.log(Level.INFO, "\nLista gerada com sucesso!\n");
	}

	public static void relatorioDenunciaUsuario() throws IOException {
		RelatorioIO.relatorioListaDenunciaUsuario(DenunciaService.listaDenuncias(), UsuarioService.listaUsuarios());
	}
	
	public static void relatorioDenuncias() throws IOException {
		RelatorioIO.relatorioListaDenuncia(DenunciaService.listaDenuncias());
	}
}
