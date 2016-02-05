package br.com.caioribeiro.empresa;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmpresaTest {

	@Test
	public void deve_testar_se_endereco_esta_preenchido() {		
		Empresa empresa = new Empresa();
		empresa.setEndereco("Rua José dos Santos, Nº 143. Picanço - Guarulhos/SP");		
	}

}
