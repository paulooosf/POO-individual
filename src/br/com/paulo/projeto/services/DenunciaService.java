package br.com.paulo.projeto.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import br.com.paulo.projeto.controllers.DenunciaController;
import br.com.paulo.projeto.entities.Denuncia;
import br.com.paulo.projeto.entities.Usuario;
import br.com.paulo.util.Util;

public class DenunciaService {

	public static List<Denuncia> listaDenuncias() throws IOException {

		List<Denuncia> listaDenuncias = new ArrayList<>();

		for (Denuncia denuncia : Denuncia.getMapaDenuncias().values()) {

			listaDenuncias.add(denuncia);
		}
		return listaDenuncias;
	}
	
	public static void listaDenunciasUsuarios() throws IOException {
		List<Denuncia> denuncias = listaDenuncias();
	    List<Usuario> usuarios = UsuarioService.listaUsuarios();
	    Util.customizer();

	    for (Denuncia denuncia : denuncias) {
	        Util.customizer();
	        if (denuncia.getAnonimo() == true) {
	            DenunciaController.logger.log(Level.INFO, () -> " + Denúncia ID " + denuncia.getId() + " | Detalhamento: " + denuncia.getDetalhamento()
	                        + " | Usuário: Anônimo");
	        } else {
	            for (Usuario usuario : usuarios) {
	                Util.customizer();
	                if (denuncia.getFkUsu() == usuario.getId()) {
	                    DenunciaController.logger.log(Level.INFO, () -> " + Denúncia ID " + denuncia.getId() + " | Detalhamento: " + denuncia.getDetalhamento()
	                                + " | Usuário: " + usuario.getNome() + " | CPF: " + usuario.getCpf());	                    
	                }
	            }
	        }
	    }
	}
}
