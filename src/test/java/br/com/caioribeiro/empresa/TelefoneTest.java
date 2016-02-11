package br.com.caioribeiro.empresa;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
		telefones = new ArrayList<>();
		t1 = new Telefone();
		t2 = new Telefone();
		t3 = new Telefone();
		this.addTelefones();		
	}
	
	public void addTelefones() {
		telefones.add(t1);
		telefones.add(t2);
		telefones.add(t3);
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
	
	@Test (expected = IllegalArgumentException.class)
	public void deve_gerar_uma_excecao_de_tamanho_de_ddd() {
		t1.setDdd(000);		
	}
	
	@Test
	public void deve_aceitar_o_numero_do_ddd() {
		telefone.setDdd(11);
	}
	
	@Test
	public void deve_listar_as_informacoes_do_telefone() {
		telefone.setDdd(11);
		telefone.setTelefone("24594064");
		System.out.println(telefone);
	}

}
