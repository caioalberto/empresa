package br.com.caioribeiro.empresa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class EnderecoTest {

	static Endereco endereco;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		endereco = new Endereco();
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

	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_erro_de_tamanho_minimo_de_logradouro() {
		endereco.setLogradouro("Rua 2");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_erro_de_tamanho_maximo_de_logradouro() {
		endereco.setLogradouro("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
	}
	
	@Test (expected = NullPointerException.class)
	public void deve_gerar_excecao_de_logradouro_nulo() {
		endereco.setLogradouro(null);
	}
	
	@Test
	public void deve_aceitar_o_logradouro() {
		endereco.setLogradouro("Rua José dos Santos");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_excecao_de_tamanho_minimo_do_bairro() {
		endereco.setBairro("aa");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_excecao_de_tamanho_maximo_do_bairro() {
		endereco.setBairro("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	@Test (expected = NullPointerException.class)
	public void deve_gerar_excecao_de_bairro_nulo() {
		endereco.setBairro(null);
	}
	
	@Test 
	public void deve_aceitar_o_bairro() {
		endereco.setBairro("Jardim Flor da Montanha");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_excecao_do_tamanho_minimo_do_cep() {
		endereco.setCep("000");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_excecao_do_tamanho_do_cep() {
		endereco.setCep("0000000000");
	}
	
	@Test (expected = NullPointerException.class)
	public void deve_gerar_uma_excecao_de_cep_nulo() {
		endereco.setCep(null);
	}
	
	@Test
	public void deve_aceitar_o_cep() {
		endereco.setCep("07097-170");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_excecao_de_tamanho_minimo_da_cidade() {
		endereco.setCidade("ABC");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_excecao_de_tamanho_maximo_da_cidade() {
		endereco.setCidade("ABCABCABCABCABCABCABCABCABCABCABCABCABC");
	}
	
	@Test (expected = NullPointerException.class)
	public void deve_gerar_excecao_de_cidade_nula() {
		endereco.setCidade(null);
	}
	
	@Test
	public void deve_aceitar_cidade() {
		endereco.setCidade("Guarulhos");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_excecao_de_tamanho_minimo_do_estado() {
		endereco.setEstado("A");
	}
		
	@Test (expected = NullPointerException.class)
	public void deve_gerar_excecao_de_estado_nulo() {
		endereco.setEstado(null);
	}
	
	@Test
	public void deve_aceitar_o_estado() {
		endereco.setEstado("SP");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_excecao_de_tamanho_minimo_de_pais() {
		endereco.setPais("BR");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_excecao_de_tamanho_maximo_de_pais() {
		endereco.setPais("BRBRBRBRBRBRBRBRBRBRBRBR");
	}
	
	@Test (expected = NullPointerException.class)
	public void deve_gerar_excecao_de_pais_nulo() {
		endereco.setPais(null);
	}
	
	@Test
	public void deve_aceitar_pais() {
		endereco.getPais();
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_uma_excecao_de_numero_nao_preenchido() {
		endereco.setNumero(0);
	}
	
	@Test
	public void deve_aceitar_o_numero() {
		endereco.getNumero();
	}
	
	@Ignore
	public void deve_ignorar_teste() {
		endereco.setBairro(null);
	}
	
	@Test(timeout = 500)
	public void deve_retornar_o_endereco_em_25_milissegundos() throws InterruptedException {
		Thread.sleep(500);
	}
	
	@Test
	public void deve_listar_as_informacoes_do_endereco_corretamente() {
		endereco = Fixture.from(Endereco.class).gimme("valid");
		System.out.println(endereco);
	}
}
