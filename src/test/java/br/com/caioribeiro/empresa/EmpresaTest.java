package br.com.caioribeiro.empresa;

import static br.com.caioribeiro.empresa.util.ValidadorUtil.containsError;
import static br.com.six2six.fixturefactory.Fixture.from;
import static org.joda.time.DateTime.now;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

/**
 * Classe de teste EmpresaTest.
 * 
 * @author Caio Ribeiro
 */
public class EmpresaTest {

    /** A empresa. */
    private Empresa empresa;
    
    /** The emails. */
    private Set<Email> emails;
    
    /**The telefones. */
    private Set<Telefone> telefones;
    
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
       empresa = from(Empresa.class).gimme("valid");
       
        
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    // CNPJ----------------------------------------------------------------------------------------------------------------------------

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
       assertTrue(containsError(validator.validate(empresa), "Não é um CNPJ válido"));
    }    

    /**
     * Deve_aceitar_o_cnpj.
     */
    @Test
    public void deve_aceitar_o_cnpj() {
        String cnpj = "12345678901234";
        empresa.setCnpj(cnpj);
        assertEquals("12345678901234", empresa.getCnpj());
    }

    // Razao Social--------------------------------------------------------------------------------------------------------------------

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
        empresa.setRazaoSocial("");
        assertTrue(containsError(validator.validate(empresa), "A Razão Social deve ser preenchida!"));
    }

    /**
     * Nao_deve_aceitar_uma_razao_social_menor_que_10.
     */
    @Test
    public void nao_deve_aceitar_uma_razao_social_menor_que_10() {
        empresa.setRazaoSocial("abc");
        assertTrue(containsError(validator.validate(empresa), "A Razão Social deve ter entre 10 e 80 letras!"));
    }

    /**
     * Nao_deve_aceitar_uma_razao_social_maior_que_80.
     */
    @Test
    public void nao_deve_aceitar_uma_razao_social_maior_que_80() {
        empresa.setRazaoSocial("\\w{80}");
        assertTrue(containsError(validator.validate(empresa), "A Razão Social deve ter entre 10 e 80 letras!"));
    }

    /**
     * Deve_aceitar_a_razao_social.
     */
    @Test
    public void deve_aceitar_a_razao_social() {
        empresa.setRazaoSocial("Teste de Razão Social LTDA.");
        assertEquals("Teste de Razão Social LTDA.", empresa.getRazaoSocial());
    }
    // Nome Fantasia-----------------------------------------------------------------------------------------------------------------
   
    @Test
    public void nao_deve_aceitar_um_nome_fantasia_nulo() {
        empresa.setNomeFantasia(null);
        assertTrue(containsError(validator.validate(empresa), "O Nome Fantasia deve ser preenchido!"));
    }
    
    @Test
    public void nao_deve_aceitar_um_nome_fantasia_vazio() {
        empresa.setNomeFantasia("");
        assertTrue(containsError(validator.validate(empresa), "O Nome Fantasia deve ser preenchido!"));
    }
    
    @Test
    public void nao_deve_aceitar_um_nome_fantasia_com_menos_de_10_letras() {
        empresa.setNomeFantasia("abc");
        assertTrue(containsError(validator.validate(empresa), "O Nome Fantasia deve conter mais de 10 e menos de 80 letras!"));
    }
    
    @Test
    public void nao_deve_aceitar_um_nome_fantasia_com_mais_de_80_letras() {
        empresa.setNomeFantasia("\\w{80}");
        assertTrue(containsError(validator.validate(empresa), "O Nome Fantasia deve conter mais de 10 e menos de 80 letras!"));
    }
    
    @Test
    public void deve_aceitar_o_nome_fantasia() {
        String nomeFantasia = "Nome Fantasia";
        empresa.setNomeFantasia(nomeFantasia);
        assertEquals("Nome Fantasia", empresa.getNomeFantasia());
    }
    
    // Data de Cadastro--------------------------------------------------------------------------------------------------------------
    @Test
    public void nao_deve_aceitar_uma_data_de_cadastro_nula() {
        empresa.setDataDeCadastro(null);
        assertTrue(containsError(validator.validate(empresa), "A data não pode ser nula!"));
    }
    
    @Test
    public void nao_deve_aceitar_uma_data_posterior_a_atual() {
        empresa.setDataDeCadastro(now().plusDays(20));
        assertTrue(containsError(validator.validate(empresa), "A data não pode ser posterior a data atual!"));
    }
    
    @Test
    public void deve_aceitar_uma_data_de_cadastro() {
        empresa.setDataDeCadastro(now());
        assertEquals(now(), empresa.getDataDeCadastro());
    }

    /**
     * Deve_imprimir_as_datas_de_cadastro_e_de_alteracao.
     */
    // Data de Alteracao--------------------------------------------------------------------------------------------------------------
    @Test
    public void nao_deve_aceitar_uma_data_de_alteracao_nula() {
        empresa.setDataDeAlteracao(null);
    }
    
    @Test
    public void nao_deve_aceitar_uma_data_de_alteracao_anterior_a_data_de_criacao() {
        empresa.setDataDeAlteracao(now().minusYears(16));
        empresa.setDataDeCadastro(now());
        assertTrue(containsError(validator.validate(empresa), "A data não pode ser anterior a data atual!"));
    }
    
    @Test
    public void deve_aceitar_uma_data_de_alteracao() {
        DateTime dataCadastro = now().minusMonths(2);
        DateTime dataAlteracao = now();
        assertTrue(dataCadastro.isBefore(dataAlteracao));
    }

    // Email--------------------------------------------------------------------------------------------------------------------------
    
    /**
     * Nao_deve_aceitar_uma_lista_de_emails_nula.
     */
    @Test
    public void nao_deve_aceitar_uma_lista_de_emails_nula() {
        empresa.setEmails(null);
        assertTrue(containsError(validator.validate(empresa), "A lista de E-mails não pode estar vazia!"));
    }

    /**
     * Nao_deve_aceitar_uma_lista_de_emails_vazia.
     */
    @Test
    public void nao_deve_aceitar_uma_lista_de_emails_vazia() {
        empresa.setEmails(emails);
        assertTrue(containsError(validator.validate(empresa), "A lista de E-mails não pode estar vazia!"));
    }
//Email------------------------------------------------------------------------------------------------------------------------------
    
    @Test
    public void nao_deve_aceitar_uma_lista_telefones_nula() {
        empresa.setTelefone(null);
        assertTrue(containsError(validator.validate(empresa), "A lista de telefones não pode estar vazia!"));
    }
    
    @Test
    public void nao_deve_aceitar_uma_lista_de_telefones_vazia() {
        empresa.setTelefone(telefones);
        assertTrue(containsError(validator.validate(empresa), "A lista de telefones não pode estar vazia!"));
    }
 //Equals e hashCode-----------------------------------------------------------------------------------------------------------------   
    
    @Test
    public void deve_respeitar_o_contrato_equals_e_hashcode() {
        EqualsVerifier.forClass(Empresa.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }
    
    @Test
    public void um() {
        empresa = from(Empresa.class).gimme("empresa_com_celular");
        System.out.println(empresa);
    }
}
