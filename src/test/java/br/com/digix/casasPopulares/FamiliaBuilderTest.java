package br.com.digix.casasPopulares;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.digix.casasPopulares.controle.FamiliaBuilder;
import br.com.digix.casasPopulares.dto.FamiliaDTO;
import br.com.digix.casasPopulares.modelo.Pessoa;

public class FamiliaBuilderTest {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	public void builderTest() throws ParseException {
		
		List<Pessoa> pessoas = new ArrayList<>();

		Pessoa lineu = new Pessoa("Lineu", "Silva",500000, sdf.parse("01/03/1950"), null, null);
		pessoas.add(lineu);
		Pessoa nene = new Pessoa("Irene", "Silva",0, sdf.parse("12/01/1960"), null, null);
		pessoas.add(nene);
		Pessoa tuco = new Pessoa("Arthur", "Silva",80000, sdf.parse("22/03/1970"), lineu, nene);
		pessoas.add(tuco);
		
		Pessoa bebel = new Pessoa("Maria Isabel", "Carrara",80000, sdf.parse("05/03/1980"), lineu, nene);
		pessoas.add(bebel);
		Pessoa agostinho = new Pessoa("Agostinho", "Carrara",80000, sdf.parse("16/08/1980"), null, null);
		pessoas.add(agostinho);
		Pessoa floriano = new Pessoa("Floriano", "Carrara",0, sdf.parse("22/12/2010"), agostinho, bebel);
		pessoas.add(floriano);
		
		
		List<FamiliaDTO> familias = FamiliaBuilder.getInstance().construirFamilia(pessoas);
		
		assertTrue(familias.get(0).getSobrenome().equals("Carrara"));
		assertTrue(familias.get(1).getSobrenome().equals("Silva"));
		
		assertTrue(familias.get(0).getRendaFamiliarEmCentavos().equals(160000));
		assertTrue(familias.get(1).getRendaFamiliarEmCentavos().equals(580000));

		assertTrue(familias.get(0).getNumeroDependentes().equals(1));
		assertTrue(familias.get(1).getNumeroDependentes().equals(0));
		
	}
	

}
