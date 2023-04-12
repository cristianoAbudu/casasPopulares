package br.com.digix.casasPopulares.modelo;

import java.util.Date;


public class Pessoa {
	private String nome;
	private String sobrenome;
	private Integer rendaEmCentavos;
	private Date dataNascimento;
	private Pessoa pai1;
	private Pessoa pai2;
	
	public Pessoa(String nome, String sobrenome, Integer rendaEmCentavos, Date dataNascimento, Pessoa pai1,
			Pessoa pai2) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.rendaEmCentavos = rendaEmCentavos;
		this.dataNascimento = dataNascimento;
		this.pai1 = pai1;
		this.pai2 = pai2;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Integer getRendaEmCentavos() {
		return rendaEmCentavos;
	}
	public void setRendaEmCentavos(Integer rendaEmCentavos) {
		this.rendaEmCentavos = rendaEmCentavos;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Pessoa getPai1() {
		return pai1;
	}
	public void setPai1(Pessoa pai1) {
		this.pai1 = pai1;
	}
	public Pessoa getPai2() {
		return pai2;
	}
	public void setPai2(Pessoa pai2) {
		this.pai2 = pai2;
	}

}
