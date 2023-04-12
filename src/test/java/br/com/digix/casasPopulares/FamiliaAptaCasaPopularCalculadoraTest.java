package br.com.digix.casasPopulares;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.digix.casasPopulares.controle.FamiliaAptaCasaPopularCalculadora;
import br.com.digix.casasPopulares.dto.FamiliaDTO;

public class FamiliaAptaCasaPopularCalculadoraTest {

	@Test
	public void ordemTest() {
		List<FamiliaDTO> familiaList = new ArrayList<>();
		
		FamiliaDTO silva = new FamiliaDTO();
		silva.setSobrenome("Silva");
		silva.setNumeroDependentes(0); //0 pontos
		silva.setRendaFamiliarEmCentavos(190100); //0 pontos
		familiaList.add(silva); // total 0 pontos, ultima da lista

		FamiliaDTO carrara = new FamiliaDTO();
		carrara.setSobrenome("Carrara");
		carrara.setNumeroDependentes(1);// 2 pontos
		carrara.setRendaFamiliarEmCentavos(90000); // 5 pontos
		familiaList.add(carrara); // total 5 pontos, 1a da lista
		
		assertTrue(familiaList.get(0).getSobrenome().equals("Silva"));
		assertTrue(FamiliaAptaCasaPopularCalculadora.getInstance().calcularPontuacao(familiaList).get(0).getSobrenome().equals("Carrara"));
	}
	

}
