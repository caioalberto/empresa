package br.com.caioribeiro.empresa;

import static com.google.common.base.Strings.isNullOrEmpty;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * Classe de teste EmpresaTest.
 * @author Caio Ribeiro
 */
public class EmpresaTest {

	/** A empresa. */
	private Empresa empresa;
	
	/**  Listas de objetos. */
	private List<Telefone> telefones;
	
	/** The celular. */
	private List<Telefone> celular;
	
	/** The enderecos. */
	private List<Endereco> enderecos;

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUpBeforeClass() throws Exception {

		//Carrega o template de teste para a Empresa.
		FixtureFactoryLoader.loadTemplates("br.com.caioribeiro.empresa.template");
		
		//Atribui a variavel do objeto empresa, o template "valido".
		empresa = Fixture.from(Empresa.class).gimme("valid");
		
		//Atribui a variavel de lista de telefones, 5 objetos do template "valido".
		telefones = Fixture.from(Telefone.class).gimme(5, "valid");
		celular = Fixture.from(Telefone.class).gimme(2, "celular");
		enderecos = Fixture.from(Endereco.class).gimme(2, "valid");
				
	}

	/**
	 * Deve_testar_se_o_cnpj_e_nulo.
	 */
	@Test
	public void deve_testar_se_o_cnpj_e_nulo() {
		assertNotNull("O CNPJ não pode ser nulo!", empresa.getCnpj());
		assertFalse("O CNPJ não pode estar vazio", isNullOrEmpty(empresa.getCnpj()));
	}
	
	/**
	 * Nao_deve_receber_uma_data_de_cadastro_nula.
	 */
	@Test
	public void nao_deve_receber_uma_data_de_cadastro_nula() {
		assertNotNull("A data não pode ser nula!", empresa.getDataDeCadastro());
	}
	
	/**
	 * Deve_testar_se_os_emails_sao_validos.
	 */
	@Test
	public void deve_testar_se_os_emails_sao_validos() {
		assertNotNull("Os emails não podem ser nulos", empresa.getEmail());
		assertFalse("Os emails não podem estar vazios!", isNullOrEmpty(empresa.getEmail()));
	}
	
	/**
	 * Deve_testar_se_os_enderecos_sao_validos.
	 */
	@Test
	public void deve_testar_se_os_enderecos_sao_validos() {
		assertNotNull("Os endereços não podem ser nulos!", empresa.getEnderecos());
		assertFalse("Os endereços não podem estar vazios!", empresa.getEnderecos().size() == 0);
	}
	
	/**
	 * Deve_testar_se_nome_fantasia_da_empresa_e_nulo.
	 */
	@Test
	public void deve_testar_se_nome_fantasia_da_empresa_e_nulo() {
		assertNotNull("O nome fantasia não pode ser nulo!", empresa.getNomeFantasia());
		assertFalse("A empresa não pode ser vazia/nula!", isNullOrEmpty(empresa.getNomeFantasia()));
	}
	
	/**
	 * Deve_testar_se_razao_social_da_empresa_e_nula.
	 */
	@Test
	public void deve_testar_se_razao_social_da_empresa_e_nula() {
		assertNotNull("A razão social não pode ser vazia!", empresa.getRazaoSocial());
		assertFalse("A empresa não pode ser vazia/nula!", isNullOrEmpty(empresa.getRazaoSocial()));
	}
	
	/**
	 * Deve_verificar_se_os_enderecos_estao_vazios.
	 */
	@Test
	public void deve_verificar_se_os_enderecos_estao_vazios() {
	    empresa.getEnderecos();
	}
	
	/**
	 * Deve_verificar_se_os_telefones_estao_vazios.
	 */
	@Test
	public void deve_verificar_se_os_telefones_estao_vazios() {		
	    empresa.getTelefones();
	}
	
	/**
	 * Deve_testar_to_string.
	 */
	@Test
	public void deve_testar_to_string() {
		System.out.println(empresa);
	}

}
