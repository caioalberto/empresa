package br.com.caioribeiro.empresa;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class EnderecoTest {
	
    @Rule
    public ExpectedException exception = ExpectedException.none();
	
    private Endereco endereco;

    @Before
	public void setUp() {	 
	    FixtureFactoryLoader.loadTemplates("br.com.caioribeiro.empresa.template");		
	    endereco = Fixture.from(Endereco.class).gimme("valid");
		System.out.println("Before");
	}

//Logradouro----------------------------------------------------------------------------
	@Test 
	public void nao_deve_aceitar_logradouro_com_menos_de_5_caracteres() {
	   exception.expect(IllegalArgumentException.class);
	   exception.expectMessage("Logradouro não pode conter menos de 5 caracteres!");
	   endereco.setLogradouro("aaa");
	}
	
	@Test 
	public void nao_deve_aceitar_logradouro_com_mais_de_80_caracteres() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Logradouro não pode conter mais de 80 caracteres!");
		endereco.setLogradouro("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	@Test 
	public void nao_deve_aceitar_logradouro_nulo() {
		exception.expect(NullPointerException.class);
		exception.expectMessage("Logradouro não pode estar vazio/nulo!");
		endereco.setLogradouro(null);
	}
	
	@Test
	public void deve_aceitar_o_logradouro() {
		assertNotNull(endereco.getLogradouro());
	}
	
//Bairro----------------------------------------------------------------------------------	
	@Test 
	public void nao_deve_aceitar_bairro_com_menos_de_6_letras() {	    
	    exception.expect(IllegalArgumentException.class);
	    exception.expectMessage("O bairro não pode conter menos de 6 letras!");
	    endereco.setBairro("abc");
	}
	
	@Test 
	public void nao_deve_aceitar_bairro_com_mais_de_80_letras() {
	    exception.expect(IllegalArgumentException.class);
	    exception.expectMessage("O bairro não pode conter mais de 80 letras!");
		endereco.setBairro("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	@Test 
	public void nao_deve_aceitar_bairro_nulo() {
		exception.expect(NullPointerException.class);
		exception.expectMessage("Bairro não pode estar vazio/nulo!");
		endereco.setBairro(null);
	}
	
	@Test 
	public void deve_aceitar_o_bairro() {
		endereco.setBairro("Jardim Flor da Montanha");
	}

//CEP-------------------------------------------------------------------------------------------	
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
	
//Cidade-------------------------------------------------------------------------------	
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
	
//Estado--------------------------------------------------------------------------------	
	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_excecao_de_tamanho_minimo_do_estado() {
		endereco.setEstado("A");
	}
		
	@Test
    public void deve_gerar_excecao_de_estado_nulo() {
        exception.expect(NullPointerException.class);
        exception.expectMessage("O estado não pode ser nulo/vazio!");
        endereco.setEstado(null);
    }
	
	@Test
	public void deve_aceitar_o_estado() {
		endereco.setEstado("SP");
	}
	
//Pais---------------------------------------------------------------------------------	
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
	
//Numero--------------------------------------------------------------------------------	
	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_uma_excecao_de_numero_nao_preenchido() {
		endereco.setNumero(0);
	}
	
	@Test
	public void deve_aceitar_o_numero() {
		endereco.getNumero();
	}

//Ignore---------------------------------------------------------------------------------	
	@Ignore
	public void deve_ignorar_teste() {
		endereco.setBairro(null);
	}

//Timeout--------------------------------------------------------------------------------	
	@Test(timeout = 500)
	public void deve_retornar_o_endereco_em_25_milissegundos() throws InterruptedException {
		Thread.sleep(500);
	}

//Teste do toString()--------------------------------------------------------------------	
	@Test
	public void deve_listar_as_informacoes_do_endereco_corretamente() {
		endereco = Fixture.from(Endereco.class).gimme("valid");
		System.out.println(endereco);
	}
}
