package br.com.paulo.projeto.entities;

import java.time.LocalDate;

public class Denuncia {
	
	private Integer id;
	private LocalDate data;
	private String detalhamento;
	private Boolean anonimo;
	private Integer fkUsu;
	
	public Denuncia() {
		super();
	}

	public Denuncia(Integer id, LocalDate data, String detalhamento, Boolean anonimo, Integer fkUsu) {
		super();
		this.id = id;
		this.data = data;
		this.detalhamento = detalhamento;
		this.anonimo = anonimo;
		this.fkUsu = fkUsu;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Boolean getAnonimo() {
		return anonimo;
	}

	public void setAnonimo(Boolean anonimo) {
		this.anonimo = anonimo;
	}

	public Integer getFkUsu() {
		return fkUsu;
	}

	public void setFkUsu(Integer fkUsu) {
		this.fkUsu = fkUsu;
	}
}
