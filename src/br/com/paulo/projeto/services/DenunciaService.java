package br.com.paulo.projeto.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.paulo.projeto.entities.Denuncia;
import br.com.paulo.projeto.io.RelatorioIO;

public class DenunciaService {

	public static List<Denuncia> listaDenuncias() throws IOException {

		List<Denuncia> listaDenuncias = new ArrayList<>();

		for (Denuncia denuncia : Denuncia.getMapaDenuncias().values()) {

			listaDenuncias.add(denuncia);
		}
		RelatorioIO.relatorioListaDenuncia(listaDenuncias);
		return listaDenuncias;
	}
	
	public void listaDenunciaUsuario() throws IOException {
		RelatorioIO.relatorioListaDenunciaUsuario(listaDenuncias(), UsuarioService.listaNomesUsuarios());
	}
}
