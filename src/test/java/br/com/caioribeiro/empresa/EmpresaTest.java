package br.com.caioribeiro.empresa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmpresaTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Empresa empresa = new Empresa();	
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
	
	@Test
	public void deve_testar_se_endereco_esta_preenchido() {		
	}

}
