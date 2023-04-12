package br.com.digix.casasPopulares.controle;

import java.util.*;

import br.com.digix.casasPopulares.modelo.Pessoa;
import br.com.digix.casasPopulares.dto.FamiliaDTO;

public class FamiliaBuilder {
	
	private static FamiliaBuilder singleton = new FamiliaBuilder();
	
	private FamiliaBuilder() {
	}
	
	public static FamiliaBuilder getInstance() {
		return singleton;
	}
	
	public List<FamiliaDTO> construirFamilia(List<Pessoa> pessoaList) {
		
		List<FamiliaDTO> retorno = new ArrayList<>();
		
		Map<String, List<Pessoa>> separaPorSobrenome = separaPorSobrenome(pessoaList);
		
		separaPorSobrenome.keySet().stream()
			.forEach(
				sobrenome -> {
					FamiliaDTO familia = new FamiliaDTO();
					
					familia.setSobrenome(sobrenome);
					List<Pessoa> familiaAsList = separaPorSobrenome.get(sobrenome);
					familiaAsList.stream().forEach(
						pessoa -> {
							familia.setRendaFamiliarEmCentavos(familia.getRendaFamiliarEmCentavos()+pessoa.getRendaEmCentavos());
							if(
								pessoa.getPai1()!=null
								&&
								pessoa.getPai2()!=null
								&&
								calculaIdade(pessoa)<=18
							) {	
								familia.setNumeroDependentes(familia.getNumeroDependentes()+1);
							}
						}
					);
					retorno.add(familia);
				}
		);
		
		 
		return retorno;
	}

	private Map<String, List<Pessoa>> separaPorSobrenome(List<Pessoa> pessoaList) {
		Map<String, List<Pessoa>> mapaSobrenome = new HashMap<>();
		
		pessoaList.forEach(pessoa -> {
			
			if(mapaSobrenome.get(pessoa.getSobrenome())==null) {
				List<Pessoa> familiaAsList = new ArrayList<Pessoa>();
				familiaAsList.add(pessoa);
				mapaSobrenome.put(pessoa.getSobrenome(), familiaAsList);			
			}else {
				mapaSobrenome.get(pessoa.getSobrenome()).add(pessoa);
			}
			
		});
		
		return mapaSobrenome;
	}
	
	private Integer calculaIdade(Pessoa pessoa) {
		// Data de hoje.
 		GregorianCalendar agora = new GregorianCalendar();
 		int ano = 0, 
			mes = 0, dia = 0;
 		
		// Data do nascimento.
 		GregorianCalendar nascimento = new GregorianCalendar();
 		int anoNasc = 0, 
			mesNasc = 0, diaNasc = 0;

 		// Idade.
 		int idade = 0;
 		
 		if(pessoa.getDataNascimento() != null){
 			nascimento.setTime(pessoa.getDataNascimento());
 	 		
 			ano = agora.get(Calendar.YEAR);
 	 		mes = agora.get(Calendar.MONTH) + 1;
 	 		dia = agora.get(Calendar.DAY_OF_MONTH);
 	 		
 	 		anoNasc = nascimento.get(Calendar.YEAR);
 	 		mesNasc = nascimento.get(Calendar.MONTH) + 1;
 	 		diaNasc = nascimento.get(Calendar.DAY_OF_MONTH);
 	 		
 	 		idade = ano - anoNasc;
 	 		
 	 		// Calculando diferencas de mes e dia.
 	 		if(mes < mesNasc) {
 	 			idade--;
 	 		} else {
 	 			if(dia < diaNasc) {
 	 				idade--;
 	 			}
 	 		}
 	 		
 	 		// Ultimo teste, idade "negativa".
 	 		if(idade < 0) {
 	 			idade = 0;
 	 		}
 	 		
 		}

 		return (idade);	
		
	}
	
	

}
