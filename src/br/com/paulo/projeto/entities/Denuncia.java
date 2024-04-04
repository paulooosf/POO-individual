package br.com.paulo.projeto.entities;

import java.time.LocalDate;

public class Denuncia {
	
	private int id;
	private LocalDate data;
	private String detalhamento;
	private boolean anonimo;
	private int fkUsu;
	
	public Denuncia() {
		super();
	}

	public Denuncia(int id, LocalDate data, String detalhamento, boolean anonimo, int fkUsu) {
		super();
		this.id = id;
		this.data = data;
		this.detalhamento = detalhamento;
		this.anonimo = anonimo;
		this.fkUsu = fkUsu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getDetalhamento() {
		return detalhamento;
	}

	public void setDetalhamento(String detalhamento) {
		this.detalhamento = detalhamento;
	}

	public boolean isAnonimo() {
		return anonimo;
	}

	public void setAnonimo(boolean anonimo) {
		this.anonimo = anonimo;
	}

	public int getFkUsu() {
		return fkUsu;
	}

	public void setFkUsu(int fkUsu) {
		this.fkUsu = fkUsu;
	}
}
