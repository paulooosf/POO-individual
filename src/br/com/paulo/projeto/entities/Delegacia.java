package br.com.paulo.projeto.entities;

public class Delegacia {
	
	private int id;
	private int numPoliciais;
	private int numProcessos;
	
	public Delegacia() {
		super();
	}

	public Delegacia(int id, int numPoliciais, int numProcessos) {
		super();
		this.id = id;
		this.numPoliciais = numPoliciais;
		this.numProcessos = numProcessos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumPoliciais() {
		return numPoliciais;
	}

	public void setNumPoliciais(int numPoliciais) {
		this.numPoliciais = numPoliciais;
	}

	public int getNumProcessos() {
		return numProcessos;
	}

	public void setNumProcessos(int numProcessos) {
		this.numProcessos = numProcessos;
	}
}
