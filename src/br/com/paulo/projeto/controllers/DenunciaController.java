package br.com.paulo.projeto.controllers;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.paulo.projeto.entities.Denuncia;
import br.com.paulo.projeto.services.DenunciaService;
import br.com.paulo.util.Util;

public class DenunciaController {

	DenunciaService denunciaService = new DenunciaService();
	static Logger logger = Util.setupLogger();
	Denuncia denuncia = new Denuncia();
	
	public void listarDenuncias() throws IOException {
		List<Denuncia> denuncias = DenunciaService.listaDenuncias();
		Util.customizer();
		
		logger.log(Level.INFO, () -> denuncias + "\n\nLista gerada com sucesso!");
	}
	
	public void listarDenunciaUsuario() throws IOException {
		denunciaService.listaDenunciaUsuario();
		Util.customizer();
		logger.log(Level.INFO, "\n\nLista gerada com sucesso!");
	}
}
