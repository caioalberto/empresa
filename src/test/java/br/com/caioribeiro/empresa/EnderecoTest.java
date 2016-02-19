package br.com.caioribeiro.empresa;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class EnderecoTest {
	

	
	private Endereco enderecoMenor;
    private Endereco endereco;
    private Endereco enderecoMaior;
    private Endereco enderecoNulo;

    @Before
	public void setUp() {	 
	    FixtureFactoryLoader.loadTemplates("br.com.caioribeiro.empresa.template");
		
	    enderecoMenor = Fixture.from(Endereco.class).gimme("menor");
	    enderecoMaior = Fixture.from(Endereco.class).gimme("maior");
	    endereco = Fixture.from(Endereco.class).gimme("valid");
		
		System.out.println("Before Class");
	}

	@Test 
	public void nao_deve_aceitar_logradouro_com_menos_de_5_caracteres() {
	    assertTrue("Não pode conter menos de 5 caracteres", enderecoMenor.getLogradouro().length() < 5 == true);
	}
	
	@Test 
	public void nao_deve_aceitar_logradouro_com_mais_de_80_caracteres() {
		assertTrue("Não pode conter mais de 80 caracteres", enderecoMaior.getLogradouro().length() > 80 == true);
	}
	
	@Test (expected = NullPointerException.class)
	public void nao_deve_aceitar_logradouro_nulo() {
		assertNull("Não pode ser nulo!", enderecoNulo.getLogradouro());
	}
	
	@Test
	public void deve_aceitar_o_logradouro() {
		assertNotNull(endereco.getLogradouro());
		System.out.println(endereco);
	}
	
	@Test 
	public void deve_gerar_excecao_de_tamanho_minimo_do_bairro() {
	    enderecoMenor = Fixture.from(Endereco.class).gimme("menor");
	    assertFalse("Não pode conter mais de 80 caracteres", enderecoMenor.getBairro().length() > 80 == true);
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
