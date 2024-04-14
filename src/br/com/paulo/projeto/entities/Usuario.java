package br.com.paulo.projeto.entities;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
	
	private Integer id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	private String genero;
	
	static Map<Integer, Usuario> mapaUsuarios = new HashMap<>();
	
	public Usuario() {
		super();
	}

	public Usuario(Integer id, String nome, String email, String telefone, String cpf, String genero) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.genero = genero;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public static Map<Integer, Usuario> getMapaUsuarios() {
		return mapaUsuarios;
	}

	@Override
	public String toString() {
		return "\n + Usuario ID " + id + " | Nome: " + nome + " | E-mail: " + email + " | Telefone: " + telefone + " | CPF: " + cpf
				+ " | Gênero: " + genero;
	}
	
}
