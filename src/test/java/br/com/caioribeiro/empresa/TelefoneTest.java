package br.com.caioribeiro.empresa;

import static br.com.caioribeiro.empresa.util.ValidadorUtil.containsError;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

/**
 * The Class TelefoneTest.
 *
 * @author Caio Ribeiro
 */
public class TelefoneTest {
    
    @Rule
    public ExpectedException exception = ExpectedException.none();

	/** The telefones. */
	//private List<Telefone> telefones;
	
	/** The t3. */
	private Telefone telefone = new Telefone();
	private Telefone t1, t2;
	
	private Validator validator;

	/**
	 * Set up before class.
	 */
	@Before
	public void setUp() {
		//Carregando os templates de teste
		FixtureFactoryLoader.loadTemplates("br.com.caioribeiro.empresa.template");
		
//		//Atribuindo aos objetos um template
//		telefone = Fixture.from(Telefone.class).gimme("valid");
//		t1 = Fixture.from(Telefone.class).gimme("valid");
//		t2 = Fixture.from(Telefone.class).gimme("valid");
//		t3 = Fixture.from(Telefone.class).gimme("valid");
		
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
	}
//Numero do Telefone--------------------------------------------------------------------------------------------------------------------	
	@Test 
	public void nao_deve_aceitar_um_telefone_nulo() {
	    telefone.setTelefone(null);
	    assertTrue(containsError(validator.validate(telefone), "O telefone não pode estar vazio!"));
	}
	
	@Test
	public void nao_deve_aceitar_um_telefone_vazio() {
	    telefone.setTelefone("");
	    assertTrue(containsError(validator.validate(telefone), "O telefone não pode estar vazio!"));
	}
	
	@Test 
	public void nao_deve_aceitar_um_telefone_com_menos_de_8() {
		telefone.setTelefone("123");
		assertTrue(containsError(validator.validate(telefone), "O telefone não pode ter menos de 8 dígitos e mais de 9 dígitos!"));
	}
	
	/**
	 * Deve_gerar_uma_excecao_de_tamanho_maximo_do_telefone.
	 */
	@Test 
	public void nao_deve_aceitar_um_telefone_com_mais_de_9() {
		telefone.setTelefone("1234567890");
		assertTrue(containsError(validator.validate(telefone), "O telefone não pode ter menos de 8 dígitos e mais de 9 dígitos!"));
	}
	
	
	/**
	 * Deve_aceitar_o_numero_do_telefone.
	 */
	@Test
	public void deve_aceitar_o_numero_do_telefone() {
	    String telefoneComparar = "24594064";
		telefone.setTelefone(telefoneComparar);
		assertEquals(telefoneComparar, telefone.getTelefone());
	}
	
//DDD-----------------------------------------------------------------------------------------------------------------------------	
	
	@Test
	public void nao_deve_aceitar_um_ddd_nulo() {
	    telefone.setDdd(null);
	    assertTrue(containsError(validator.validate(telefone), "O DDD não pode estar vazio!"));
	}
	
	@Test
	public void nao_deve_aceitar_um_ddd_vazio() {
	    telefone.setDdd("");
	    assertTrue(containsError(validator.validate(telefone), "O DDD não pode estar vazio!"));
	}
	
	@Test
	public void nao_deve_aceitar_um_ddd_maior_que_2() {
	    telefone.setDdd("123");
	    assertTrue(containsError(validator.validate(telefone), "O DDD não pode ter tamanho diferente de 2!"));
	}
	
	@Test
	public void nao_deve_aceitar_um_ddd_menor_que_2() {
	    telefone.setDdd("1");
	    assertTrue(containsError(validator.validate(telefone), "O DDD não pode ter tamanho diferente de 2!"));
	}
	
	/**
	 * Deve_aceitar_o_numero_do_ddd.
	 */
	@Test
	public void deve_aceitar_o_numero_do_ddd() {
	    String dddCompair = "18";
		telefone.setDdd(dddCompair);
		assertEquals(dddCompair, telefone.getDdd());
	}
	
//Contrato equals hashCode-------------------------------------------------------------------------------------------------------- 	
	/**
	 * Deve_respeitar_o_contrato_equals_e_hashcode.
	 */
	@Test
	public void deve_respeitar_o_contrato_equals_e_hashcode() {
		EqualsVerifier.forClass(Telefone.class).suppress(Warning.NONFINAL_FIELDS).verify();
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
//	@Test
//	public void deve_retornar_se_a_lista_contem_os_objetos() {
//		assertThat(telefones, hasItems(t1,t2,t3,telefone));
//	}
//	
	/**
	 * Deve_retornar_se_sao_os_mesmos_numeros_de_telefone.
	 */
	@Test
	public void deve_retornar_se_sao_os_mesmos_numeros_de_telefone(){
		telefone.getTelefone();
		t1.getTelefone();
		assertThat(telefone.getTelefone(), is(not(equalTo(t1.getTelefone()))));
	}
		
	@Test
	public void deve_retornar_o_tipo_do_telefone_como_celular(){
	    Telefone tel36 = new Telefone();
	    tel36.setTelefone("966560001");
	    tel36.setTipo(TipoTelefone.CELULAR);
	    System.out.println(tel36.getTipo());
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
		
}
