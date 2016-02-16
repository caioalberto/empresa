package br.com.caioribeiro.empresa;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class TelefoneTest {

	private List<Telefone> telefones;
	static Telefone telefone, t1, t2, t3;

	@BeforeClass
	public static void setUpBeforeClass() {
		telefone = new Telefone();	
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
		
		t1 = new Telefone();
		t2 = new Telefone();
		t3 = new Telefone();
		
		this.addTelefones();
	}
		
		public void addTelefones() {			
			telefones.add(t1);
			telefones.add(t2);
			telefones.add(t3);
			System.out.println("Lista preenchida");
		}
	

	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}
		
	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_uma_excecao_de_tamanho_minimo_do_telefone() {
		telefone.setTelefone("112233");
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
		telefone.setTelefone("12345678");
	}
	
	@Test (expected = NullPointerException.class)
	public void deve_gerar_uma_excecao_de_tamanho_de_ddd() {
		t1.setDdd(0);		
	}
	
	@Test
	public void deve_aceitar_o_numero_do_ddd() {
		telefone.setDdd(11);
	}
	
	@Test
	public void deve_listar_as_informacoes_do_telefone() {
		telefone.setDdd(11);
		telefone.setTelefone("24594064");
	    telefone.setTipo("Fixo");
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
		telefone.setTelefone("24594064");
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
		telefone.setTelefone("12345678");
		t1.setTelefone("87654321");
		assertThat(telefone.getTelefone(), is(not(equalTo(t1.getTelefone()))));
	}
}
