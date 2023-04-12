package br.com.digix.casasPopulares.dto;

public class FamiliaDTO {
	
	private String sobrenome;
	
	private Integer numeroDependentes = 0;
	
	private Integer rendaFamiliarEmCentavos = 0;
	
	private Integer pontuacao = 0;

	public Integer getNumeroDependentes() {
		return numeroDependentes;
	}

	public void setNumeroDependentes(Integer numeroDependentes) {
		this.numeroDependentes = numeroDependentes;
	}

	public Integer getRendaFamiliarEmCentavos() {
		return rendaFamiliarEmCentavos;
	}

	public void setRendaFamiliarEmCentavos(Integer rendaFamiliarEmCentavos) {
		this.rendaFamiliarEmCentavos = rendaFamiliarEmCentavos;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

	

}
