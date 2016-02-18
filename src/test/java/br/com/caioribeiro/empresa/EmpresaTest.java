package br.com.caioribeiro.empresa;

import static org.junit.Assert.assertNotEquals;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class EmpresaTest {
	
	private static Empresa empresa;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresa = new Empresa();	
		FixtureFactoryLoader.loadTemplates("br.com.caioribeiro.empresa.template");
		System.out.println("Before Class");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before");
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}
	
	@Test 
	public void deve_testar_a_data_de_cadastro_da_empresa() {
		empresa = Fixture.from(Empresa.class).gimme("valid");
		assertNotEquals("Não pode ser esta data", new Date(), empresa.getDataDeCadastro());
		System.out.println(empresa.getDataDeCadastro());
	}
	
	@Test
	public void deve_listar_as_informacoes_da_empresa() {
		empresa = Fixture.from(Empresa.class).gimme("valid");
		System.out.println(empresa);
	}
	
	@Test
	public void deve_imprimir_uma_lista_de_telefones_do_tipo_comercial_e_residencial() {
		List<Telefone> telefones = Fixture.from(Telefone.class).gimme(5, "valid");
		empresa.imprimirTelefones(telefones);
	}
	
	@Test
	public void deve_imprimir_uma_lista_de_telefones_do_tipo_celular() {
		List<Telefone> celular = Fixture.from(Telefone.class).gimme(2, "celular");
		empresa.imprimirTelefones(celular);
	}
			
}
