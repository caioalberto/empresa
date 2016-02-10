package br.com.caioribeiro.empresa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EnderecoTest {

	static Endereco endereco;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		endereco = new Endereco();	
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

	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_erro_de_tamanho_minimo_de_logradouro() {
		endereco.setLogradouro("Rua 2");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_erro_de_tamanho_maximo_de_logradouro() {
		endereco.setLogradouro("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
	}
	
	@Test
	public void deve_aceitar_o_logradouro() {
		endereco.setLogradouro("Rua José dos Santos");
	}
	
	

}
