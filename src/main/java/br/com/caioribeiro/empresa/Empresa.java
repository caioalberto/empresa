/******************************************************************************
 * Produto: Connect Cont                                                      *
 * Contmatic Phoenix © Desde 1986                                             *
 * Tecnologia em Softwares de Gestão Contábil, Empresarial e ERP              *
 * Todos os direitos reservados.                                              *
 *                                                                            *
 *                                                                            *
 *    Histórico:                                                              *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  22/02/2016  ${author}          Classe criada.                  *
 *                                                                            *
 *   Comentários:                                                             *
 *                                                                            *
 *                                                                            *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.caioribeiro.empresa;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.caioribeiro.empresa.stringbuilder.MyStyle;

/**
 *
 * Classe Empresa, define a criacao de um objeto do tipo empresa, assim como
 * seus atributos e metodos.
 *
 * @author Caio Alberto
 */
public class Empresa {

//Variaveis e Constantes-------------------------------------------------------------------------------------   
    
    /**
     * 
     * Define o tamanho de um CNPJ.
     */
    private static final int TAMANHO_CNPJ = 14;
    
    /** Define o tamanho minimo da razao social. */
    private static final int TAMANHO_MINIMO_RAZAO_SOCIAL = 10;
    
    /** Define o tamanho maximo da razao social. */
    private static final int TAMANHO_MAXIMO_RAZAO_SOCIAL = 80;
        
    /**
     * Define uma lista de Enderecos, para armazenar os enderecos de uma empresa
     * caso haja mais de um.
     */
    private List<Endereco> enderecos;

    /**
     * Define uma lista de Telefones, para armazenar os telefones de uma
     * empresa.
     */
    private List<Telefone> telefones;

    /**
     * Define o CNPJ de uma empresa.
     */
    private String cnpj;

    /**
     * Define a razao social de uma empresa.
     */
    private String razaoSocial;

    /**
     * Define o nome fantasia de uma empresa.
     */
    private String nomeFantasia;

    /**
     *
     * Define uma String que armazena o email da empresa.
     */
    private List<Email> emails;

    /**
     *
     * Define a data de cadastro de uma empresa dentro do objeto.
     */
    private Date dataDeCadastro;
    
    /**
     * 
     * Define a data de alteracao de uma empresa dentro do objeto.
     */
    private Date dataDeAlteracao;

//Getters e Setters------------------------------------------------------------------------------------------        
    /**
     * Gets the enderecos.
     *
     * @return the enderecos
     */
    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    /**
     * Gets the telefones.
     *
     * @return the telefones
     */
    public List<Telefone> getTelefones() {
        return telefones;
    }

    /**
     * Gets the cnpj.
     *
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Gets the razao social.
     *
     * @return the razao social
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * Gets the nome fantasia.
     *
     * @return the nome fantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * Gets the emails.
     *
     * @return the emails
     */
    public List<Email> getEmails() {
        return emails;
    }

    /**
     * Gets the data de cadastro.
     *
     * @return the data de cadastro
     */
    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    /**
     * Seta o atributo endereco.
     *
     * @param enderecos novo valor de endereco
     */
    public void setEndereco(List<Endereco> enderecos) {
    	this.verificaSeVazioEnderco(enderecos);
        this.enderecos = enderecos;
    }

    /**
     * Seta o atributo telefone.
     *
     * @param telefones novo valor de telefone
     */
    public void setTelefone(List<Telefone> telefones) {
    	this.validarListaTelefone(telefones);
        this.telefones = telefones;
    }

    /**
     * Seta o atributo cnpj.
     *
     * @param cnpj novo valor de cnpj
     */
    public void setCnpj(String cnpj) {
        this.validarCnpj(cnpj);
        this.cnpj = cnpj;
    }

    /**
     * Seta o atributo razao social.
     *
     * @param razaoSocial novo valor de razao social
     */
    public void setRazaoSocial(String razaoSocial) {
        this.validarRazaoSocial(razaoSocial);
        this.razaoSocial = razaoSocial;
    }

    /**
     * Seta o atributo nome fantasia.
     *
     * @param nomeFantasia novo valor de nome fantasia
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    /**
     * Seta o atributo emails.
     *
     * @param emails novo valor de emails
     */
    public void setEmails(List<Email> emails) {
        this.validarEmails(emails);
        this.emails = emails;
    }

    /**
     * Seta o atributo data de cadastro.
     *
     * @param dataDeCadastro novo valor de data de cadastro
     */
    public void setDataDeCadastro(Date dataDeCadastro) {
        this.validaDataCadastro(dataDeCadastro);
        this.dataDeCadastro = dataDeCadastro;
    }
    
    /**
     * Gets the data de alteracao.
     *
     * @return the data de alteracao
     */
    public Date getDataDeAlteracao() {
        return dataDeAlteracao;
    }
    
    /**
     * Seta o atributo data de alteracao.
     *
     * @param dataDeAlteracao novo valor de data de alteracao
     */
    public void setDataDeAlteracao(Date dataDeAlteracao) {
        this.validaDataDeAlteracao(dataDeAlteracao);
        this.dataDeAlteracao = dataDeAlteracao;
    }
    
  //Metodos de validacao-------------------------------------------------------------------
    
    /**
   * Metodo para a verificacao e validacao da data de cadastro.
   *
   * @param dataDeCadastro the data de cadastro
   */
    public void validaDataCadastro(Date dataDeCadastro) {
        this.verificaDataNula(dataDeCadastro);
        this.verificaSeAntesQueAtual(dataDeCadastro);
        this.verificaSeDepoisQueAtual(dataDeCadastro);
    }

    /**
     * Zerar horas.
     *
     * @param data the data
     * @return o date
     */
    private static Date zerarHoras(Date data) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * Verifica data nula.
     *
     * @param dataDeCadastro the data de cadastro
     */
    public void verificaDataNula(Date dataDeCadastro) {
        this.validaDataDeAlteracao(dataDeCadastro);
        
    }

    /**
     * Verifica se antes que atual.
     *
     * @param dataDeCadastro the data de cadastro
     */
    public void verificaSeAntesQueAtual(Date dataDeCadastro) {
        Date dataAtual = new Date();
        Date dataAtualZerada = zerarHoras(dataAtual);
        Date dataCadastroZerada = zerarHoras(dataDeCadastro);
        checkArgument(!dataCadastroZerada.before(dataAtualZerada), "Não é possível criar um objeto com uma data anterior a atual!");
    }

    /**
     * Verifica se depois que atual.
     *
     * @param dataDeCadastro the data de cadastro
     */
    public void verificaSeDepoisQueAtual(Date dataDeCadastro) {
        Date dataAtual = new Date();
        Date dataAtualZerada = zerarHoras(dataAtual);
        Date dataCadastroZerada = zerarHoras(dataDeCadastro);
        checkArgument(!dataCadastroZerada.after(dataAtualZerada), "Não é possível criar um objeto com uma data posterior a atual!");
    }
    
    /**
     * Valida data de alteracao.
     *
     * @param dataDeAlteracao the data de alteracao
     */
    public void validaDataDeAlteracao(Date dataDeAlteracao) {
        dataDeAlteracao = new Date();
    }
    
    /**
     * Validar cnpj.
     *
     * @param cnpj the cnpj
     */
    public void validarCnpj(String cnpj) {
        this.verificaSeNuloOuVazioCnpj(cnpj);
        this.verificaTamanhoCnpj(cnpj);        
    }
    
    /**
     * Verifica se nulo ou vazio cnpj.
     *
     * @param cnpj the cnpj
     */
    public void verificaSeNuloOuVazioCnpj(String cnpj) {
        checkNotNull(cnpj, "O CNPJ não pode ser nulo!");
        checkArgument(cnpj.length() != 0, "O CNPJ não pode ser vazio!");
    }
        
    /**
     * Verifica tamanho cnpj.
     *
     * @param cnpj the cnpj
     */
    public void verificaTamanhoCnpj(String cnpj) {
        checkArgument(cnpj.length() == TAMANHO_CNPJ, "O CNPJ deve conter exatamente 14 números!");
    }
    
    /**
     * Metodo que verifica a quantidade minima de telefones na empresa.
     *
     * @param telefones the telefones
     */
    public void validarListaTelefone(List<Telefone> telefones){
        this.verificaSeNuloOuVazioTelefone(telefones);
    }
    
    /**
     * Verifica se nulo ou vazio telefone.
     *
     * @param telefones the telefones
     */
    public void verificaSeNuloOuVazioTelefone(List<Telefone> telefones) {
        checkNotNull(telefones, "Empresa não pode ter telefone nulo!");
    	checkArgument(telefones.size() < 0, "Empresa deve ter pelo menos 1 telefone!");
    }
    
    /**
     * Metodo que verifica o preenchimento da razao social, assim como as regras preestabelecidas.
     *
     * @param razaoSocial the razao social
     */
    public void validarRazaoSocial(String razaoSocial) {
        this.verificaSePreenchidaRazaoSocial(razaoSocial);
        this.verificaTamanhoMinimoRazaoSocial(razaoSocial);
        this.verificaTamanhoMaximoRazaoSocial(razaoSocial);
    }
    
    /**
     * Verifica se preenchida razao social.
     *
     * @param razaoSocial the razao social
     */
    public void verificaSePreenchidaRazaoSocial(String razaoSocial) {
        checkNotNull(razaoSocial, "A Razão Social não pode ser nula!");
        checkArgument(razaoSocial.length() != 0, "A Razão Social não pode estar vazia!");
    }
    
    /**
     * Verifica tamanho minimo razao social.
     *
     * @param razaoSocial the razao social
     */
    public void verificaTamanhoMinimoRazaoSocial(String razaoSocial) {
        checkArgument(razaoSocial.length() > TAMANHO_MINIMO_RAZAO_SOCIAL, "A Razão Social deve conter no mínimo 10 caracteres!");
    }
    
    /**
     * Verifica tamanho maximo razao social.
     *
     * @param razaoSocial the razao social
     */
    public void verificaTamanhoMaximoRazaoSocial(String razaoSocial) {
        checkArgument(razaoSocial.length() < TAMANHO_MAXIMO_RAZAO_SOCIAL, "A Razão Social deve conter no máximo 80 caracteres!");
    }

    /**
     * Metodo que verifica a quantidade minima de enderecos na empresa.
     *
     * @param enderecos the enderecos
     */
    public void verificaSeVazioEnderco(List<Endereco> enderecos) {
    	checkArgument(enderecos.size() < 0, "Empresa deve ter pelo menos 1 endereco!");
    }
    	
	/**
	 * Validar emails.
	 *
	 * @param emails the emails
	 */
	public void validarEmails(List<Email> emails) {
	    this.verificarListaEmail(emails);
	}
		
	/**
	 * Verificar lista email.
	 *
	 * @param emails the emails
	 */
	public void verificarListaEmail(List<Email> emails) {
	    checkNotNull(emails, "A lista de emails não pode ser nula!");
	    checkArgument(emails.size() != 0, "Você não pode utilizar uma lista vazia de emails!");	    
	}
	
//hashCode, equals e to String----------------------------------------------------------------------------------------------------    
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
    	return new HashCodeBuilder().append(this.cnpj).toHashCode();
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Empresa)){
			return false;			
		}
		Empresa other = (Empresa) obj;
		return new EqualsBuilder().append(this.cnpj, other.cnpj).isEquals();
	}

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return new ToStringBuilder(this, MyStyle.MY_STYLE)
                .append(this.razaoSocial)
                .append("CNPJ: ", this.cnpj)
                .append("Endereço(s): " + enderecos.toString())
                .append("Contato: " + telefones.toString() + "\n" + emails.toString())
                .append("Data de abertura: " + sdf.format(this.dataDeCadastro)).toString();
    }
}
