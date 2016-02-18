package br.com.caioribeiro.empresa;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

/**
 * The Class TelefoneTest.
 *
 * @author Caio Ribeiro
 */
public class TelefoneTest {

	/** The telefones. */
	private List<Telefone> telefones;
	
	/** The t3. */
	static Telefone telefone, telefoneInvalido, t1, t2, t3;

	/**
	 * Set up before class.
	 */
	@BeforeClass
	public static void setUpBeforeClass() {
		
		FixtureFactoryLoader.loadTemplates("br.com.caioribeiro.empresa.template");
		
		telefone = new Telefone();
		telefoneInvalido = new Telefone();
				
		t1 = new Telefone();
		t2 = new Telefone();
		t3 = new Telefone();
		
		telefone = Fixture.from(Telefone.class).gimme("valid");
		telefoneInvalido = Fixture.from(Telefone.class).gimme("invalid");
		
		t1 = Fixture.from(Telefone.class).gimme("valid");
		t2 = Fixture.from(Telefone.class).gimme("valid");
		t3 = Fixture.from(Telefone.class).gimme("valid");
		
		
		
		System.out.println("Before Class");
		System.out.println("Telefone criado");
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class");
	}

	/**
	 * Set up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("Before");		
		telefones = new ArrayList<Telefone>();
		this.addTelefones();
	}
		
		/**
		 * Add telefones.
		 */
		public void addTelefones() {			
			telefones.add(t1);
			telefones.add(t2);
			telefones.add(t3);
			telefones.add(telefone);
			System.out.println("Lista preenchida");
		}
	

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}
		
	/**
	 * Deve_gerar_uma_excecao_de_tamanho_minimo_do_telefone.
	 */
	@Test 
	public void deve_gerar_uma_excecao_de_tamanho_minimo_do_telefone() {
		telefoneInvalido.getTelefone();
		System.out.println(telefoneInvalido);
	}
	
	/**
	 * Deve_gerar_uma_excecao_de_tamanho_maximo_do_telefone.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_uma_excecao_de_tamanho_maximo_do_telefone() {
		telefone.setTelefone("1234567890");
	}
	
	/**
	 * Deve_gerar_uma_excecao_de_telefone_nulo.
	 */
	@Test (expected = NullPointerException.class)
	public void deve_gerar_uma_excecao_de_telefone_nulo() {
		telefone.setTelefone(null);
	}
	
	/**
	 * Deve_aceitar_o_numero_do_telefone.
	 */
	@Test
	public void deve_aceitar_o_numero_do_telefone() {
		assertNotNull(telefone);
	}
	
	/**
	 * Deve_gerar_uma_excecao_de_tamanho_de_ddd.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_uma_excecao_de_tamanho_de_ddd() {
		telefone.setDdd(00);	
	}
	
	/**
	 * Deve_aceitar_o_numero_do_ddd.
	 */
	@Test
	public void deve_aceitar_o_numero_do_ddd() {
		assertNotNull(telefone.getDdd());
	}
	
	/**
	 * Deve_listar_as_informacoes_do_telefone.
	 */
	@Test
	public void deve_listar_as_informacoes_do_telefone() {		
		System.out.println(telefone);
	}
	
	
	/**
	 * Deve_respeitar_o_contrato_equals_e_hashcode.
	 */
	@Test
	public void deve_respeitar_o_contrato_equals_e_hashcode() {
		EqualsVerifier.forClass(Telefone.class).suppress(Warning.NONFINAL_FIELDS).verify();
	}
	
	/**
	 * Deve_aceitar_apenas_numeros.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void deve_aceitar_apenas_numeros() {
		telefone.setTelefone("a");						
	}
	
	/**
	 * Deve_aceitar_o_telefone.
	 */
	@Test
	public void deve_aceitar_o_telefone() {
		assertNotNull(telefone.getTelefone());
	}
	
		
	/**
	 * Deve_dizer_se_o_telefone_esta_na_lista_de_telefones.
	 */
	@Test
	public void deve_dizer_se_o_telefone_esta_na_lista_de_telefones() {
		assertThat(telefone, isIn(telefones));
	}
	
	/**
	 * Deve_retornar_se_o_objeto_e_da_mesma_instancia.
	 */
	@Test
	public void deve_retornar_se_o_objeto_e_da_mesma_instancia() {
		assertThat(telefone, instanceOf(Telefone.class));
	}
	
	/**
	 * Deve_retornar_se_o_numero_do_telefone_comeca_com_determinado_caractere.
	 */
	@Test
	public void deve_retornar_se_o_numero_do_telefone_comeca_com_determinado_caractere() {
		telefone.setTelefone("24594064");
		assertThat(telefone.getTelefone(), startsWith("24"));
	}
	
	/**
	 * Deve_retornar_se_os_objetos_sao_da_mesma_instancia.
	 */
	@Test
	public void deve_retornar_se_os_objetos_sao_da_mesma_instancia() {
		assertThat(t1, is(equalTo(t2))); 
	}
	
	/**
	 * Deve_retornar_se_a_lista_contem_os_objetos.
	 */
	@Test
	public void deve_retornar_se_a_lista_contem_os_objetos() {
		assertThat(telefones, hasItems(t1,t2,t3,telefone));
	}
	
	/**
	 * Deve_retornar_se_sao_os_mesmos_numeros_de_telefone.
	 */
	@Test
	public void deve_retornar_se_sao_os_mesmos_numeros_de_telefone(){
		telefone.getTelefone();
		t1.getTelefone();
		assertThat(telefone.getTelefone(), is(not(equalTo(t1.getTelefone()))));
	}
		
	/**
	 * Deve_assumir_a_excecao_e_rodar_mesmo_assim.
	 */
	@Test
	public void deve_assumir_a_excecao_e_rodar_mesmo_assim() {
		try {
			t1.setTelefone(null);
		} catch (NullPointerException e) {
			Assume.assumeNoException(e);
		}
	}
	
	/**
	 * Deve_gerar_uma_lista_de_telefones_validos_e_imprimi_los_na_tela.
	 */
	@Test
	public void deve_gerar_uma_lista_de_telefones_validos_e_imprimi_los_na_tela() {
		List<Telefone> telefones = Fixture.from(Telefone.class).gimme(5, "valid");
		System.out.println(telefones);
	}
	
}
