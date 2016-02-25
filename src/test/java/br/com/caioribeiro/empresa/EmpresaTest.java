package br.com.caioribeiro.empresa;

import static br.com.caioribeiro.empresa.util.ValidadorUtil.containsError;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * Classe de teste EmpresaTest.
 * 
 * @author Caio Ribeiro
 */
public class EmpresaTest {

    /** The exception. */
    @Rule
    public ExpectedException exception = ExpectedException.none();

    /** A empresa. */
    private Empresa empresa;
    
    /** The emails. */
    private List<Email> emails;
    
    /** The validator. */
    private Validator validator;

    /**
     * Sets the up before.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {

        // Carrega o template de teste para a Empresa.
        FixtureFactoryLoader.loadTemplates("br.com.caioribeiro.empresa.template");

        // Atribui a variavel do objeto empresa, o template "valido".
        empresa = Fixture.from(Empresa.class).gimme("valid");
        emails = Fixture.from(Email.class).gimme(5, "valid");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    // CNPJ----------------------------------------------------------------------------------------------------------------------------
    /**
     * Deve_testar_se_o_cnpj_e_nulo.
     */
    @Test
    public void nao_deve_aceitar_um_cnpj_nulo() {
        empresa.setCnpj(null);
        assertTrue(containsError(validator.validate(empresa), "O CNPJ deve ser preenchido!"));
    }

    /**
     * Nao_deve_aceitar_cnpj_vazio.
     */
    @Test
    public void nao_deve_aceitar_cnpj_vazio() {
        empresa.setCnpj("");
        assertTrue(containsError(validator.validate(empresa), "O CNPJ deve ser preenchido!"));
    }
    
    /**
     * Nao_deve_aceitar_cnpj_menor_que_14.
     */
    @Test
    public void nao_deve_aceitar_cnpj_menor_que_14() {
        empresa.setCnpj("12345789");
        assertTrue(containsError(validator.validate(empresa), "O CNPJ deve ter 14 dígitos!"));
    }

    /**
     * Nao_deve_aceitar_cnpj_tamanho_maior_14.
     */
    @Test
    public void nao_deve_aceitar_cnpj_tamanho_maior_14() {
        empresa.setCnpj("123456789012345");
        assertTrue(containsError(validator.validate(empresa), "O CNPJ deve ter 14 dígitos!"));
    }
    
    @Ignore
    @Test
    public void nao_deve_aceitar_o_cnpj_invalido() {
       empresa.setCnpj("12345678901234");
       //assertTrue(containsError(validator.validate(empresa), "Não é um CNPJ válido"));
    }    

    /**
     * Deve_aceitar_o_cnpj.
     */
    @Test
    public void deve_aceitar_o_cnpj() {
        empresa.setCnpj("12345678901234");
    }

    // Razao Social--------------------------------------------------------------------------------------------------------------------

    /**
     * Nao_deve_aceitar_uma_razao_social_nula.
     */
    @Test
    public void nao_deve_aceitar_uma_razao_social_nula() {
        empresa.setRazaoSocial(null);
        assertTrue(containsError(validator.validate(empresa), "A Razão Social deve ser preenchida!"));
    }

    /**
     * Nao_deve_aceitar_uma_razao_social_vazia.
     */
    @Test
    public void nao_deve_aceitar_uma_razao_social_vazia() {
        //exception.expect(IllegalArgumentException.class);
        //exception.expectMessage("A Razão Social não pode estar vazia!");
        empresa.setRazaoSocial("");
    }

    /**
     * Nao_deve_aceitar_una_razao_social_menor_que_10.
     */
    @Test
    public void nao_deve_aceitar_una_razao_social_menor_que_10() {
        //exception.expect(IllegalArgumentException.class);
        //exception.expectMessage("A Razão Social deve conter no mínimo 10 caracteres!");
        empresa.setRazaoSocial("abc");
    }

    /**
     * Nao_deve_aceitar_uma_razao_social_maior_que_80.
     */
    @Test
    public void nao_deve_aceitar_uma_razao_social_maior_que_80() {
        //exception.expect(IllegalArgumentException.class);
       //exception.expectMessage("A Razão Social deve conter no máximo 80 caracteres!");
        empresa.setRazaoSocial("abcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefghabcdefgh");
    }

    /**
     * Deve_aceitar_a_razao_social.
     */
    @Test
    public void deve_aceitar_a_razao_social() {
        empresa.getRazaoSocial();
    }
    // Data de Cadastro--------------------------------------------------------------------------------------------------------------

    /**
     * Deve_aceitar_uma_data_de_cadastro.
     */
    @Test
    public void deve_aceitar_uma_data_de_cadastro() {
        empresa.setDataDeAlteracao(new Date());
    }

    /**
     * Deve_imprimir_as_datas_de_cadastro_e_de_alteracao.
     */
    // Data de Alteracao--------------------------------------------------------------------------------------------------------------
    @Test
    public void deve_imprimir_as_datas_de_cadastro_e_de_alteracao() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        empresa.setDataDeAlteracao(new Date());
        System.out.println("Data de Alteração: " + sdf.format(empresa.getDataDeAlteracao()));
        System.out.println("Data de Cadastro: " + sdf.format(empresa.getDataDeCadastro()));
    }

    // Email--------------------------------------------------------------------------------------------------------------------------

    /**
     * Deve_aceitar_uma_lista_com_um_email.
     */
    @Test
    public void deve_aceitar_uma_lista_com_um_email() {
        empresa.getEmails();
    }

    /**
     * Nao_deve_aceitar_uma_lista_de_emails_nula.
     */
    @Test
    public void nao_deve_aceitar_uma_lista_de_emails_nula() {
        exception.expect(NullPointerException.class);
        exception.expectMessage("A lista de emails não pode ser nula!");
        empresa.setEmails(null);
    }

    /**
     * Nao_deve_aceitar_uma_lista_de_emails_vazia.
     */
    @Test
    public void nao_deve_aceitar_uma_lista_de_emails_vazia() {
        List<Email> emailsVazio = new ArrayList<>();
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Você não pode utilizar uma lista vazia de emails!");
        empresa.setEmails(emailsVazio);
    }

    /**
     * Deve_testar_se_nome_fantasia_da_empresa_e_nulo.
     */
    @Test
    public void deve_aceitar_o_nome_fantasia() {
        empresa.getNomeFantasia();
    }

    /**
     * Deve_verificar_se_os_enderecos_estao_vazios.
     */
    @Test
    public void deve_aceitar_uma_lista_com_objeto_do_tipo_endereco() {
        empresa.getEnderecos();
    }

    /**
     * Deve_verificar_se_os_telefones_estao_vazios.
     */
    @Test
    public void aceitar_uma_lista_com_objeto_do_tipo_telefone() {
        empresa.getTelefones();
    }
    

    /**
     * Deve_testar_to_string.
     */
    @Test
    public void deve_testar_to_string() {
        empresa.setDataDeAlteracao(new Date());
        System.out.println(empresa);
    }


    
}
