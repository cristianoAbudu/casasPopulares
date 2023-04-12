package br.com.digix.casasPopulares;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.digix.casasPopulares.controle.CalculadoraPontuacao;
import br.com.digix.casasPopulares.dto.FamiliaDTO;

public class CalculadoraPontuacaoTest {


	@Test
	public void pontuacaoRendaTest() {
		assertTrue(CalculadoraPontuacao.getInstance().calcularPontuacaoRenda(89999) == 5);
		assertTrue(CalculadoraPontuacao.getInstance().calcularPontuacaoRenda(90000) == 5);
		assertTrue(CalculadoraPontuacao.getInstance().calcularPontuacaoRenda(90099) == 5);
		assertTrue(CalculadoraPontuacao.getInstance().calcularPontuacaoRenda(90100) == 3);
		assertTrue(CalculadoraPontuacao.getInstance().calcularPontuacaoRenda(149999) == 3);
		assertTrue(CalculadoraPontuacao.getInstance().calcularPontuacaoRenda(150000) == 3);
		assertTrue(CalculadoraPontuacao.getInstance().calcularPontuacaoRenda(150001) == 0);
		assertTrue(CalculadoraPontuacao.getInstance().calcularPontuacaoRenda(200001) == 0);
	}
	
	@Test
	public void pontuacaoDependentesTest() {
		assertTrue(CalculadoraPontuacao.getInstance().calcularPontuacaoDependentes(1000) == 3);
		assertTrue(CalculadoraPontuacao.getInstance().calcularPontuacaoDependentes(3) == 3);
		assertTrue(CalculadoraPontuacao.getInstance().calcularPontuacaoDependentes(2) == 2);
		assertTrue(CalculadoraPontuacao.getInstance().calcularPontuacaoDependentes(1) == 2);
		assertTrue(CalculadoraPontuacao.getInstance().calcularPontuacaoDependentes(0) == 0);
	}
	
	
	@Test
	public void calcularPontuacaoTest() {
		FamiliaDTO familia = new FamiliaDTO();
		familia.setRendaFamiliarEmCentavos(89999); // vale 5 pontos
		familia.setNumeroDependentes(1); // vale 2 pontos
		
		CalculadoraPontuacao.getInstance().calcularPontuacao(familia);
		assertTrue(familia.getPontuacao() == 7);
	}
	
	@Test
	public void calcularPontuacaoFamiliaSemRendaEsemDependentesTest() {
		FamiliaDTO familia = new FamiliaDTO();
		
		CalculadoraPontuacao.getInstance().calcularPontuacao(familia);
		assertTrue(familia.getPontuacao() == 5);
	}
	
	@Test
	public void calcularPontuacaoFamiliaSemRendaComDependentesTest() {
		FamiliaDTO familia = new FamiliaDTO();
		familia.setNumeroDependentes(3);
		
		CalculadoraPontuacao.getInstance().calcularPontuacao(familia);
		assertTrue(familia.getPontuacao() == 8);
	}
	

}
