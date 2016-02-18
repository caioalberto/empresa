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

public class TelefoneTest {

	private List<Telefone> telefones;
	static Telefone telefone, telefoneInvalido, t1, t2, t3;

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

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before");		
		telefones = new ArrayList<Telefone>();
		this.addTelefones();
	}
		
		public void addTelefones() {			
			telefones.add(t1);
			telefones.add(t2);
			telefones.add(t3);
			telefones.add(telefone);
			System.out.println("Lista preenchida");
		}
	

	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}
		
	@Test 
	public void deve_gerar_uma_excecao_de_tamanho_minimo_do_telefone() {
		telefoneInvalido.getTelefone();
		System.out.println(telefoneInvalido);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_uma_excecao_de_tamanho_maximo_do_telefone() {
		telefone.setTelefone("1234567890");
	}
	
	@Test (expected = NullPointerException.class)
	public void deve_gerar_uma_excecao_de_telefone_nulo() {
		telefone.setTelefone(null);
	}
	
	@Test
	public void deve_aceitar_o_numero_do_telefone() {
		assertNotNull(telefone);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_uma_excecao_de_tamanho_de_ddd() {
		telefone.setDdd(00);	
	}
	
	@Test
	public void deve_aceitar_o_numero_do_ddd() {
		assertNotNull(telefone.getDdd());
	}
	
	@Test
	public void deve_listar_as_informacoes_do_telefone() {		
		System.out.println(telefone);
	}
	
	
	@Test
	public void deve_respeitar_o_contrato_equals_e_hashcode() {
		EqualsVerifier.forClass(Telefone.class).suppress(Warning.NONFINAL_FIELDS).verify();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deve_aceitar_apenas_numeros() {
		telefone.setTelefone("a");						
	}
	
	@Test
	public void deve_aceitar_o_telefone() {
		assertNotNull(telefone.getTelefone());
	}
	
		
	@Test
	public void deve_dizer_se_o_telefone_esta_na_lista_de_telefones() {
		assertThat(telefone, isIn(telefones));
	}
	
	@Test
	public void deve_retornar_se_o_objeto_e_da_mesma_instancia() {
		assertThat(telefone, instanceOf(Telefone.class));
	}
	
	@Test
	public void deve_retornar_se_o_numero_do_telefone_comeca_com_determinado_caractere() {
		telefone.setTelefone("24594064");
		assertThat(telefone.getTelefone(), startsWith("24"));
	}
	
	@Test
	public void deve_retornar_se_os_objetos_sao_da_mesma_instancia() {
		assertThat(t1, is(equalTo(t2))); 
	}
	
	@Test
	public void deve_retornar_se_a_lista_contem_os_objetos() {
		assertThat(telefones, hasItems(t1,t2,t3,telefone));
	}
	
	@Test
	public void deve_retornar_se_sao_os_mesmos_numeros_de_telefone(){
		telefone.getTelefone();
		t1.getTelefone();
		assertThat(telefone.getTelefone(), is(not(equalTo(t1.getTelefone()))));
	}
	
	@Test
	public void teste() {
		Empresa empresa = new Empresa();
		empresa.novo(telefones);
	}
	
	@Test
	public void deve_assumir_a_excecao_e_rodar_mesmo_assim() {
		try {
			t1.setTelefone(null);
		} catch (NullPointerException e) {
			Assume.assumeNoException(e);
		}
	}
}
