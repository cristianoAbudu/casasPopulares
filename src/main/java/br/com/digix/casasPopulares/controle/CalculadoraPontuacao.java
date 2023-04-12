package br.com.digix.casasPopulares.controle;

import br.com.digix.casasPopulares.dto.FamiliaDTO;

public class CalculadoraPontuacao {
	
	private static CalculadoraPontuacao singleton = new CalculadoraPontuacao();
	
	private CalculadoraPontuacao() {
		
	}
	
	public static CalculadoraPontuacao getInstance() {
		return singleton;
	}
	
	public void calcularPontuacao(FamiliaDTO familia) {
		Integer pontuacao = 0;
		
		pontuacao = pontuacao + calcularPontuacaoRenda(familia.getRendaFamiliarEmCentavos());
		pontuacao = pontuacao + calcularPontuacaoDependentes(familia.getNumeroDependentes());
		
		familia.setPontuacao(pontuacao);
	}

	public Integer calcularPontuacaoRenda(Integer rendaFamiliarEmCentavos) {
		if(rendaFamiliarEmCentavos < 90100) {
		  return 5;
		}
		
		if(rendaFamiliarEmCentavos <= 150000) {
			return 3;
		}
		
		return 0;
	}
	
	public Integer calcularPontuacaoDependentes(Integer numeroDependentes) {
		if(  numeroDependentes > 2) {
		  return 3;
		}
		
		if( numeroDependentes > 0 ) {
			return 2;
		}
		
		return 0;
	}


}
