package br.com.caioribeiro.empresa;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
    
    @Rule
    public ExpectedException exception = ExpectedException.none();

	/** The telefones. */
	private List<Telefone> telefones;
	
	/** The t3. */
	static Telefone telefone, telefoneInvalido, t1, t2, t3;

	/**
	 * Set up before class.
	 */
	@BeforeClass
	public static void setUpBeforeClass() {
		//Carregando os templates de teste
		FixtureFactoryLoader.loadTemplates("br.com.caioribeiro.empresa.template");
		
		//Atribuindo aos objetos um template
		telefone = Fixture.from(Telefone.class).gimme("valid");
		t1 = Fixture.from(Telefone.class).gimme("valid");
		t2 = Fixture.from(Telefone.class).gimme("valid");
		t3 = Fixture.from(Telefone.class).gimme("valid");
	}
	
	@Test 
	public void nao_deve_aceitar_um_telefone_nulo() {
	    exception.expect(NullPointerException.class);
	    exception.expectMessage("O telefone não pode ser nulo!");
	    telefone.setTelefone(null);
	}
	
	@Test
	public void nao_deve_aceitar_um_telefone_vazio() {
	    exception.expect(IllegalArgumentException.class);
	    exception.expectMessage("O telefone não pode estar vazio!");
	    telefone.setTelefone("");
	}
	
	@Test 
	public void nao_deve_aceitar_um_telefone_com_menos_de_8() {
	    exception.expect(IllegalArgumentException.class);
	    exception.expectMessage("O telefone não deve conter menos do que 8 caracteres!");
		telefone.setTelefone("123");
	}
	
	/**
	 * Deve_gerar_uma_excecao_de_tamanho_maximo_do_telefone.
	 */
	@Test 
	public void nao_deve_aceitar_um_telefone_com_mais_de_9() {
	    exception.expect(IllegalArgumentException.class);
	    exception.expectMessage("O telefone não deve conter mais do que 9 caracteres");
		telefone.setTelefone("1234567890");
	}
	
	
	/**
	 * Deve_aceitar_o_numero_do_telefone.
	 */
	@Test
	public void deve_aceitar_o_numero_do_telefone() {
		telefone.setTelefone("24594064");
	}
	
	/**
	 * Deve_gerar_uma_excecao_de_tamanho_de_ddd.
	 */
	@Test 
	public void nao_deve_aceitar_o_ddd_00() {
	    exception.expect(IllegalArgumentException.class);
	    exception.expectMessage("O DDD não pode ser 0!");
		telefone.setDdd(00);	
	}
	
	@Test
	public void nao_deve_aceitar_um_ddd_diferente_de_2() {
	    exception.expect(IllegalArgumentException.class);
	    exception.expectMessage("O DDD deve ser 2!");
	    telefone.setDdd(123);
	}
	
	/**
	 * Deve_aceitar_o_numero_do_ddd.
	 */
	@Test
	public void deve_aceitar_o_numero_do_ddd() {
		telefone.setDdd(18);
	}
	
	@Test
	public void deve_testar_to_string_de_telefone() {		
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
	 * Nao_deve_aceitar_caracteres_diferentes_de_numero.
	 */
	@Test
	public void nao_deve_aceitar_caracteres_diferentes_de_numero() {
	    exception.expect(IllegalArgumentException.class);
	    exception.expectMessage("Você deve inserir apenas números!");
		telefone.setTelefone("a");						
	}
	
	/**
	 * Deve_aceitar_o_telefone.
	 */
	@Test
	public void deve_aceitar_o_telefone() {
		telefone.setTelefone("24555510");
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
