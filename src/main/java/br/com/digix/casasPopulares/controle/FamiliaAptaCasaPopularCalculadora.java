package br.com.digix.casasPopulares.controle;

import java.util.List;
import java.util.stream.Collectors;

import br.com.digix.casasPopulares.dto.FamiliaDTO;

public class FamiliaAptaCasaPopularCalculadora {
	
	private static FamiliaAptaCasaPopularCalculadora singleton = new FamiliaAptaCasaPopularCalculadora();
	
	private FamiliaAptaCasaPopularCalculadora() {
		
	}
	
	public static FamiliaAptaCasaPopularCalculadora getInstance() {
		return singleton;
	}
	
	public List<FamiliaDTO> calcularPontuacao(List<FamiliaDTO> familiaList) {
		familiaList.stream().forEach(
			familia ->{
				CalculadoraPontuacao.getInstance().calcularPontuacao(familia);
			}
		);
		return familiaList.stream()
				.sorted(
					(familia1,familia2)-> familia2.getPontuacao().compareTo(familia1.getPontuacao())
				)
				.collect(Collectors.toList());
	}


}
